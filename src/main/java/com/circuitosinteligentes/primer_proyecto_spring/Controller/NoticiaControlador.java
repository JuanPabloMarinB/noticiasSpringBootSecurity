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
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 *
 * @author Julian_Velasco
 */
@PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_AUTOR')")
@Controller
public class NoticiaControlador {

    @Autowired
    private INoticiaServicio noticiaServicio;

    @Autowired
    private IAutorServicio autorServ;

    @GetMapping("/portal")
    public String home(ModelMap modelmap) {
        List<Noticia> noticias = noticiaServicio.findAll();

        Collections.sort(noticias, (n1, n2) -> n2.getId().compareTo(n1.getId()));
        modelmap.addAttribute("noticia", noticias);

        return "index.html";
    }

    @GetMapping("/noticias")
    public String index(ModelMap modelmap) {
        List<Noticia> noticias = noticiaServicio.findAll();
        modelmap.addAttribute("noticia", noticias);
        return "noticiasAdmin.html";
    }

    @GetMapping("/autores")
    public String indexAutor(ModelMap modelmap) {
        List<Noticia> noticias = noticiaServicio.findAll();
        modelmap.addAttribute("noticia", noticias);
        return "autor.html";
    }

    @GetMapping("/create")
    public String create(ModelMap modelMap) {
        Noticia noticia = new Noticia();
        modelMap.addAttribute("noticia", noticia);
        return "crear.html";
    }

    @PostMapping("/save")
    public String save(@RequestParam("file") MultipartFile file, Noticia noticia, String autorNombre,
            String autorApellido) throws IOException {

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
        return "redirect:/noticias";
    }

    @GetMapping("/noticia/{id}") // URL a donde me dirige
    public String noticia(@PathVariable Integer id, ModelMap modelmap) {// ModelMap permite pasar valores al HTML para
                                                                        // que realice operaciones
        Noticia noticia = noticiaServicio.getById(id).get();
        modelmap.addAttribute("noticia", noticia);
        return "noticiaPage.html";
    }

    @GetMapping("/editar/{id}")
    public String edit(@PathVariable Integer id, ModelMap modelmap) {
        Noticia noticia = noticiaServicio.getById(id).get();
        Autor autor = noticia.getAutor();
        modelmap.addAttribute("autor", autor);
        modelmap.addAttribute("noticia", noticia);
        return "edit.html";
    }

    @PostMapping("/update")
    public String update(@ModelAttribute("noticia") Noticia noticia) {
        Noticia noticiaActual = noticiaServicio.getById(noticia.getId()).get();
        Autor autorActual = noticiaActual.getAutor();
        autorActual.setNombre(noticia.getAutor().getNombre());
        autorActual.setApellido(noticia.getAutor().getApellido());
        autorServ.update(autorActual);

        noticiaActual.setTitulo(noticia.getTitulo());
        noticiaActual.setCuerpo(noticia.getCuerpo());
        noticiaServicio.update(noticiaActual);

        return "redirect:/noticias";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id) {
        noticiaServicio.delete(id);
        return "redirect:/noticias";
    }
}
