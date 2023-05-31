/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Controller;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Noticia;
import com.circuitosinteligentes.primer_proyecto_spring.Servicio.IAutorServicio;
import com.circuitosinteligentes.primer_proyecto_spring.Servicio.INoticiaServicio;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
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
    private INoticiaServicio noticiaServicio;

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_AUTOR')")
    @GetMapping("/autorPortal")
    public String panelAutor(ModelMap modelmap) {
        return "redirect:/autores";
    }
    
    @PostMapping("/saveNoti")
    public String save(@RequestParam("file") MultipartFile file, Noticia noticia, String autorNombre, String autorApellido) throws IOException {

        String rutaProyecto = Paths.get("").toAbsolutePath().toString().replace("\\", "/");
        System.out.println(rutaProyecto);

        if (autorNombre != null && autorApellido != null) {
            Autor autor = new Autor();
            autor.setNombre(autorNombre);
            autor.setApellido(autorApellido);
            autor = autorServ.save(autor);
            noticia.setAutor(autor);

            if (!file.isEmpty()) {
                String fileName = file.getOriginalFilename();
                String uploadDir = rutaProyecto + "/src/main/resources/static/notieggimagenes/";

                File dest = new File(uploadDir + fileName);
                file.transferTo(dest);
                String rutaImagen = "/notieggimagenes/" + fileName;
                noticia.setRutaImagen(rutaImagen);
            }
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
    public String update(Noticia noticia) {
        noticiaServicio.update(noticia);
        return "redirect:/autores";
    }
}
