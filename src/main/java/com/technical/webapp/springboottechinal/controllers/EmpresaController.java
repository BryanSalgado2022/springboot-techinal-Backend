package com.technical.webapp.springboottechinal.controllers;

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
import com.technical.webapp.springboottechinal.models.dto.EmpresaDto;
import com.technical.webapp.springboottechinal.models.payload.MensajeResponse;
import com.technical.webapp.springboottechinal.service.IEmpresa;


@RestController
@RequestMapping("/api/v1")
public class EmpresaController {

    @Autowired
    private IEmpresa empresaService;

    @PostMapping("/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDto create(@RequestBody EmpresaDto empresaDto){

        Empresa crearEmpresa = empresaService.saveEmpresa(empresaDto);
        return EmpresaDto.builder()
        .Nit(crearEmpresa.getNit())
        .Nombre(crearEmpresa.getNombre())
        .Direccion(crearEmpresa.getDireccion())
        .Telefono(crearEmpresa.getTelefono())
        .build();
    }

    //Se usa nuevamente el save gracias al uso de CrudRpository el cual identifica si el registro ya existe para actualizarlo
    @PutMapping("/empresa")
    @ResponseStatus(HttpStatus.CREATED)
    public EmpresaDto update(@RequestBody EmpresaDto empresaDto){
        Empresa actualizarEmpresa = empresaService.saveEmpresa(empresaDto);
        return EmpresaDto.builder()
        .Nit(actualizarEmpresa.getNit())
        .Nombre(actualizarEmpresa.getNombre())
        .Direccion(actualizarEmpresa.getDireccion())
        .Telefono(actualizarEmpresa.getTelefono())
        .build();
    }

    @DeleteMapping("/empresa/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        try {
            Empresa empresaDelete = empresaService.findById(id);
            empresaService.deleteEmpresa(empresaDelete);
            return new ResponseEntity<>(empresaDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDae) {
            //control para error 500 en caso de borrar una identidad que no existe
            return new ResponseEntity<>(MensajeResponse
                    .builder()
                    .mensaje(exDae.getMessage())
                    .object(null)
                    .build()
            , HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/empresa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public EmpresaDto showById(@PathVariable Integer id){
        Empresa empresa =  empresaService.findById(id);
        return EmpresaDto.builder()
        .Nit(empresa.getNit())
        .Nombre(empresa.getNombre())
        .Direccion(empresa.getDireccion())
        .Telefono(empresa.getTelefono())
        .build();
    }
    
}
