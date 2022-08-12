package com.aau3.docente.Service;

import java.util.List;

import com.aau3.docente.Models.Docente;
/* Creamos una interface para y definimos los metodos */
public interface DocenteService {

    public List<Docente> ListarDocente();
    public void guardar (Docente docente);
    public void eliminar (Docente docente);
    public Docente buscarid(Docente docente);
}
