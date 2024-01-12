package com.technical.webapp.springboottechinal.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.technical.webapp.springboottechinal.models.Entity.Empresa;
import com.technical.webapp.springboottechinal.service.IEmpresa;


@RestController
@RequestMapping("/api/v1")
public class EmpresaController {

    @Autowired
    private IEmpresa empresaService;

    @PostMapping("/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    //Se usa nuevamente el save gracias al uso de CrudRpository el cual identifica si el registro ya existe para actualizarlo
    @PutMapping("/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public Empresa update(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Empresa empresaDelete = empresaService.findById(id);
            empresaService.deleteEmpresa(empresaDelete);
            return new ResponseEntity<>(empresaDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDae) {
            //control para error 500 en caso de borrar una identidad que no existe
            response.put("Mensaje", exDae.getMessage());
            response.put("Empresa", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/empresa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Empresa showById(@PathVariable Integer id){
        return empresaService.findById(id);
    }
    
}
