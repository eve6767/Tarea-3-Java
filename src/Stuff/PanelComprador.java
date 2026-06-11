package Stuff;

import Logica.*;
import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{

    private JLabel productoLabel;
    private JLabel vueltoLabel;


    /**
    Crea un Panel que muestra el producto comprado y si lo hay, el vuelto.
     */

    public PanelComprador() {

        setLayout(new GridLayout(2,1));
        setBorder(BorderFactory.createTitledBorder("Comprador"));

        productoLabel = new JLabel("Producto comprado: ");
        vueltoLabel = new JLabel("Vuelto: ");

        add(productoLabel);
        add(vueltoLabel);

    }


    /**
     * Actualiza el comprador tras una compra exitossa y suma el vuelto al saldo disponible.
     * @param comp para extraer el nombre del producto y el vuelto.
     * @param panelMonedas panel que maneja las operaciones del saldo.
     */


    public void actualizarComprador(Comprador comp, PanelMonedas panelMonedas) {

        productoLabel.setText("Producto Comprado: " + comp.getSabor());
        int vueltoTotal = comp.getVueltoTotal();
        panelMonedas.agregarSaldo(vueltoTotal);
        vueltoLabel.setText("Vuelto recibido : &" + vueltoTotal);

    }


    /**
     * Anuncia que un producto esta listo para ser retirado.
     */


    public void empuja() {
        productoLabel.setText("Producto comprado exitosamente, retire");
    }

}