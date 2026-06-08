package Stuff;

import Logica.Monedas.*;
import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class PanelMonedas extends JPanel {

    private JLabel dineroLabel;
    private int saldo = 0;


    public PanelMonedas(ArrayList<Moneda> monedas) {

        setLayout(new BorderLayout());
        setBorder(BorderFactory.createTitledBorder("Monedero"));

        DefaultListModel monedasModel = new DefaultListModel<>();

        for (Moneda m : monedas) {
            monedasModel.addElement("Moneda: &" + m.getValor());
        }

        JList monedasList = new JList<>(monedasModel);

        add(new JScrollPane(monedasList), BorderLayout.WEST);

        JPanel botonesPanel = new JPanel();
        botonesPanel.setLayout(new GridLayout(5, 1, 5, 5));

        dineroLabel = new JLabel("Saldo Disponible:" + getSaldo());


        JButton boton1 = new JButton("100");
        boton1.setBackground(Color.RED);
        boton1.setOpaque(true);
        boton1.setBorderPainted(false);
        boton1.setForeground(Color.BLACK);

        JButton boton2 = new JButton("500");
        boton2.setBackground(Color.YELLOW);
        boton2.setOpaque(true);
        boton2.setBorderPainted(false);
        boton2.setForeground(Color.BLACK);

        JButton boton3 = new JButton("1000");
        boton3.setBackground(Color.GREEN);
        boton3.setOpaque(true);
        boton3.setBorderPainted(false);
        boton3.setForeground(Color.BLACK);


        botonesPanel.add(dineroLabel);

        botonesPanel.add(boton1);
        botonesPanel.add(boton2);
        botonesPanel.add(boton3);


        boton1.addActionListener(e -> agregarMoneda(new Moneda100()));
        boton2.addActionListener(e -> agregarMoneda(new Moneda500()));
        boton3.addActionListener(e -> agregarMoneda(new Moneda1000()));

        add(botonesPanel, BorderLayout.WEST);

    }

    public int getSaldo() {
        return saldo;
    }

    public void mostrarSaldo() {
        dineroLabel.setText("Saldo Disponible: " + getSaldo());
    }

    public void agregarMoneda(Moneda m) {
        if (m != null) {
            this.saldo += m.getValor();
            mostrarSaldo();
        } else {
            mostrarSaldo();
        }
    }


    public void agregarSaldo(int x) {
        saldo += x;
    }

    public void quitarSaldo(int x) {
        saldo -= x;
    }

    public Moneda monedaVirtual() {

        int m = getSaldo();

        if (m >= 1000) {
            quitarSaldo(1000);
            return new Moneda1000();
        } else if (m >= 500) {
            quitarSaldo(500);
            return new Moneda500();
        } else if (m >= 100) {
            quitarSaldo(100);
            return new Moneda100();
        } else {
            return null;
        }

    }

}
