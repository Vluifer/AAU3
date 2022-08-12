package com.aau3.docente.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aau3.docente.Models.Usuario;
import com.aau3.docente.Service.UsuarioService;

import java.util.List;

@Controller /* Se encarga de comunicar los controladores con la vista */
public class UsuarioController {
    
     /* Permite inyectar la dependencia del objeto implícitamente. 
    Utiliza internamente inyección de metodos */
    @Autowired
    private UsuarioService usuarioservice;
      /*  En este metodo Se crean objetos de este tipo docentes */
    @GetMapping("/usuario/agregar")
     /* GetMapping nos permite simplificar el manejo de los diferentes métodos de Spring MVC */
    public String agregar(Usuario usuario, Model model){
        model.addAttribute("usuario", usuario);
        return "/usuario/agregar";
    }
 /* PostMapping nos permite simplificar el manejo de los diferentes métodos de Spring MVC */
    @PostMapping("/usuario/guardar")
    public String guardar(Usuario usuario) {
       usuarioservice.guardar(usuario);
        return "redirect:/usuario/listar";
    }
    /* /docente/editar/{cedula} con esta dirrecion recibomos lo que enviamos a travez 
    del formulario por post */
    @GetMapping("/usuario/editar/{cedula}")
    public String editar(Usuario usuario, Model model){
        usuario = usuarioservice.buscarCedula(usuario);
        model.addAttribute("usuario", usuario);
        return "/usuario/agregar"; /* Redireccionamos a la vista despues se hace la acción */
    }

    @GetMapping("/usuario/eliminar/{cedula}")
    public String eliminar(Usuario usuario){
         usuarioservice.eliminar(usuario);
         return "redirect:/usuario/listar";
    }

    @RequestMapping("usuario/listar")
    public String listar(Model model) {
        List<Usuario> usuarios = usuarioservice.ListarUsuario();
        model.addAttribute("usuarios", usuarios);
        return "usuario/listar";
    } 
}
