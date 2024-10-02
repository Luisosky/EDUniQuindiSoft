package co.edu.uniquindio.uniquindisoft.utils;

import java.util.Iterator;
import co.edu.uniquindio.uniquindisoft.model.Nodo;

public class LinkedListCustom<T> implements Iterable<T> {

    private Nodo<T> cabeza;
    private Nodo<T> cola;

    public void add(T data) {
        Nodo<T> nuevoNodo = new Nodo<>(data);
        if (cabeza == null) {
            cabeza = nuevoNodo;
            cola = nuevoNodo;
        } else {
            cola.setNext(nuevoNodo);
            cola = nuevoNodo;
        }
    }

    public T get(int index) {
        Nodo<T> actual = cabeza;
        if (index < 0) {
            throw new IndexOutOfBoundsException();
        }
        for (int i = 0; i < index; i++) {
            if (actual == null) {
                throw new IndexOutOfBoundsException();
            }
            actual = actual.getNext();
        }
        if (actual == null) {
            throw new IndexOutOfBoundsException();
        }
        return actual.getData();
    }

    public void remove(int index) {
        if (cabeza == null) {
            throw new IndexOutOfBoundsException();
        }
        if (index == 0) {
            cabeza = cabeza.getNext();
        } else {
            Nodo<T> actual = cabeza;
            for (int i = 0; i < index - 1; i++) {
                if (actual == null) {
                    throw new IndexOutOfBoundsException();
                }
                actual = actual.getNext();
            }
            if (actual == null || actual.getNext() == null) {
                throw new IndexOutOfBoundsException();
            }
            actual.setNext(actual.getNext().getNext());
        }
    }

    public int size() {
        int size = 0;
        Nodo<T> actual = cabeza;
        while (actual != null) {
            size++;
            actual = actual.getNext();
        }
        return size;
    }

    public boolean isEmpty() {
        return cabeza == null;
    }

    public void clear() {
        cabeza = null;
        cola = null;
    }

    public boolean contains(T data) {
        Nodo<T> actual = cabeza;
        while (actual != null) {
            if (actual.getData().equals(data)) {
                return true;
            }
            actual = actual.getNext();
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorCustom<>(cabeza);
    }
}