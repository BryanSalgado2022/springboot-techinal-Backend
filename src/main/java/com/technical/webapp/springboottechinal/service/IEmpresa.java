package com.technical.webapp.springboottechinal.service;

import com.technical.webapp.springboottechinal.models.Entity.Empresa;
import com.technical.webapp.springboottechinal.models.dto.EmpresaDto;

public interface IEmpresa {
    Empresa saveEmpresa(EmpresaDto empresa);

    Empresa findById(Integer id);

    void deleteEmpresa(Empresa empresa);

    Iterable<Empresa> getAll();

}
