package Stuff;

import Logica.*;
import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{

    private JLabel productoLabel;
    private JLabel vueltoLabel;


    public PanelComprador() {

        setLayout(new GridLayout(2,1));
        setBorder(BorderFactory.createTitledBorder("Comprador"));

        productoLabel = new JLabel("Producto comprado: ");
        vueltoLabel = new JLabel("Vuelto: ");

        add(productoLabel);
        add(vueltoLabel);

    }

    public void actualizarComprador(Comprador comp, PanelMonedas panelMonedas) {

        productoLabel.setText("Producto Comprado: " + comp.getSabor());
        int vueltoTotal = comp.getVueltoTotal();
        panelMonedas.agregarSaldo(vueltoTotal);
        vueltoLabel.setText("Vuelto recibido : &" + vueltoTotal);

    }

    public void empuja() {
        productoLabel.setText("Producto comprado exitosamente, retire");
    }

}