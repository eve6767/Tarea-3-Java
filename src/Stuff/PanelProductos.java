package Stuff;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import Logica.*;

public class PanelProductos extends JPanel {

    private Expendedor exp;
    private final String[] nombres = {"cocacola", "fanta", "sprite", "super8", "snickers"};

    private final int[] posicionesY = {70, 155, 240, 330, 420};



    private Map<String, Image> Imagenes = new HashMap<>();


    /**
     * Carga las imagenes de cada producto del expendedor.
     * @param exp el expendedor.
     */


    public PanelProductos(Expendedor exp) {
        this.exp = exp;
        cargarImagenes();
    }


    /**
     * Devuelve las imagenes que representaran cada producto.
     */


    private void cargarImagenes() {
        for (String nombre : nombres) {
            ImageIcon icono = new ImageIcon("Stuff/Imagenes/" + nombre + ".png");

            Imagenes.put(nombre, icono.getImage().getScaledInstance(50, 50, Image.SCALE_SMOOTH));
        }
    }


    /**
     * Asigna su respectiva imagen a cada producto.
     * @param g el paintComponent.
     */


    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        int[] stocks = {

                exp.getStockCoca(),
                exp.getStockFanta(),
                exp.getStockSprite(),
                exp.getStockSuper8(),
                exp.getStockSnickers()
        };

        for (int i = 0; i < nombres.length; i++) {
            Image img = Imagenes.get(nombres[i]);
            for (int j = 0; j < stocks[i]; j++) {

                g.drawImage(img, 30 + (j * 50), posicionesY[i], this);
            }
        }
    }

    public void actualizar() {
        repaint();
    }
}
