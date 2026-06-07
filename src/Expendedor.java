import Excepciones.NoHayProductoException;
import Excepciones.PagoIncorrectoException;
import Excepciones.PagoInsuficienteException;
import Monedas.*;
import Productos.*;


public class Expendedor {

    private Deposito<Producto> depCoca;
    private Deposito<Producto> depFnt;
    private Deposito<Producto> depSprt;
    private Deposito<Producto> depSup8;
    private Deposito<Producto> depSnick;

    private Deposito<Moneda> monedaVuelto;

    public Expendedor(int numProductos) {

        //inicializa depositos

        this.depCoca = new Deposito<>();
        this.depFnt = new Deposito<>();
        this.depSprt = new Deposito<>();
        this.depSup8 = new Deposito<>();
        this.depSnick = new Deposito<>();

        this.monedaVuelto = new Deposito<>();


        for (int i = 0; i < numProductos; i++) {

            depCoca.addElemento(new CocaCola(100 + i));
            depFnt.addElemento(new Fanta(200 + i));
            depSprt.addElemento(new Sprite(300 + i));
            depSup8.addElemento(new Super8(400 + i));
            depSnick.addElemento(new Snickers(500 + i));

        }
    }

    public Producto comprarProducto(Moneda m, Catalogo cual) throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException {

        if (m == null) {
            throw new PagoIncorrectoException("No se ha ingresado una moneda.");
        }

        int valor = m.getValor();

        if (m.getValor() < cual.getPrecio()) {
            throw new PagoInsuficienteException("Dinero insuficiente");
        }

        Producto p = switch (cual) {

            case COCACOLA -> depCoca.getElemento();
            case FANTA -> depFnt.getElemento();
            case SPRITE -> depSprt.getElemento();
            case SUPER8 -> depSup8.getElemento();
            case SNICKERS -> depSnick.getElemento();

        };

        if (p == null) {
            monedaVuelto.addElemento(m);
            throw new NoHayProductoException("No quedan " + cual.name());
        }

        int precio = cual.getPrecio();


        if (valor >= precio) {
            int vuelto = m.getValor() - cual.getPrecio();
            while (vuelto / 100 > 0) {
                monedaVuelto.addElemento(new Moneda100());
                vuelto -= 100;
            }

        }

        return p;


    }

    // FALTA EL VUELTO
    public Moneda getVuelto() {
        return monedaVuelto.getElemento();
    }


}

