package Logica.Productos;

public class CocaCola extends Bebida {


    /** Para asignar numeros de serie a los productos
     */

    public CocaCola(int numSerie) {
        super(numSerie);
    }

    /** Indica que producto fue comprado
     */

    @Override
    public String sabor() {
        return "CocaCola";
    }


}