package Stuff;

import javax.swing.*;

public class Separador {

    private JLabel separador;


    /**
     * Separador simple creado por conveniencia.
     */


    public Separador() {
        separador = new JLabel("------------------------------------------");
    }

    public JLabel getLabel() {
        return separador;
    }

}
