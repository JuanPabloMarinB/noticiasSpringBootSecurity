/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Repositorio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian_Velasco
 */
@Repository
public interface RepositorioUsuario extends JpaRepository<Usuario, Integer>{
    
    /*@Query("SELECT u FROM Usuario u WHERE u.email = :email")
     public Usuario buscarEmail(@Param(email)String email);*/
     
    public Usuario findByEmail(String email);
    
}
