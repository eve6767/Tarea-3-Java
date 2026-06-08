package Stuff;

import Logica.*;
import javax.swing.*;
import java.awt.*;

public class PanelComprador extends JPanel{

    public PanelComprador() {

        setLayout(new GridLayout(2,1));
        setBorder(BorderFactory.createTitledBorder("Comprador"));

        JLabel productoLabel = new JLabel("Producto comprado: ");
        JLabel vueltoLabel = new JLabel("Vuelto: ");

        add(productoLabel);
        add(vueltoLabel);

    }

    public void actualizarComprador(Comprador comp, PanelMonedas panelMonedas) {

    }





}