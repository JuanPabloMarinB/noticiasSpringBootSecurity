/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;

/**
 *
 * @author Julian_Velasco
 */
public interface IAdministradorServicio {
    public void crearNoticia(Noticia noticia);
    public void modificarNoticia(Noticia noticia);
    public void eliminarNoticia(Integer id);
    public void darAltaAutor(Autor autor);
    public void darBajaAutor(Autor autor);
    public void establecerSueldoMensualAutor(Autor autor, Integer sueldoMensual);
}