package Stuff;

import Logica.*;
import Logica.Productos.CocaCola;

import javax.swing.*;
import java.awt.*;


public class PanelExpendedor extends JPanel {

    public PanelExpendedor(Expendedor exp) {

        setLayout(new GridLayout(5,1));
        setBorder(BorderFactory.createTitledBorder("Stock del Expendedor y Precio"));

        JLabel cocaLabel = new JLabel("CocaCola: " + Catalogo.COCACOLA.getPrecio());
        JLabel spriteLabel = new JLabel("Sprite: " + Catalogo.SPRITE.getPrecio());
        JLabel fantaLabel = new JLabel("Fanta: " + Catalogo.FANTA.getPrecio());
        JLabel super8Label = new JLabel("Super8: " + Catalogo.SUPER8.getPrecio());
        JLabel snickersLabel = new JLabel("Snickers: " + Catalogo.SNICKERS.getPrecio());

        add(cocaLabel);
        add(spriteLabel);
        add(fantaLabel);
        add(super8Label);
        add(snickersLabel);
    }
}
