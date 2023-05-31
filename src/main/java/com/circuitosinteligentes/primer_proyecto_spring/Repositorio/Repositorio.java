/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Repositorio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Julian_Velasco
 */
@Repository
public interface Repositorio extends JpaRepository<Noticia, Integer>{
    
    public Noticia findByTitulo(String titulo); //por el atributo titulo va a buscar un string. Se crea este metodo porque JpaRepository sabe buscar pero no sabe que por esto se pasa entre parentesis  
}
