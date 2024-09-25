/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.lb9_2;

/**
 *
 * @author David
 */
import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Lb9_2 {
     public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        // Generar 20 números aleatorios entre 0 y 100
        ArrayList<Integer> numerosAleatorios = new ArrayList<>();
        System.out.println("Números aleatorios generados:");
        for (int i = 0; i < 20; i++) {
            int numero = random.nextInt(101);  // Genera números entre 0 y 100
            numerosAleatorios.add(numero);
            System.out.print(numero + " ");
        }
        System.out.println();

        // Variables para almacenar las tablas hash
        Chained_Hash<Integer> tablaHashDivision = new Chained_Hash<>(10, true);
        Chained_Hash<Integer> tablaHashMultiplicacion = new Chained_Hash<>(10, false);

        // Insertar los números aleatorios en ambas tablas hash (división y multiplicación)
        for (int num : numerosAleatorios) {
            tablaHashDivision.insert(num, num);
            tablaHashMultiplicacion.insert(num, num);
        }

        boolean continuar = true;
        while (continuar) {
            // Mostrar opciones de método hash
            System.out.println("\nSelecciona el método hash:");
            System.out.println("1. Método de la División");
            System.out.println("2. Método de la Multiplicación");
            int metodoHash = scanner.nextInt();

            // Elegir la tabla hash según el método
            Chained_Hash<Integer> tablaHashSeleccionada = (metodoHash == 1) ? tablaHashDivision : tablaHashMultiplicacion;
            String metodo = (metodoHash == 1) ? "división" : "multiplicación";

            // Mostrar la tabla hash seleccionada
            System.out.println("\nTabla Hash con método de la " + metodo + ":");
            tablaHashSeleccionada.printTable();

            // Preguntar si quiere buscar o eliminar
            System.out.println("\n¿Qué deseas hacer?");
            System.out.println("1. Buscar un número");
            System.out.println("2. Eliminar un número");
            System.out.println("3. Salir");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1: // Buscar
                    System.out.print("\nIngresa el número que quieres buscar o escribe 'salir' para terminar: ");
                    if (scanner.hasNextInt()) {
                        int numeroBuscar = scanner.nextInt();
                        int posicionEncontrado = tablaHashSeleccionada.searchWithPosition(numeroBuscar);
                        if (posicionEncontrado != -1) {
                            System.out.println("Número " + numeroBuscar + " encontrado en la posición: " + posicionEncontrado);
                        } else {
                            System.out.println("Número " + numeroBuscar + " no encontrado.");
                        }
                    }
                    break;

                case 2: // Eliminar
                    System.out.print("\nIngresa el número que quieres eliminar o escribe 'salir' para terminar: ");
                    if (scanner.hasNextInt()) {
                        int numeroEliminar = scanner.nextInt();
                        int posicionEliminado = tablaHashSeleccionada.deleteWithPosition(numeroEliminar);
                        if (posicionEliminado != -1) {
                            System.out.println("Número " + numeroEliminar + " eliminado de la posición: " + posicionEliminado);
                            // Actualizar la lista de números aleatorios
                            numerosAleatorios.remove(Integer.valueOf(numeroEliminar));
                            System.out.println("\nNúmeros restantes: " + numerosAleatorios);
                        } else {
                            System.out.println("Número " + numeroEliminar + " no encontrado.");
                        }
                    }
                    // Mostrar la tabla hash después de eliminar
                    System.out.println("\nTabla Hash después de eliminar un número (método de la " + metodo + "):");
                    tablaHashSeleccionada.printTable();
                    break;

                case 3: // Salir
                    continuar = false;
                    break;

                default:
                    System.out.println("Opción no válida.");
            }

            // Preguntar si desea continuar o salir
            if (opcion != 3) {
                System.out.print("\n¿Deseas continuar (sí/no)? ");
                String respuesta = scanner.next();
                if (respuesta.equalsIgnoreCase("no")) {
                    continuar = false;
                }
            }
        }

        scanner.close();
    }
}

