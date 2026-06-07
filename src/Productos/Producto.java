package Productos;

// Se define la clase abstracta "Producto" de la que se basara toda la mercancia disponible

public abstract class Producto {

    // Numero de serie de un producto, para distinguirlos entre si

    private int numSerie;

    public Producto(int numSerie) {
        this.numSerie = numSerie;
    }

    public abstract String sabor();

    // Devuelve el numero de serie de un producto

    public int getNumSerie(){
        return numSerie;
    }

}