package Productos;

public class Fanta extends Bebida {

    /** Para asignar numeros de serie a los productos
     */

    public Fanta(int numSerie) {
        super(numSerie);
    }

    /** Indica que producto fue comprado
     */

    @Override
    public String sabor() {
        return "Fanta";
    }
}