package Logica;

import java.util.*;

public class Deposito<T> {

    private ArrayList<T> almacen;

    public Deposito() {
        this.almacen = new ArrayList<T>();
    }

    public void addElemento(T item) {
        this.almacen.add(item);
    }

    public T getElemento() {
        if (almacen.isEmpty()) return null;
        return almacen.remove(0);
    }

    public int size() {
        return almacen.size();
    }
}