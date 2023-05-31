/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Julian_Velasco
 */
public interface INoticiaServicio {
    public List<Noticia> findAll();
    public Optional<Noticia> getById(Integer id);
    public void update(Noticia noticia);
    public void delete(Integer id);
    public Noticia save(Noticia noticia);
}
