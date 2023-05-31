/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Administrador;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Julian_Velasco
 */
public interface IAutorNoticiaServicio {
    public List<Noticia> findAll();
    public Optional<Noticia> getById(Integer id);
    public List<Autor> findAllAutores();
    public Optional<Autor> getAutorById(Integer id);
    public void relacionarAutorNoticia(Autor autor, Noticia noticia);
    public void relacionarAdministradorNoticia(Administrador administrador, Noticia noticia);
    public Optional<Administrador> getAdministradorByNoticiaId(Integer id);
}
    

