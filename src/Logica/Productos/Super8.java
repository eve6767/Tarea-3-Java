package Logica.Productos;

public class Super8 extends Dulce {

    /** Para asignar numeros de serie a los productos
     */

    public Super8(int numSerie) {
        super(numSerie);
    }

    /** Indica que producto fue comprado
     */

    @Override
    public String sabor(){
        return "Super8";
    }
}