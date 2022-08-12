package com.aau3.docente.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.aau3.docente.Models.Docente;
import com.aau3.docente.Service.DocenteService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
@Controller /* Se encarga de comunicar los controladores con la vista */
public class DocenteController {

    /* Permite inyectar la dependencia del objeto implícitamente. 
    Utiliza internamente inyección de metodos */
    @Autowired 
    private DocenteService docenteservice;
    
    /*  En este metodo se crean objetos de este tipo docentes */
    @GetMapping("/docente/agregard")
    /* GetMapping nos permite simplificar el manejo de los diferentes métodos de Spring MVC */
    public String agregar(Docente docente, Model model){
        model.addAttribute("docente", docente);
        return "/docente/agregard";
    }
    /* PostMapping nos permite simplificar el manejo de los diferentes métodos de Spring MVC */
    @PostMapping("/docente/guardar")
    public String guardar(Docente docente) {
       docenteservice.guardar(docente);
        return "redirect:/docente/listard";
    } 

    /* /docente/editar/{id} con esta dirrecion recibomos lo que enviamos a travez 
    del formulario por post */
    @GetMapping("/docente/editar/{id}") 
    public String editar(Docente docente, Model model){
        docente = docenteservice.buscarid(docente);
        model.addAttribute("docente", docente);
        return "/docente/agregard"; /* Redireccionamos a la vista despues se hace la acción */
    }

    @GetMapping("/docente/eliminar/{id}")
    public String eliminar(Docente docente){
         docenteservice.eliminar(docente);
        return "/docente/listard";
    }

    @RequestMapping("/docente/listard")
    public String listar(Model model) {
        List<Docente> docentes = docenteservice.ListarDocente();
        model.addAttribute("docentes", docentes);
        return "/docente/listard";
    }
}
