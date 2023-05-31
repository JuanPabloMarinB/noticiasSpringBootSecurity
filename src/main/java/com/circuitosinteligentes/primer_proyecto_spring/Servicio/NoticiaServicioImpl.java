/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import com.circuitosinteligentes.primer_proyecto_spring.Repositorio.Repositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian_Velasco
 */
@Service
public class NoticiaServicioImpl implements INoticiaServicio {

    @Autowired//Inyectar repositorio
    private Repositorio noticiaRepositorio;

    @Override
    public List<Noticia> findAll() {
        return noticiaRepositorio.findAll();
    }

    @Override
    public Optional<Noticia> getById(Integer id) {
        return noticiaRepositorio.findById(id);
    }

    @Override
    public void update(Noticia noticia) {
        noticiaRepositorio.save(noticia);
    }

    @Override
    public void delete(Integer id) {
        noticiaRepositorio.deleteById(id);
    }

    @Override
    public Noticia save(Noticia noticia) {
        return noticiaRepositorio.save(noticia);
    }

}
