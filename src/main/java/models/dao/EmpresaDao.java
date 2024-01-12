package models.dao;

import org.springframework.data.repository.CrudRepository;

import models.Entity.Empresa;


public interface EmpresaDao extends CrudRepository<Empresa, Integer> {

}
