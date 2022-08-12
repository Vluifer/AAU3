package com.aau3.docente.Dao;

import org.springframework.data.repository.CrudRepository;

import com.aau3.docente.Models.Usuario;

/*extendemos la interfaz crud repository que contiene metodos para las operaciones del crud, 
 *  le pasamos como parametros el nombre de clase modelo y  el tipo del id de esa clase
 */
public interface UsuarioDao  extends CrudRepository<Usuario,String> {
    
}
