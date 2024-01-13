package com.technical.webapp.springboottechinal.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.technical.webapp.springboottechinal.models.Entity.Usuario;


public interface UsuarioDao extends CrudRepository<Usuario, Integer> {

}
