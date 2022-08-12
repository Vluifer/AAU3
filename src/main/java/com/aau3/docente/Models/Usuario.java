package com.aau3.docente.Models;

import java.io.Serializable;
import javax.persistence.*;
import lombok.Data;

@Data // Crea los getter y los setter
@Entity //Covierte la clase en una clase entidad
@Table(name  = "usuarios") //Para evitar errores a la hora de extraer la informacion
//de la base de datos, ya que los nombres de la clase y la table estan escritos diferentes
public class Usuario implements Serializable {

    private static final long serialVersionUID = 1L; // con esto terminamos de implementar la interfaz Serializable

    @Id // Se dice cual es cmapo de la llave primaria
    private String cedula;
    private String clave;
    private String nombre;
    private String telefono;
    @Column(unique = true) 
    private String email;

}
