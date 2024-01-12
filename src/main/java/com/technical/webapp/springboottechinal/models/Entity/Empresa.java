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
@Table(name = "Empresa")
public class Empresa implements Serializable{
    @Id
    @Column(name = "Nit")
    private Integer Nit;

    @Column(name = "Nombre")
    private String Nombre;

    @Column(name = "Dirección")
    private String Direccion;
    
    @Column(name = "Telefono")
    private String Telefono;

}
