/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lb9_2;

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

    public void addFirst(T data) {
        NodoDoble<T> newNode = new NodoDoble<>(data);
        if (isEmpty()) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head.setPrev(newNode);
            head = newNode;
        }
        size++;
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

    public void printList() {
        NodoDoble<T> temp = head;
        while (temp != null) {
            System.out.println(temp.getData());
            temp = temp.getNext();
        }
    }

    public void remove(NodoDoble<T> node) {
        if (node == null) return;

        if (node.getPrev() != null) {
            node.getPrev().setNext(node.getNext());
        } else {
            head = node.getNext();  // Si el nodo es el primero, actualizamos el head
        }

        if (node.getNext() != null) {
            node.getNext().setPrev(node.getPrev());
        } else {
            tail = node.getPrev();  // Si el nodo es el último, actualizamos el tail
        }

        size--;
    }
}

