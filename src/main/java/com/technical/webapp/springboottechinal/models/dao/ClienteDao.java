package com.technical.webapp.springboottechinal.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.technical.webapp.springboottechinal.models.Entity.Cliente;

public interface ClienteDao  extends CrudRepository<Cliente, Integer>{
    
}
