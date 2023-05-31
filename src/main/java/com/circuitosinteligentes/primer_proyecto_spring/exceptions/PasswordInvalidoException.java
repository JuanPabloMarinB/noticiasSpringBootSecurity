/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.exceptions;

/**
 *
 * @author Julian_Velasco
 */
public class PasswordInvalidoException extends Exception{
    public PasswordInvalidoException() {
        super("La contraseña no puede ser nula o estar vacía, además debe tener más de 5 dígitos");
    }
}
