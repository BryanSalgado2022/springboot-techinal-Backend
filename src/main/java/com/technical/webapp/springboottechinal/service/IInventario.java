package com.technical.webapp.springboottechinal.service;

import com.technical.webapp.springboottechinal.models.Entity.Inventario;
import com.technical.webapp.springboottechinal.models.dto.InventarioDto;

public interface IInventario {
    Inventario saveInventario(InventarioDto inventario);

    void deleteEmpresa(Inventario inventario);

    Inventario findById(Integer id);

    Iterable<Inventario> getAll();

}
