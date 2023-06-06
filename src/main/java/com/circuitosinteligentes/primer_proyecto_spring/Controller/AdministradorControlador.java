/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Controller;

import com.circuitosinteligentes.primer_proyecto_spring.Enumeraciones.Rol;
import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Autor;
import com.circuitosinteligentes.primer_proyecto_spring.interfaces.IAutorServicio;
import com.circuitosinteligentes.primer_proyecto_spring.interfaces.INoticiaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Julian_Velasco
 */
@Controller
public class AdministradorControlador {
    
   // @Autowired
    //private Autor autores;

    @Autowired
    private IAutorServicio autorServicio;

    @Autowired
    private INoticiaServicio noticiaServicio;

    @GetMapping("/dashboard")
    public String panelAdmin() {
        return "redirect:/noticias";
    }

    @GetMapping("/create-autor")
    public String autorCreate() {
        return "crearAutor.html";
    }

    @PostMapping("/save/autor")
    public String saveAutor(@RequestParam String nombre, @RequestParam String apellido, @RequestParam Integer sueldoMensual, ModelMap modelMap) {
      Autor autor = new Autor();
        autor.setNombre(nombre);
        autor.setApellido(apellido);
        autor.setSueldoMensual(sueldoMensual);
        autor.setRol(Rol.AUTOR);
        autorServicio.save(autor);
        modelMap.addAttribute("autor", autor);

        return "redirect:/noticias";

    }
}
