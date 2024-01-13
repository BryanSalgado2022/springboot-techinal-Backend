package com.technical.webapp.springboottechinal.models.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "inventario")
public class Inventario implements Serializable{
    @Id
    @Column(name = "id_inventario")
    private Integer IdInventario;

    @Column(name = "fk_empresa")
    private Integer Empresa;

    @Column(name = "fk_producto")
    private Integer Producto;
    

}
