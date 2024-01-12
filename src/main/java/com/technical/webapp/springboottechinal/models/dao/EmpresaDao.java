package com.technical.webapp.springboottechinal.models.dao;

import org.springframework.data.repository.CrudRepository;

import com.technical.webapp.springboottechinal.models.Entity.Empresa;


public interface EmpresaDao extends CrudRepository<Empresa, Integer> {

}
