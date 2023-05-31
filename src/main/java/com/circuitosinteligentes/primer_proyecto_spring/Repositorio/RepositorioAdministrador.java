/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Repositorio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Administrador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian_Velasco
 */
@Repository
public interface RepositorioAdministrador extends JpaRepository<Administrador, Integer>{
    
    /*@Query("SELECT u FROM Usuario u WHERE u.email = :email")
     public Usuario buscarEmail(@Param(email)String email);*/
     
    public Administrador findByEmail(String email);
    
}