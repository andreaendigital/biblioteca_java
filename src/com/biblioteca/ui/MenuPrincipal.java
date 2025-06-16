/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.ui;

import com.biblioteca.service.ServicioBiblioteca;
import com.biblioteca.model.Libro;
import com.biblioteca.model.Usuario;
import com.biblioteca.exception.LibroNoEncontradoException;
import com.biblioteca.exception.LibroNoPrestadoException;
import com.biblioteca.exception.LibroYaPrestadoException;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;

/**
 *
 * @author Andrea
 */
public class MenuPrincipal {
    //Contiene la lógica de interacción con el usuario, menús, etc

    private ServicioBiblioteca servicioBiblioteca;
    private Scanner scanner;

    public MenuPrincipal(ServicioBiblioteca servicioBiblioteca) {
        this.servicioBiblioteca = servicioBiblioteca;
        this.scanner = new Scanner(System.in);
    }

    public void iniciar() {
        // Cargar algunos datos iniciales o desde archivos
        // Esto podría hacerse también en el Main.java o desde un archivo de configuración
        servicioBiblioteca.agregarLibro(new Libro("Cien años de soledad", "Gabriel García Márquez", "978-0307474728"));
        servicioBiblioteca.agregarLibro(new Libro("Don Quijote de la Mancha", "Miguel de Cervantes", "978-8424119859"));
        servicioBiblioteca.agregarUsuario(new Usuario("U001", "Ana", "García"));
        servicioBiblioteca.agregarUsuario(new Usuario("U002", "Pedro", "López"));

        System.out.println("\n--- Intentando cargar libros desde un archivo CSV ---");
        try {
            servicioBiblioteca.cargarLibrosDesdeCSV("libros.csv");
            System.out.println("Libros cargados exitosamente desde libros.csv");
        } catch (IOException e) {
            System.err.println("Error al cargar libros desde CSV: " + e.getMessage());
        }

        System.out.println("\n--- Intentando guardar reporte de libros ---");
        try {
            servicioBiblioteca.guardarReporteLibros("reporte_libros.txt");
            System.out.println("Reporte de libros guardado exitosamente en reporte_libros.txt");
        } catch (IOException e) {
            System.err.println("Error al guardar el reporte de libros: " + e.getMessage());
        }

        int opcion = -1;
        do {
            mostrarMenu();
            try {
                opcion = scanner.nextInt();
                scanner.nextLine(); // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        buscarLibro();
                        break;
                    case 2:
                        prestarLibro();
                        break;
                    case 3:
                        devolverLibro();
                        break;
                    case 4:
                        mostrarTodosLosLibros();
                        break;
                    case 0:
                        System.out.println("Saliendo del programa. Hasta luego!");
                        break;
                    default:
                        System.out.println("Opcion no valida. Por favor, intente de nuevo.");
                }
            } catch (InputMismatchException e) {
                System.err.println("\nError: Entrada invalida. Por favor, ingrese un numero para la opcion.");
                scanner.nextLine(); // Limpiar el buffer del scanner
                opcion = -1; // Para que el bucle continúe
            } catch (Exception e) { // Catch genérico para cualquier otro error inesperado en la UI
                System.err.println("\nOcurrio un error inesperado en la interfaz de usuario: " + e.getMessage());
            }

        } while (opcion != 0);

    }

    private void mostrarMenu() {
        System.out.println("\n--- Menu de Biblioteca ---");
        System.out.println("1. Buscar libro por titulo");
        System.out.println("2. Prestar libro");
        System.out.println("3. Devolver libro");
        System.out.println("4. Mostrar todos los libros");
        System.out.println("0. Salir");
        System.out.print("Ingrese una opcion: ");
    }

      private void buscarLibro() {
       
        System.out.print("Ingrese el titulo del libro a buscar: ");
        String tituloBuscar = scanner.nextLine();
        try {
            Libro encontrado = servicioBiblioteca.buscarLibroPorTitulo(tituloBuscar);
            System.out.println("\nLibro encontrado: " + encontrado);
        } catch (LibroNoEncontradoException e) {
            System.err.println("\nError: " + e.getMessage());
        }

    }

    private void prestarLibro() {
        System.out.print("Ingrese el ID del usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese el titulo del libro pedir: ");
        String tituloSolicitado = scanner.nextLine();
        try {
            servicioBiblioteca.prestarLibro(tituloSolicitado, usuario); 
            System.out.println("\nOperacion realizada.");
        } catch (IllegalArgumentException | LibroNoEncontradoException | LibroYaPrestadoException e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }

    private void devolverLibro() {
        System.out.print("Ingrese el titulo del libro a devolver: ");
        String tituloDevolver = scanner.nextLine();
        try {
            servicioBiblioteca.devolverLibro(tituloDevolver);
            System.out.println("\nOperacion realizada.");
        } catch (LibroNoPrestadoException | LibroNoEncontradoException e) {
            System.err.println("\nError: " + e.getMessage());
        }
    }

    private void mostrarTodosLosLibros() {
        ArrayList<Libro> libros = servicioBiblioteca.obtenerTodosLosLibros();
        System.out.println("\n=== Listado de Libros ===");
        System.out.println("=========================");
        for (Libro libro : libros) {
            System.out.println(libro.toString());
        }
    }

}
