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
import com.technical.webapp.springboottechinal.models.Entity.Usuario;
import com.technical.webapp.springboottechinal.models.dto.EmpresaDto;
import com.technical.webapp.springboottechinal.models.dto.UsuarioDto;
import com.technical.webapp.springboottechinal.service.IEmpresa;
import com.technical.webapp.springboottechinal.service.IUsuario;


@RestController
@RequestMapping("/api/v1")
public class UsuarioController {

    @Autowired
    private IUsuario usuarioService;

    @PostMapping("/usuario")
    @ResponseStatus(HttpStatus.CREATED)
    public UsuarioDto create(@RequestBody UsuarioDto usuarioDto){

        Usuario crearUsuario = usuarioService.saveUsuario(usuarioDto);
        return UsuarioDto.builder()
        .idUsuario(crearUsuario.getIdusuario())
        .correo(crearUsuario.getCorreo())
        .contraseña(crearUsuario.getContraseña())
        .tipoUsuario(crearUsuario.getTipoUsuario())
        .build();
        
    }

    @DeleteMapping("/usuario/{id}")
    public ResponseEntity<?> delete(@PathVariable Integer id){
        Map<String, Object> response = new HashMap<>();
        try {
            Usuario usuarioDelete = usuarioService.findById(id);
            usuarioService.deleteUsuario(usuarioDelete);
            return new ResponseEntity<>(usuarioDelete, HttpStatus.NO_CONTENT);
        } catch (DataAccessException exDae) {
            //control para error 500 en caso de borrar una identidad que no existe
            response.put("Mensaje", exDae.getMessage());
            response.put("Usuario", null);
            return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping("/empresa/{id}")
    @ResponseStatus(HttpStatus.OK)
    public UsuarioDto showById(@PathVariable Integer id){
        Usuario actualizarUsuario =  usuarioService.findById(id);
        return UsuarioDto.builder()
        .idUsuario(actualizarUsuario.getIdusuario())
        .correo(actualizarUsuario.getCorreo())
        .contraseña(actualizarUsuario.getContraseña())
        .tipoUsuario(actualizarUsuario.getTipoUsuario())
        .build();
    }
    
}
