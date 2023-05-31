/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.Servicio;

import com.circuitosinteligentes.primer_proyecto_spring.Entidades.Usuario;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.ApellidoInvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.EmailInvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.NombreInvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.Password2InvalidoException;
import com.circuitosinteligentes.primer_proyecto_spring.exceptions.PasswordInvalidoException;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Julian_Velasco
 */
public interface IUsuarioServicio {

    public List<Usuario> findAll();
    public Optional<Usuario> getById(Integer id);
    public void update(Usuario usuario);
    public void delete(Integer id);
    public Usuario save(Usuario usuario);
    public void registrar(String nombre, String apellido, String email, String password, String password2)
            throws NombreInvalidoException, ApellidoInvalidoException, EmailInvalidoException,
            PasswordInvalidoException, Password2InvalidoException;

    public void validar(String nombre, String apellido, String email, String password, String password2)
            throws NombreInvalidoException, ApellidoInvalidoException, EmailInvalidoException,
            PasswordInvalidoException, Password2InvalidoException;
    
}
