package Stuff;

import javax.swing.*;
import java.awt.*;
import Logica.*;

public class Ventana extends JFrame {

    private Expendedor exp;
    private PanelExpendedor panelExpendedor;

    public Ventana() {

        this.setTitle("Maquina Expendedora");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        // PUEDE SER NECESARIO AJUSTAR TAMAÑO

        this.setSize(1280, 720);
        this.setLayout(new BorderLayout());
        this.setVisible(true);




    }

}
