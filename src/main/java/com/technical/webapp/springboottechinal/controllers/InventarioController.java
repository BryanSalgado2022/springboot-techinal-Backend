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

import com.technical.webapp.springboottechinal.models.Entity.Inventario;
import com.technical.webapp.springboottechinal.models.dto.InventarioDto;
import com.technical.webapp.springboottechinal.service.IInventario;


@RestController
@RequestMapping("/api/v1")
public class InventarioController {

    @Autowired
    private IInventario inventarioService;

    @PostMapping("/inventario")
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioDto create(@RequestBody InventarioDto inventarioDto){

        Inventario crearInventario = inventarioService.saveInventario(inventarioDto);
        return InventarioDto.builder()
        .idinventario(crearInventario.getIdInventario())
        .fkEmpresa(crearInventario.getEmpresa())
        .fkProducto(crearInventario.getProducto())
        .build();
    }

    //Se usa nuevamente el save gracias al uso de CrudRpository el cual identifica si el registro ya existe para actualizarlo
    @PutMapping("/inventario/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public InventarioDto update(@RequestBody InventarioDto inventarioDto){
        Inventario actualizarInventario = inventarioService.saveInventario(inventarioDto);
        return InventarioDto.builder()
        .idinventario(actualizarInventario.getIdInventario())
        .fkEmpresa(actualizarInventario.getEmpresa())
        .fkProducto(actualizarInventario.getProducto())
        .build();
    }

    @DeleteMapping("/inventario/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Inventario inventarioDelete = inventarioService.findById(id);
            inventarioService.deleteEmpresa(inventarioDelete);
            return new ResponseEntity<>(inventarioDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDae) {
            //control para error 500 en caso de borrar una identidad que no existe
            response.put("Mensaje", exDae.getMessage());
            response.put("Inventario", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/inventario/{id}")
    @ResponseStatus(HttpStatus.OK)
    public InventarioDto showById(@PathVariable Integer id){
        Inventario inventario =  inventarioService.findById(id);
        return InventarioDto.builder()
        .idinventario(inventario.getIdInventario())
        .fkEmpresa(inventario.getEmpresa())
        .fkProducto(inventario.getProducto())
        .build();
    }

    @GetMapping("/inventarios")
    public ResponseEntity<Iterable<Inventario>> findAll(){
        return ResponseEntity.ok(inventarioService.getAll());
    }
}
