package Logica.Productos;

public class Snickers extends Dulce {

    /** Para asignar numeros de serie a los productos
     */

    public Snickers(int numSerie) {
        super(numSerie);
    }


    /** Indica que producto fue comprado
     */

    @Override
    public String sabor() {
        return "Snickers";
    }

}