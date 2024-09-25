/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb9_2;

/**
 *
 * @author David
 */
public class Usuario {
    private String nombre;
    private int clave;  // La clave debe ser un campo en Usuario

    public Usuario(String nombre, int clave) {
        this.nombre = nombre;
        this.clave = clave;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getClave() {  // Nuevo: Método para obtener la clave
        return clave;
    }

    public void setClave(int clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "Usuario{" + "nombre='" + nombre + "', clave=" + clave + '}';
    }
}
