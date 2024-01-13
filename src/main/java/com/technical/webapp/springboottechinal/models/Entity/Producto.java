package com.technical.webapp.springboottechinal.models.Entity;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;


@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Builder
@Entity
@Table(name = "Producto")
public class Producto implements Serializable{
    @Id
    @Column(name = "Codigo")
    private Integer Codigo;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Caracteristicas")
    private String Caracteristicas;
    
    @Column(name = "Valor")
    private Integer Valor;

    @Column(name = "FkDivisa")
    private Integer Divisa;

    @Column(name = "empresa")
    private String Empresa;
}
