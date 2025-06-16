/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.service;

import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.exception.LibroNoEncontradoException;
import com.biblioteca.exception.LibroNoPrestadoException;
import com.biblioteca.exception.LibroYaPrestadoException;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
/**
 *
 * @author Andrea
 */
public class ServicioBiblioteca {
    //contiene la lógica de negocio principal y la manipulación de datos
    
    private ArrayList<Libro> libros;
    private HashMap<String, Usuario> usuarios;

    public ServicioBiblioteca() {
        this.libros = new ArrayList<>();
        this.usuarios = new HashMap<>();
    }

    public void agregarLibro(Libro libro) {
        libros.add(libro);
        // System.out.println("Libro agregado: " + libro.getTitulo()); // Quitar System.out de la capa de servicio
    }

    public void agregarUsuario(Usuario usuario) {
        usuarios.put(usuario.getIdUsuario(), usuario);
        // System.out.println("Usuario agregado: " + usuario.getNombre() + " " + usuario.getApellido()); // Quitar System.out
    }

    public Libro buscarLibroPorTitulo(String titulo) throws LibroNoEncontradoException {
        for (Libro libro : libros) {
            if (libro.getTitulo().equalsIgnoreCase(titulo)) {
                return libro;
            }
        }
        throw new LibroNoEncontradoException("El libro con titulo '" + titulo + "' no se encontro en la biblioteca.");
    }

    public void prestarLibro(String tituloLibro, String idUsuario) throws LibroNoEncontradoException, LibroYaPrestadoException {
        Libro libro = buscarLibroPorTitulo(tituloLibro); // Puede lanzar LibroNoEncontradoException

        if (libro.isPrestado()) {
            throw new LibroYaPrestadoException("El libro '" + tituloLibro + "' ya esta prestado.");
        }

        // Aquí podríamos añadir una excepción personalizada para UsuarioNoEncontrado si es necesario
        if (!usuarios.containsKey(idUsuario)) {
            // throw new UsuarioNoEncontradoException("El usuario con ID '" + idUsuario + "' no existe.");
            // Por ahora, solo lanzamos un RuntimeException o manejamos en la UI
            throw new IllegalArgumentException("El usuario con ID '" + idUsuario + "' no existe.");
        }

        libro.setPrestado(true);
        // System.out.println("Libro '" + libro.getTitulo() + "' prestado a usuario con ID: " + idUsuario); // Quitar System.out
    }

    public void devolverLibro(String tituloLibro) throws LibroNoEncontradoException, LibroNoPrestadoException {
        Libro libro = buscarLibroPorTitulo(tituloLibro);

        if (!libro.isPrestado()) {
            // Considerar lanzar una excepción específica si el libro NO estaba prestado
            // throw new LibroNoPrestadoException("El libro '" + tituloLibro + "' no estaba prestado.");
            throw new LibroNoPrestadoException("Advertencia: El libro '" + tituloLibro + "' no estaba prestado.");
        }

        libro.setPrestado(false);
        // System.out.println("Libro '" + libro.getTitulo() + "' devuelto."); // Quitar System.out
    }

    // Métodos para cargar y guardar datos
    public void cargarLibrosDesdeCSV(String rutaArchivo) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(rutaArchivo))) {
            String linea;
            br.readLine(); // Saltar la primera línea si es un encabezado
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 3) {
                    String titulo = datos[0].trim();
                    String autor = datos[1].trim();
                    String isbn = datos[2].trim();
                    Libro libro = new Libro(titulo, autor, isbn);
                    agregarLibro(libro);
                } else {
                    // En un entorno real, esto podría lanzar una DataFormatException
                    System.err.println("Advertencia: Línea con formato incorrecto en CSV de libros: " + linea);
                }
            }
            // System.out.println("Libros cargados desde " + rutaArchivo); // Quitar System.out
        } catch (FileNotFoundException e) {
            throw new IOException("El archivo CSV de libros no se encontró: " + e.getMessage(), e);
        } catch (IOException e) {
            throw new IOException("Error al leer el archivo CSV de libros: " + e.getMessage(), e);
        }
    }

    public void guardarReporteLibros(String rutaArchivo) throws IOException {
        try (FileWriter fw = new FileWriter(rutaArchivo)) {
            fw.write("Reporte de Libros en Biblioteca\n\n");
            for (Libro libro : libros) {
                fw.write(libro.toString() + "\n");
            }
            // System.out.println("Reporte de libros guardado en " + rutaArchivo); // Quitar System.out
        } catch (IOException e) {
            throw new IOException("Error al guardar el reporte de libros: " + e.getMessage(), e);
        }
    }

    public ArrayList<Libro> obtenerTodosLosLibros() {
        return new ArrayList<>(libros); // Devuelve una copia para evitar modificación externa
    }
    
    public HashMap<String, Usuario> obtenerTodosLosUsuarios() {
        return new HashMap<>(usuarios); // Devuelve una copia
    }

}
