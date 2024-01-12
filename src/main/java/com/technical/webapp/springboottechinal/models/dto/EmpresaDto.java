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
public class EmpresaDto implements Serializable{
   
    private Integer Nit;
    private String Nombre;
    private String Direccion;
    private String Telefono;

}
