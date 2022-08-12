package com.aau3.docente.Service;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.aau3.docente.Dao.UsuarioDao;
import com.aau3.docente.Models.Usuario;

// Para que sprintBoot La reconozca como una clase de servicio
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    private UsuarioDao usuariodao;


    @Override
     // Dependiendo del tipo de meotodo es el tipo de transaccion que vamos a realizar
    // en este como slo vamos a leer datos ponemos transactional
    @Transactional(readOnly = true)
    public List<Usuario> ListarUsuario() {
        // Como el metodo findAll regresa un tipo objeto lo casteamos
        // para que nos regrese una lista
        return  (List<Usuario>) usuariodao.findAll();
    }

    @Override
     // En el caso de guardar como va modifacar en la base datos si debe hacer commit o rollback
    // se deja solo transactional
    @Transactional
    public void guardar(Usuario usuario) {
        usuariodao.save(usuario);
    }

    @Override
    @Transactional
    public void eliminar(Usuario usuario) {
        usuariodao.delete(usuario);   
    }

    @Override
    @Transactional(readOnly = true)
    public Usuario buscarCedula(Usuario usuario) {
         // Debemos poner el orElse por si no encuentra lo que esta buscando le mandamos null
         return usuariodao.findById(usuario.getCedula()).orElse(null);
    }
    
}
