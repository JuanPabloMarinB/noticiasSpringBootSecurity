/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.circuitosinteligentes.primer_proyecto_spring.exceptions;

/**
 *
 * @author Julian_Velasco
 */
public class Password2InvalidoException extends Exception {
    public Password2InvalidoException() {
        super("Las contraseñas no coinciden");
    }
}
