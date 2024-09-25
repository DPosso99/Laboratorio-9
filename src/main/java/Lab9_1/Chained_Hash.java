/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab9_1;

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
    @SuppressWarnings("unchecked")
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

    // Buscar un dato por su clave y devolver el objeto Usuario
    public Usuario search(int k) {
        int hashValue = useDivisionMethod ? hashDivision(k) : hashMultiplication(k);
        NodoDoble<T> current = table[hashValue].getHead();
        while (current != null) {
            // Realizar un casteo explícito a Usuario
            if (current.getData() instanceof Usuario) {
                Usuario usuario = (Usuario) current.getData();
                if (usuario.getClave() == k) {
                    return usuario;  // Retornar el objeto Usuario
                }
            }
            current = current.getNext();
        }
        return null;  // Retornar null si no se encuentra el número
    }

    // Eliminar un dato por su clave y devolver si se eliminó
    public boolean delete(int k) {
        int hashValue = useDivisionMethod ? hashDivision(k) : hashMultiplication(k);
        NodoDoble<T> current = table[hashValue].getHead();
        while (current != null) {
            if (current.getData() instanceof Usuario) {
                Usuario usuario = (Usuario) current.getData();
                if (usuario.getClave() == k) {
                    table[hashValue].remove(current);
                    return true;  // Retornar true si se eliminó
                }
            }
            current = current.getNext();
        }
        return false;  // Retornar false si no se encontró el número
    }

    // Imprimir la tabla hash
    public void printTable() {
        for (int i = 0; i < m; i++) {
            System.out.println("Posición " + i + ": ");
            table[i].printList();
        }
    }
}
