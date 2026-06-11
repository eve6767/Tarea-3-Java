package Stuff;

import Logica.*;
import javax.swing.*;
import java.awt.*;


public class PanelExpendedor extends JPanel {

    private JLabel cocaLabel;
    private JLabel spriteLabel;
    private JLabel fantaLabel;
    private JLabel super8Label;
    private JLabel snickersLabel;


    /**
     * Crea un panel que muestra el stock y precio de cada producto.
     * @param exp en el que busca el stock y precio.
     */


    public PanelExpendedor(Expendedor exp) {

        setLayout(new GridLayout(5,1));
        setBorder(BorderFactory.createTitledBorder("Stock del Expendedor y Precio"));

        cocaLabel = new JLabel("CocaCola: " + exp.getStockCoca() + " $" + Catalogo.COCACOLA.getPrecio());
        spriteLabel = new JLabel("Fanta: " + exp.getStockFanta() + " $" + Catalogo.FANTA.getPrecio());
        fantaLabel = new JLabel("Sprite: " + exp.getStockSprite() + " $" + Catalogo.SPRITE.getPrecio());
        super8Label = new JLabel("Super8: " + exp.getStockSuper8() + " $" + Catalogo.SUPER8.getPrecio());
        snickersLabel = new JLabel("Snickers: " + exp.getStockSnickers() + " $" + Catalogo.SNICKERS.getPrecio());

        add(cocaLabel);
        add(spriteLabel);
        add(fantaLabel);
        add(super8Label);
        add(snickersLabel);

    }

    /**
     * Actualiza el stock de cada producto.
     * @param exp para revisar el stock disponible.
     */



    public void actualizarStock(Expendedor exp) {

        cocaLabel.setText("CocaCola: " + exp.getStockCoca());
        fantaLabel.setText("Fanta: " + exp.getStockFanta());
        spriteLabel.setText("Sprite: " + exp.getStockSprite());
        super8Label.setText("Super8: " + exp.getStockSuper8());
        snickersLabel.setText("Snickers: " + exp.getStockSnickers());

    }
}
