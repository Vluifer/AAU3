package com.aau3.docente.Service;

import java.util.List;

import com.aau3.docente.Models.Usuario;
/* Creamos una interface para y definimos los metodos */
public interface UsuarioService {
    
    public List<Usuario> ListarUsuario();
    public void guardar (Usuario usuario);
    public void eliminar (Usuario usuario);
    public Usuario buscarCedula(Usuario usuario);
}
