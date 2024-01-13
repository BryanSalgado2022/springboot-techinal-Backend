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
public class InventarioDto implements Serializable{
   
    private Integer idinventario;
    private Integer fkEmpresa;
    private Integer fkProducto;

}
