/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lab9_3;

/**
 *
 * @author David
 */
import java.util.Scanner;

public class Lab9_3 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Crear 6 usuarios
        Usuario[] usuarios = {
            new Usuario("Carlos", 12345),
            new Usuario("Ana", 67890),
            new Usuario("Luis", 23456),
            new Usuario("Maria Constanza", 78901),
            new Usuario("Pedro", 34567),
            new Usuario("Lucia", 89012)
        };

        // 1. Ingresar usuarios usando el método de la división
        System.out.println("Prueba con método de la división:");
        Chained_Hash<Usuario> tablaHashDivision = new Chained_Hash<>(5, true);  // Tabla Hash de 5 posiciones con método de la división

        // Insertar los usuarios en la tabla Hash usando el método de la división
        for (Usuario usuario : usuarios) {
            tablaHashDivision.insert(usuario.getClave(), usuario);
        }

        // Imprimir cuántos usuarios y sus detalles fueron almacenados en cada posición
        System.out.println("\nUsuarios almacenados por posición (Método de la división):");
        tablaHashDivision.printTableWithDetails();

        // 2. Ingresar usuarios usando el método de la multiplicación
        System.out.println("\nPrueba con método de la multiplicación:");
        Chained_Hash<Usuario> tablaHashMultiplicacion = new Chained_Hash<>(5, false);  // Tabla Hash de 5 posiciones con método de la multiplicación

        // Insertar los usuarios en la tabla Hash usando el método de la multiplicación
        for (Usuario usuario : usuarios) {
            tablaHashMultiplicacion.insert(usuario.getClave(), usuario);
        }

        // Imprimir cuántos usuarios y sus detalles fueron almacenados en cada posición
        System.out.println("\nUsuarios almacenados por posición (Método de la multiplicación):");
        tablaHashMultiplicacion.printTableWithDetails();

        scanner.close();
    }
}
