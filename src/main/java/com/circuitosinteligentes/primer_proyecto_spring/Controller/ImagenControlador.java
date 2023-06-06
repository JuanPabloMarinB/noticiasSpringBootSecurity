/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Controller;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Usuario;
import com.circuitosinteligentes.primer_proyecto_spring.Servicio.NoticiaServicioImpl;
import com.circuitosinteligentes.primer_proyecto_spring.Servicio.UsuarioServicioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author Usuario
 */
@Controller
@RequestMapping("/imagen")
public class ImagenControlador {
    @Autowired
    NoticiaServicioImpl noticiaServicio;
    
    @Autowired
    UsuarioServicioImpl usuarioServicio;
    
    @GetMapping("/noticia/{id}")
    public ResponseEntity<byte[]> imagenNoticia(@PathVariable Integer id){
     Noticia noticia = noticiaServicio.getOne(id);   
     byte[] imagen =noticia.getImagen().getContenido();
     
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
     
     
     
     return new ResponseEntity<>(imagen,headers,HttpStatus.OK);
    }
    
    @GetMapping("/perfil/{id}")
    public ResponseEntity<byte[]> imagenUsuario(@PathVariable Integer idUsuario){
    Usuario usuario = usuarioServicio.getOne(idUsuario);   
     byte[] imagen = usuario.getImagen().getContenido();
     
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_JPEG);
     
     
     
     return new ResponseEntity<>(imagen,headers,HttpStatus.OK);
    }
    
}
