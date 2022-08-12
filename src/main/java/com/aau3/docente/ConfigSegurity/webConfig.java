package com.aau3.docente.ConfigSegurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class webConfig implements  WebMvcConfigurer{
    /* Metodo creado para redireccionar a las vistas que  no tiene tienenn controlador */
    @Override
    public void addViewControllers(ViewControllerRegistry registro){
        registro.addViewController("/").setViewName("index");
        registro.addViewController("login");
    }
}
