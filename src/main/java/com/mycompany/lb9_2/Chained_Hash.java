/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb9_2;

/**
 *
 * @author David
 */
public class Chained_Hash<T> {
    private ListaDoble<T>[] table;  // Arreglo que almacena listas dobles genéricas
    private int m;  // Tamaño del arreglo
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

    // Buscar un dato por su clave y devolver la posición
    public int searchWithPosition(int k) {
        int hashValue = useDivisionMethod ? hashDivision(k) : hashMultiplication(k);
        NodoDoble<T> current = table[hashValue].getHead();
        while (current != null) {
            if (current.getData().equals(k)) {
                return hashValue;  // Retornar la posición en la tabla hash
            }
            current = current.getNext();
        }
        return -1;  // Retornar -1 si no se encuentra el número
    }

    // Eliminar un dato por su clave y devolver la posición
    public int deleteWithPosition(int k) {
        int hashValue = useDivisionMethod ? hashDivision(k) : hashMultiplication(k);
        NodoDoble<T> current = table[hashValue].getHead();
        while (current != null) {
            if (current.getData().equals(k)) {
                table[hashValue].remove(current);
                return hashValue;  // Retornar la posición donde se eliminó el número
            }
            current = current.getNext();
        }
        return -1;  // Retornar -1 si no se encuentra el número
    }

    // Imprimir la tabla hash
    public void printTable() {
        for (int i = 0; i < m; i++) {
            System.out.println("Posición " + i + ": ");
            table[i].printList();
        }
    }
}

