/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Repositorio.RepositorioAutor;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Julian_Velasco
 */
@Service
public class AutorServicioImpl implements IAutorServicio {

    @Autowired
    private RepositorioAutor autorRepositorio;

    @Override
    public List<Autor> findAll() {
        return autorRepositorio.findAll();
    }

    @Override
    public Optional<Autor> getById(Integer id) {
        return autorRepositorio.findById(id);
    }

    @Override
    public void update(Autor autor) {
        if (autor.getId() != null && autorRepositorio.existsById(autor.getId())) {
            autorRepositorio.save(autor);
        }
    }

    @Override
    public void delete(Integer id) {
        autorRepositorio.deleteById(id);
    }

    @Override
    public Autor save(Autor autor) {
        return autorRepositorio.save(autor);
    }
}
