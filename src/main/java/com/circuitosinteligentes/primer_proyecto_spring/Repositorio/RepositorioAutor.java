/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Repositorio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian_Velasco
 */
@Repository
public interface RepositorioAutor extends JpaRepository<Autor, Integer> {

}
