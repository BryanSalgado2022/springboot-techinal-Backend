package com.technical.webapp.springboottechinal.service;

import com.technical.webapp.springboottechinal.models.Entity.Empresa;

public interface IEmpresa {
    Empresa saveEmpresa(Empresa empresa);

    Empresa findById(Integer id);

    void deleteEmpresa(Empresa empresa);
}
