/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Julian_Velasco
 */
public interface IAutorServicio {

    public List<Autor> findAll();
    public Optional<Autor> getById(Integer id);
    public void update(Autor autor);
    public void delete(Integer id);
    public Autor save(Autor autor);
}
