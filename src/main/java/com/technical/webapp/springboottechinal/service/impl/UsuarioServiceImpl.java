package com.technical.webapp.springboottechinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technical.webapp.springboottechinal.models.Entity.Empresa;
import com.technical.webapp.springboottechinal.models.Entity.Usuario;
import com.technical.webapp.springboottechinal.models.dao.EmpresaDao;
import com.technical.webapp.springboottechinal.models.dao.UsuarioDao;
import com.technical.webapp.springboottechinal.models.dto.EmpresaDto;
import com.technical.webapp.springboottechinal.models.dto.UsuarioDto;
import com.technical.webapp.springboottechinal.service.IEmpresa;
import com.technical.webapp.springboottechinal.service.IUsuario;

@Service
public class UsuarioServiceImpl implements IUsuario{

    @Autowired
    private UsuarioDao usuarioDao;

    @Transactional
    @Override
    public Usuario saveUsuario(UsuarioDto usuarioDto) {
        Usuario usuario = Usuario.builder()
        .idusuario(usuarioDto.getIdUsuario())
        .correo(usuarioDto.getCorreo())
        .contraseña(usuarioDto.getContraseña())
        .tipoUsuario(usuarioDto.getTipoUsuario())
        .build();
        return usuarioDao.save(usuario);
    }
    
    @Transactional
    @Override
    public void deleteUsuario(Usuario usuario) {
        usuarioDao.delete(usuario);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Integer id) {
        return usuarioDao.findById(id).orElse(null);
    }   
    
}
