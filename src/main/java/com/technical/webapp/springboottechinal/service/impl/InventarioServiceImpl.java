package com.technical.webapp.springboottechinal.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technical.webapp.springboottechinal.models.Entity.Inventario;
import com.technical.webapp.springboottechinal.models.dao.InventarioDao;
import com.technical.webapp.springboottechinal.models.dto.InventarioDto;
import com.technical.webapp.springboottechinal.service.IInventario;

@Service
public class InventarioServiceImpl implements IInventario{

    @Autowired
    private InventarioDao inventarioDao;

    @Transactional
    @Override
    public Iterable<Inventario> getAll() {
        return inventarioDao.findAll();
    }

    @Transactional
    @Override
    public Inventario saveInventario(InventarioDto inventarioDto) {
        Inventario inventario = Inventario.builder()
        .IdInventario(inventarioDto.getIdinventario())
        .Empresa(inventarioDto.getFkEmpresa())
        .Producto(inventarioDto.getFkProducto())
        .build();
        return inventarioDao.save(inventario);
    }

    @Transactional
    @Override
    public void deleteEmpresa(Inventario inventario) {
        inventarioDao.delete(inventario);
    }

    @Override
    public Inventario findById(Integer id) {
        return inventarioDao.findById(id).orElse(null);
    }


}
