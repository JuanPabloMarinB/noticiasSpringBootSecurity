
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Imagen;
import com.circuitosinteligentes.primer_proyecto_spring.Repositorio.RepositorioImagen;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.ArchivoInvalidoException;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class ImagenServicioImp implements IImagenServicio {
    
    @Autowired
    RepositorioImagen imagenRepositorio;
    
    
    @Override
    public Imagen save(MultipartFile archivo) throws ArchivoInvalidoException{
        if(archivo!=null) {
            try {
                Imagen imagen = new Imagen();
                
                if ((archivo.getContentType()=="jpg") || (archivo.getContentType()=="png")) {
                    imagen.setMime(archivo.getContentType());
                }
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.err.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public Imagen update(MultipartFile archivo, Integer id) throws ArchivoInvalidoException{
        if(archivo!=null) {
            try {
                Imagen imagen = new Imagen();
                
                if(id!= null) {
                    Optional<Imagen> respuesta = imagenRepositorio.findById(id);
                    if(respuesta.isPresent()) {
                        imagen = respuesta.get();
                    }
                            
                }
                
                if ((archivo.getContentType()=="jpg") || (archivo.getContentType()=="png")) {
                    imagen.setMime(archivo.getContentType());
                }
                imagen.setNombre(archivo.getName());
                imagen.setContenido(archivo.getBytes());
                
                return imagenRepositorio.save(imagen);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
