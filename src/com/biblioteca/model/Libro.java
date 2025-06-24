/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.biblioteca.model;

/**
 *
 * @author Andrea
 */
public class Libro implements Comparable<Libro> {
    private String titulo;
    private String autor;
    private String isbn;
    private boolean prestado;

    public Libro(String titulo, String autor, String isbn) {
        this.titulo = titulo;
        this.autor = autor;
        this.isbn = isbn;
        this.prestado = false;
    }
    
    public Libro (Libro libro) {
        this.titulo = libro.titulo;
        this.autor = libro.autor;
        this.isbn = libro.isbn;
        this.prestado = false;
    }

    // Getters
    public String getTitulo() { return titulo; }
    public String getAutor() { return autor; }
    public String getIsbn() { return isbn; }
    public boolean isPrestado() { return prestado; }

    // Setter
    public void setPrestado(boolean prestado) { this.prestado = prestado; }

    @Override
    public String toString() {
        return "Título: '" + titulo + '\'' +
               ", Autor: '" + autor + '\'' +
               ", ISBN: '" + isbn + '\'' +
               ", Estado: " + (prestado ? "Prestado" : "Disponible");
    }
    
    @Override
    public int compareTo(Libro otroLibro){
        //Primero compara por autor ignorando mayúscula o minúscula
        int comparacionAutor = this.autor.compareToIgnoreCase(otroLibro.getAutor());
        
        //Si los autores son diferentes, devuelve el resultado de la comparación
        if(comparacionAutor != 0){
            return comparacionAutor;
        }
        
        //Si los autores son los mismos, comparar por título ignorando mayúsucla o minúscula
        return this.titulo.compareToIgnoreCase(otroLibro.getTitulo());
    }
    
    
}
