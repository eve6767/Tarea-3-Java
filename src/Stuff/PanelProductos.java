package Stuff;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import Logica.*;

public class PanelProductos extends JFrame {

    private Expendedor exp;
    private final String[] nombres = {"cocacola", "sprite", "fanta", "super8", "snickers"};


    // AJUSTAR ESTO RESPECTO AL TAMAÑO DE LA VENTANA


    private final int[] posicionesY = {0, 1, 2, 3, 4};



    private Map<String, Image> imagenes = new HashMap<>();


    public PanelProductos(Expendedor exp) {
        this.exp = exp;
        cargarImagenes();
    }


    private void cargarImagenes() {
        for (String nombre : nombres) {
            ImageIcon icono = new ImageIcon("java/Stuff/Imagenes/" + nombre + ".png");

            // AJUSTAR TAMAÑO IMAGENES

            imagenes.put(nombre, icono.getImage().getScaledInstance(1, 1, Image.SCALE_SMOOTH));
        }
    }

    protected void paintComponent(Graphics g) {
        super.paintComponents(g);

        int[] stocks = {

                exp.getStockCoca(),
                exp.getStockSprite(),
                exp.getStockFanta(),
                exp.getStockSuper8(),
                exp.getStockSnickers()
        };

        for (int i = 0; i < nombres.length; i++) {
            Image img = imagenes.get(nombres[i]);
            for (int j = 0; j < stocks[i]; j++) {

                // AJUSTAR POSICIONES

                g.drawImage(img, 1 + (j * 2), posicionesY[i], this);
            }
        }
    }

    public void actualizar() {
        repaint();
    }
}
