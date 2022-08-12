package com.aau3.docente.Models;

import javax.persistence.*;
import java.io.Serializable;
import lombok.Data;

@Data // Crea los getter y los setter
@Entity //Covierte la clase en una clase entidad
@Table(name = "docentes") //Para evitar errores a la hora de extraer la informacion
//de la base de datos, ya que los nombres de la clase y la table estan escritos diferentes
public class Docente implements Serializable {
    
 private static final long serialVersionUID = 1L;

    @Id // Se dice cual es cmapo de la llave primaria
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     @Column(name = "id")
     private int id;
     private String id_usuario;
     private String nombre;
     private String apellido;
     private String blog;
     private String profesional;
     private String escalaron;
     private String idioma;
     private String anios_experiencia;  
     private String area_trabajo;
 
}
