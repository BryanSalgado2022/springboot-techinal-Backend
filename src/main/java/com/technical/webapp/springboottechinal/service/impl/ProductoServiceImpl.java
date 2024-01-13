package com.technical.webapp.springboottechinal.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.technical.webapp.springboottechinal.models.Entity.Producto;
import com.technical.webapp.springboottechinal.models.dao.ProductoDao;
import com.technical.webapp.springboottechinal.models.dto.ProductoDto;
import com.technical.webapp.springboottechinal.service.IProducto;

@Service
public class ProductoServiceImpl implements IProducto{

    @Autowired
    private ProductoDao productoDao;

    @Transactional    
    @Override
    public Producto saveProducto(ProductoDto productoDto) {
        Producto producto = Producto.builder().Codigo(productoDto.getCodigo())
        .Nombre(productoDto.getNombre())
        .Caracteristicas(productoDto.getCaracteristicas())
        .Valor(productoDto.getValor())
        .Divisa(productoDto.getDivisa())
        .Empresa(productoDto.getEmpresa())
        .build();
        return productoDao.save(producto);
    }

    @Transactional
    @Override
    public void deleteProducto(Producto producto) {
        productoDao.delete(producto);
    }

    @Transactional(readOnly = true)
    @Override
    public Producto findById(Integer id) {
        return productoDao.findById(id).orElse(null);
    }


    
   
    
}
