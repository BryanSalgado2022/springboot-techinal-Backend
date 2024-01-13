package com.technical.webapp.springboottechinal.models.dto;


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
public class ProductoDto implements Serializable{
   
    private Integer Codigo;
    private String Nombre;
    private String Caracteristicas;
    private Integer Valor;
    private Integer Divisa;
    private String Empresa;

}
