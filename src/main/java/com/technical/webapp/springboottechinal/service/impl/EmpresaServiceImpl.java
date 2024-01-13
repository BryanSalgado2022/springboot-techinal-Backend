package com.technical.webapp.springboottechinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technical.webapp.springboottechinal.models.Entity.Empresa;
import com.technical.webapp.springboottechinal.models.dao.EmpresaDao;
import com.technical.webapp.springboottechinal.models.dto.EmpresaDto;
import com.technical.webapp.springboottechinal.service.IEmpresa;

@Service
public class EmpresaServiceImpl implements IEmpresa{

    @Autowired
    private EmpresaDao empresaDao;

    @Transactional
    @Override
    public Empresa saveEmpresa(EmpresaDto empresaDto) {
        Empresa empresa = Empresa.builder().Nit(empresaDto.getNit())
        .Nombre(empresaDto.getNombre())
        .Direccion(empresaDto.getDireccion())
        .Telefono(empresaDto.getTelefono())
        .build();
        return empresaDao.save(empresa);
    }
    
    @Transactional
    @Override
    public void deleteEmpresa(Empresa empresa) {
        empresaDao.delete(empresa);
    }
    
    @Transactional(readOnly = true)
    @Override
    public Empresa findById(Integer id) {
        return empresaDao.findById(id).orElse(null);
    }

   
    
}
