import Monedas.*;
import Productos.*;

public class Main {
    public static void main(String[] args) {


        int xd = 3; // hacer que pida el numero de productos al iniciar (?)

        Expendedor exp = new Expendedor(xd);

        try {
            Comprador test1 = new Comprador(new Moneda1000(), Catalogo.SPRITE, exp);
            System.out.println(test1.getSabor());
            System.out.println(test1.getVueltoTotal());
            System.out.println();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

    }
}