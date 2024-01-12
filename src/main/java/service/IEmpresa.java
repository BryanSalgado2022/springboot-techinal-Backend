package service;

import models.Entity.Empresa;

public interface IEmpresa {
    Empresa saveEmpresa(Empresa empresa);

    Empresa findById(Integer id);

    void deleteEmpresa(Empresa empresa);
}
