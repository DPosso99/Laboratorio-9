/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9_3;

/**
 *
 * @author David
 */
public class Chained_Hash<T> {
    private ListaDoble<T>[] table;  // Arreglo que almacena listas dobles genéricas
    private int m;  // Tamaño del arreglo (5 en este caso)
    private boolean useDivisionMethod;  // true para método de la división, false para método de la multiplicación
    private final double A = (Math.sqrt(5) - 1) / 2;  // Constante para método de la multiplicación

    // Constructor que permite definir el tamaño del arreglo y el método de hash
    public Chained_Hash(int size, boolean useDivisionMethod) {
        this.m = size;
        this.useDivisionMethod = useDivisionMethod;
        table = new ListaDoble[m];  // Inicializar el arreglo con listas dobles vacías
        for (int i = 0; i < m; i++) {
            table[i] = new ListaDoble<>();  // Cada posición es una ListaDoble genérica
        }
    }

    // Método hash usando la división
    private int hashDivision(int k) {
        return k % m;
    }

    // Método hash usando la multiplicación
    private int hashMultiplication(int k) {
        return (int) Math.floor(m * ((k * A) % 1));
    }

    // Insertar un nuevo dato de tipo T
    public void insert(int k, T data) {
        int hashValue = useDivisionMethod ? hashDivision(k) : hashMultiplication(k);
        table[hashValue].addLast(data);
    }

    // Contar cuántos usuarios están en una posición dada
    public int countUsersInPosition(int position) {
        return table[position].getSize();  // Obtener el tamaño de la lista en la posición dada
    }

    // Imprimir la tabla hash y los detalles de los usuarios (nombre y clave) en cada posición
    public void printTableWithDetails() {
        for (int i = 0; i < m; i++) {
            System.out.println("Posición " + i + ": " + countUsersInPosition(i) + " usuarios");
            table[i].printList();  // Imprimir la lista de usuarios en la posición
        }
    }
}


