package com.aau3.docente.ConfigSegurity;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SegurityConfig extends WebSecurityConfigurerAdapter {
    
     /* Auetenticacion de los tipos de usuarios */
     protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        /* creamos usuarios en memoria para poder acceder al login  */
        auth.inMemoryAuthentication()
                .withUser("admin")
                .password("{noop}123")
                .roles("ADMIN", "PROF");
    }

     /* Autorizacion donde cada usuario ve lo que su rol le permite */
 protected void configure(HttpSecurity http) throws Exception{
    http.authorizeRequests()
                .antMatchers("/editar/**", "/agregar/**", "/eliminar")
                    .hasRole("ADMIN")
                .and()
                    .formLogin()
                    .loginPage("/login");
    }
    
}
