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

import com.technical.webapp.springboottechinal.models.Entity.Producto;
import com.technical.webapp.springboottechinal.models.dto.ProductoDto;
import com.technical.webapp.springboottechinal.service.IProducto;


@RestController
@RequestMapping("/api/v1")
public class ProductoController {

    @Autowired
    private IProducto productoService;

    @PostMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDto create(@RequestBody ProductoDto productoDto){

        Producto crearProducto = productoService.saveProducto(productoDto);
        return ProductoDto.builder()
        .Nombre(crearProducto.getNombre())
        .Caracteristicas(crearProducto.getCaracteristicas())
        .Valor(crearProducto.getValor())
        .Divisa(crearProducto.getDivisa())
        .Empresa(crearProducto.getEmpresa())
        .build();
    }

    //Se usa nuevamente el save gracias al uso de CrudRpository el cual identifica si el registro ya existe para actualizarlo
    @PutMapping("/producto")
    @ResponseStatus(HttpStatus.CREATED)
    public ProductoDto update(@RequestBody ProductoDto productoDto){
        Producto actualizarProducto = productoService.saveProducto(productoDto);
        return ProductoDto.builder()
        .Codigo(actualizarProducto.getCodigo())
        .Nombre(actualizarProducto.getNombre())
        .Caracteristicas(actualizarProducto.getCaracteristicas())
        .Valor(actualizarProducto.getValor())
        .Divisa(actualizarProducto.getDivisa())
        .Empresa(actualizarProducto.getEmpresa())
        .build();
    }

    @DeleteMapping("/producto/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Producto productoDelete = productoService.findById(id);
            productoService.deleteProducto(productoDelete);
            return new ResponseEntity<>(productoDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDae) {
            //control para error 500 en caso de borrar una identidad que no existe
            response.put("Mensaje", exDae.getMessage());
            response.put("Producto", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/producto/{id}")
    @ResponseStatus(HttpStatus.OK)
    public ProductoDto showById(@PathVariable Integer id){
        Producto producto = productoService.findById(id);
        return ProductoDto.builder()
        .Codigo(producto.getCodigo())
        .Nombre(producto.getNombre())
        .Caracteristicas(producto.getCaracteristicas())
        .Valor(producto.getValor())
        .Divisa(producto.getDivisa())
        .Empresa(producto.getEmpresa())
        .build();
    }
    
}
