package com.technical.webapp.springboottechinal.service;

import com.technical.webapp.springboottechinal.models.Entity.Producto;
import com.technical.webapp.springboottechinal.models.dto.ProductoDto;

public interface IProducto {
    Producto saveProducto(ProductoDto productoDto);

    Producto findById(Integer id);

    void deleteProducto(Producto producto);
}
