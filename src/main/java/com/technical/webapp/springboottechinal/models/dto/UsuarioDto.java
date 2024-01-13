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
public class UsuarioDto implements Serializable{
   
    private Integer idUsuario;
    private String correo;
    private String contraseña;
    private String tipoUsuario;

}
