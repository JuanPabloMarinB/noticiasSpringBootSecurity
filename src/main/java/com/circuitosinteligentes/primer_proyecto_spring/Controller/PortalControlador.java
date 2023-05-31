/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Controller;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Usuario;
import com.circuitosinteligentes.primer_proyecto_spring.Servicio.IUsuarioServicio;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.ApellidoInvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.EmailInvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.NombreInvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.Password2InvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.PasswordInvalidoException;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.ModelMap;

/**
 *
 * @author Julian_Velasco
 */
@Controller
public class PortalControlador {

    @Autowired
    private IUsuarioServicio usuarioServicio;

    @GetMapping("/")//URL a donde me dirige
    public String index() {
        return "inicio.html";
    }

    @GetMapping("/registro")
    public String register(Model model) {
        model.addAttribute("errorNombre", "");
        model.addAttribute("errorApellido", "");
        model.addAttribute("errorEmail", "");
        model.addAttribute("errorPassword", "");
        model.addAttribute("errorPassword2", "");
        return "registro.html";
    }

    @PostMapping("/registro")
    public String registrarUsuario(@RequestParam("nombre") String nombre,
            @RequestParam("apellido") String apellido,
            @RequestParam("email") String email,
            @RequestParam("password") String password,
            @RequestParam("password2") String password2,
            Model model) {
        try {
            usuarioServicio.registrar(nombre, apellido, email, password, password2);
            return "inicio.html";
        } catch (NombreInvalidoException e) {
            model.addAttribute("errorNombre", "El nombre es inválido");
        } catch (ApellidoInvalidoException e) {
            model.addAttribute("errorApellido", "El apellido es inválido");
        } catch (EmailInvalidoException e) {
            model.addAttribute("errorEmail", "El email es inválido");
        } catch (PasswordInvalidoException e) {
            model.addAttribute("errorPassword", "La contraseña es inválida");
        } catch (Password2InvalidoException e) {
            model.addAttribute("errorPassword2", "Las contraseñas no coinciden");
        } catch (Exception e) {
            model.addAttribute("error", "Error al registrar usuario");
        }
        return "registro.html";
    }
    
    @GetMapping("/login")
    public String login(@RequestParam(required=false) String error, ModelMap model) {
        if(error != null){
            model.put("error", "Usuario o contraseña inválidos");
        }
        return "login.html";
    }

    @PreAuthorize("hasAnyRole('ROLE_USER', 'ROLE_ADMIN', 'ROLE_AUTOR')")
    @GetMapping("/inicio")
    public String inicio(HttpSession session, ModelMap model) {
        Usuario logueado = (Usuario) session.getAttribute("usuariosession");
        System.out.println(logueado.getRol());
        if(logueado.getRol().toString().equals("ADMIN")){
            return "redirect:/dashboard";
        }
        if(logueado.getRol().toString().equals("AUTOR")){
            return "redirect:/autorPortal";
        }
        return "redirect:/portal";
    }
}
