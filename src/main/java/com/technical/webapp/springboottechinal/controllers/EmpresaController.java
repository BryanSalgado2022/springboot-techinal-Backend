package com.technical.webapp.springboottechinal.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.technical.webapp.springboottechinal.models.Entity.Empresa;
import com.technical.webapp.springboottechinal.service.IEmpresa;


@RestController
@RequestMapping("/api/v1")
public class EmpresaController {

    @Autowired
    private IEmpresa empresaService;

    @PostMapping("/empresa")
    public Empresa create(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    //Se usa nuevamente el save gracias al uso de CrudRpository el cual identifica si el registro ya existe para actualizarlo
    @PutMapping("/empresa")
    public Empresa update(@RequestBody Empresa empresa){
        return empresaService.saveEmpresa(empresa);
    }

    @DeleteMapping("/empresa/{id}")
    public void delete(@PathVariable Integer id){
        Empresa empresaDelete = empresaService.findById(id);
        empresaService.deleteEmpresa(empresaDelete);
    }
    
    @GetMapping("/empresa/{id}")
    public Empresa showById(@PathVariable Integer id){
        return empresaService.findById(id);
    }
    
}
