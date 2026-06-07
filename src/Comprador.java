import Excepciones.NoHayProductoException;
import Excepciones.PagoIncorrectoException;
import Excepciones.PagoInsuficienteException;
import Monedas.*;
import Productos.*;

public class Comprador {

    private String sabor;

    private int vueltoTotal;


    public Comprador(Moneda m, Catalogo cual, Expendedor exp) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {

        this.sabor = null;
        this.vueltoTotal = 0;

        Producto p = exp.comprarProducto(m, cual);

        this.sabor = p.sabor();

        Moneda vuelto = exp.getVuelto();

        while (vuelto != null) {
            this.vueltoTotal += vuelto.getValor();
            vuelto = exp.getVuelto();
        }
    }

    public String getSabor() {
        return sabor;
    }

    public int getVueltoTotal() {
        return vueltoTotal;
    }
}
