/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9_3;

/**
 *
 * @author David
 */
public class ListaDoble<T> {
    private NodoDoble<T> head;
    private NodoDoble<T> tail;
    private int size;

    public ListaDoble() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public NodoDoble<T> getHead() {
        return head;
    }

    public void addLast(T data) {
        NodoDoble<T> newNode = new NodoDoble<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrev(tail);
            tail = newNode;
        }
        size++;
    }

    // Método modificado para imprimir los usuarios en el formato deseado
    public void printList() {
        NodoDoble<T> temp = head;
        while (temp != null) {
            // Si los datos son del tipo Usuario, imprimimos en el formato requerido
            if (temp.getData() instanceof Usuario) {
                Usuario usuario = (Usuario) temp.getData();
                System.out.println("Nombre = " + usuario.getNombre() + ", # Id. = " + usuario.getClave());
            }
            temp = temp.getNext();
        }
    }
}

