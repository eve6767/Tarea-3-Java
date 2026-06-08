package Logica;

public enum Catalogo {

    COCACOLA(1, 100),
    FANTA(2, 200),
    SPRITE(3, 300),
    SUPER8(4, 400),
    SNICKERS(5, 500);

    private final int ID;
    private final int Precio;

    //Constructor que define la ID y Precio de cada producto

    Catalogo(int ID, int Precio) {
        this.ID = ID;
        this.Precio = Precio;
    }

    public int getPrecio() {
        return Precio;
    }

    public int getID() {
        return ID;
    }
}