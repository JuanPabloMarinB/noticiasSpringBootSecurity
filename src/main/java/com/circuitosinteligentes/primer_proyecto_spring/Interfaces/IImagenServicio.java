/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Interfaces;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Administrador;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Imagen;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.ArchivoInvalidoException;
import java.util.List;
import java.util.Optional;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Julian_Velasco
 */
public interface IImagenServicio {
    //public List<Imagen> findAll();
    //public Optional<Imagen> getById(Integer id);
    public Imagen update(MultipartFile archivo, Integer id) throws ArchivoInvalidoException;
    public void delete(Integer id);
    public Imagen save(MultipartFile archivo) throws ArchivoInvalidoException;
}
    

