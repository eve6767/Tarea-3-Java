package Logica;

import Logica.Excepciones.*;
import Logica.Productos.Producto;
import Logica.Monedas.*;

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
