/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Controller;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Imagen;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import com.circuitosinteligentes.primer_proyecto_spring.interfaces.IAutorServicio;
import com.circuitosinteligentes.primer_proyecto_spring.interfaces.INoticiaServicio;
import com.circuitosinteligentes.primer_proyecto_spring.Servicio.ImagenServicioImp;
import com.circuitosinteligentes.primer_proyecto_spring.Servicio.UsuarioServicioImpl;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.ArchivoInvalidoException;
import java.io.IOException;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Julian_Velasco
 */
@Controller
public class AutorControlador {

    @Autowired
    private IAutorServicio autorServ;

    @Autowired
    private ImagenServicioImp imagenServicio;

    @Autowired
    private INoticiaServicio noticiaServicio;

    @Autowired
    private UsuarioServicioImpl usuarioServicio;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_AUTOR')")
    @GetMapping("/autorPortal")
    public String panelAutor(ModelMap modelmap) {
        return "redirect:/autores";
    }

    @PostMapping("/saveNoti")
    public String save(@RequestParam("file") MultipartFile notifile, MultipartFile usufile, Noticia noticia, String autorNombre, String autorApellido, Integer sueldoMensual) throws IOException, ArchivoInvalidoException {

        if (autorNombre != null && autorApellido != null) {
            Autor autor = new Autor();
            autor.setNombre(autorNombre);
            autor.setApellido(autorApellido);
            autor.setSueldoMensual(sueldoMensual);
            autor = autorServ.save(autor);
            noticia.setAutor(autor);

            Imagen imagenautor = imagenServicio.save(usufile);
            autor.setImagen(imagenautor);
            autorServ.save(autor);
            Imagen notimagen = imagenServicio.save(notifile);
            noticia.setImagen(notimagen);
            noticiaServicio.save(noticia);
        }
        return "redirect:/autores";
    }

    @GetMapping("/editarNoti/{id}")
    public String edit(@PathVariable Integer id, ModelMap modelmap) {
        List<Autor> autor = autorServ.findAll();
        modelmap.addAttribute("autor", autor);
        Noticia noticia = noticiaServicio.getById(id).get();
        modelmap.addAttribute("noticia", noticia);
        return "editAutor.html";
    }

    @PostMapping("/updateNoti")
    public String update(MultipartFile notifile, MultipartFile usufile, @PathVariable Integer id, @RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2, ModelMap model) throws ArchivoInvalidoException {

        Noticia noticia = noticiaServicio.getById(id).get();

        Autor autorActual = noticia.getAutor();

        autorActual.setNombre(noticia.getAutor().getNombre());
        autorActual.setApellido(noticia.getAutor().getApellido());
        autorActual.setEmail(noticia.getAutor().getEmail());
        autorActual.setPassword(noticia.getAutor().getPassword());
        Integer idImagen = null;

        if (autorActual.getImagen() != null) {
            idImagen = autorActual.getImagen().getId();
        }

        Imagen imagen = imagenServicio.update(usufile, idImagen);
        autorActual.setImagen(imagen);
        autorServ.update(autorActual);

        noticia.setTitulo(noticia.getTitulo());
        noticia.setCuerpo(noticia.getCuerpo());
        noticiaServicio.update(noticia);
        model.put("exito", "Noticia actualizada correctamente");
        return "index.html";

    }

    
    
    
}
