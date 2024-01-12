package models.dao;

import org.springframework.data.repository.CrudRepository;

import models.Entity.Cliente;

public interface ClienteDao  extends CrudRepository<Cliente, Integer>{
    
}
