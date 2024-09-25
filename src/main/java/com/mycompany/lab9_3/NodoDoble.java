/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.lab9_3;

/**
 *
 * @author David
 */
public class NodoDoble<T> {
    private T data;
    private NodoDoble<T> next;
    private NodoDoble<T> prev;

    public NodoDoble(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public T getData() {
        return data;
    }

    public void setNext(NodoDoble<T> next) {
        this.next = next;
    }

    public NodoDoble<T> getNext() {
        return next;
    }

    public void setPrev(NodoDoble<T> prev) {
        this.prev = prev;
    }

    public NodoDoble<T> getPrev() {
        return prev;
    }
}

