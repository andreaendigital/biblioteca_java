/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.model;

/**
 *
 * @author Andrea
 */
public class Usuario {
    

    private String idUsuario;
    private String nombre;
    private String apellido;

    public Usuario(String idUsuario, String nombre, String apellido) {
        this.idUsuario = idUsuario;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    // Getters
    public String getIdUsuario() { return idUsuario; }
    public String getNombre() { return nombre; }
    public String getApellido() { return apellido; }

    @Override
    public String toString() {
        return "ID Usuario: '" + idUsuario + '\'' +
               ", Nombre: '" + nombre + '\'' +
               ", Apellido: '" + apellido + '\'';
    }
}
