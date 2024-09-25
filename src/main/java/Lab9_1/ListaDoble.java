/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Lab9_1;

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

    public void remove(NodoDoble<T> node) {
        if (node == head) {
            head = head.getNext();
            if (head != null) {
                head.setPrev(null);
            }
        } else if (node == tail) {
            tail = tail.getPrev();
            if (tail != null) {
                tail.setNext(null);
            }
        } else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
        size--;
    }

    public void printList() {
        NodoDoble<T> temp = head;
        while (temp != null) {
            if (temp.getData() instanceof Usuario) {
                Usuario usuario = (Usuario) temp.getData();
                System.out.println("nombre = " + usuario.getNombre() + ", clave = " + usuario.getClave());
            }
            temp = temp.getNext();
        }
    }
}
