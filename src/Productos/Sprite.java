package Productos;

public class Sprite extends Bebida {

    /** Para asignar numeros de serie a los productos
     */

    public Sprite(int numSerie) {
        super(numSerie);
    }

    /** Indica que producto fue comprado
     */

    @Override
    public String sabor() {
        return "Sprite";
    }

}