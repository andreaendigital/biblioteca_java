/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package com.biblioteca;
import com.biblioteca.service.ServicioBiblioteca;
import com.biblioteca.ui.MenuPrincipal;

/**
 *
 * @author Andrea
 */
public class Biblioteca {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // El punto de entrada principal del programa,
        ServicioBiblioteca servicioBiblioteca = new ServicioBiblioteca();
        MenuPrincipal menu = new MenuPrincipal(servicioBiblioteca);
        menu.iniciar();

    }
    
}


