/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Administrador;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import com.circuitosinteligentes.primer_proyecto_spring.Interfaces.IAutorNoticiaServicio;
import com.circuitosinteligentes.primer_proyecto_spring.Interfaces.IAutorServicio;
import com.circuitosinteligentes.primer_proyecto_spring.Repositorio.Repositorio;
import com.circuitosinteligentes.primer_proyecto_spring.Repositorio.RepositorioAutor;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Julian_Velasco
 */
@Service
public class AutorNoticiaServicioImpl implements IAutorNoticiaServicio {

    @Autowired
    private Repositorio repositorioNoticia;

    @Autowired
    private IAutorServicio autorServicio;

    @Override
    public List<Noticia> findAll() {
        return repositorioNoticia.findAll();
    }

    @Override
    public Noticia getById(Integer id) {
        return repositorioNoticia.getById(id);
    }

    @Override
    public List<Autor> findAllAutores() {
        return autorServicio.findAll();
    }

    @Override
    public Autor getAutorById(Integer id) {
        Autor autor = autorServicio.getById(id);
        return autor;
    }

    @Override
    public void relacionarAutorNoticia(Autor autor, Noticia noticia) {
        noticia.setAutor(autor);
        repositorioNoticia.save(noticia);
    }

    @Override
    public void relacionarAdministradorNoticia(Administrador administrador, Noticia noticia) {
        noticia.setAdministrador(administrador);
        repositorioNoticia.save(noticia);
    }

    @Override
    public Administrador getAdministradorByNoticiaId(Integer id) {
        Optional<Administrador> admin = repositorioNoticia.findById(id).map(Noticia::getAdministrador);
        return admin.orElse(null);
    }
}
