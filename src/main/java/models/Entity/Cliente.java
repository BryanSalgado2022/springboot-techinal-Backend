package models.Entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
//Se usa Lombok para crear todos los metodos de acceso y constructores
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "Cliente")
public class Cliente implements Serializable{
    @Id
    @Column(name = "Identificacion")
    private Integer Identificacion;

    @Column(name = "Nombre")
    private String Nombre;
}
