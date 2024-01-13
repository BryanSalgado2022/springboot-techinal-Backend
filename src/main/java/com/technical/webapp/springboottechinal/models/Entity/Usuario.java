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
@Table(name = "usuario")
public class Usuario implements Serializable{
    @Id
    @Column(name = "id_usuario")
    private Integer idusuario;

    @Column(name = "correo")
    private String correo;

    @Column(name = "contraseña")
    private String contraseña;
    
    @Column(name = "fk_tipo_usuario")
    private String tipoUsuario;

}
