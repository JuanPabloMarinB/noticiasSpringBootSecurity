/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import com.circuitosinteligentes.primer_proyecto_spring.Repositorio.RepositorioAdministrador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian_Velasco
 */
@Service
public class AdministradorServicioImpl implements IAdministradorServicio {
    
    @Autowired
    private INoticiaServicio noticiaServicio;

    @Autowired
    private IAutorServicio autorServicio;


    @Autowired
    private RepositorioAdministrador administradorRepositorio;

    @Override
    public void crearNoticia(Noticia noticia) {
        noticiaServicio.save(noticia);
    }

    @Override
    public void modificarNoticia(Noticia noticia) {
        noticiaServicio.update(noticia);
    }

    @Override
    public void eliminarNoticia(Integer id) {
        noticiaServicio.delete(id);
    }

    @Override
    public void darAltaAutor(Autor autor) {
        autor.setActivo(true);
        autorServicio.update(autor);
    }

    @Override
    public void darBajaAutor(Autor autor) {
        autor.setActivo(false);
        autorServicio.update(autor);
    }

    @Override
    public void establecerSueldoMensualAutor(Autor autor, Integer sueldoMensual) {
        autor.setSueldoMensual(sueldoMensual);
        autorServicio.update(autor);
    }
}