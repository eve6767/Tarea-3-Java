package Stuff;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;
import Logica.*;
import Logica.Excepciones.NoHayProductoException;
import Logica.Excepciones.PagoIncorrectoException;
import Logica.Excepciones.PagoInsuficienteException;
import Logica.Monedas.*;
import Logica.Catalogo.*;


public class Ventana extends JFrame {

    /**
     * Inicializa la gran mayoria de variables que seran utilizadas para construir la interfaz del expendedor.
     * El resto de variables seran creadas al momento de necesitarlas.
     */


    private Expendedor exp;
    private Comprador comp;

    private PanelExpendedor panelExpendedor;
    private PanelComprador panelComprador;
    private PanelMonedas panelMonedas;
    private PanelProductos panelProductos;
    private JLayeredPane panelImagen;
    private JLabel e;
    private JButton consumir;
    private JPanel panelIzquierdo;
    private List<Moneda> vuelto;
    private JButton botonMoneda;

    private Catalogo cual;


    /**
     * Construye la interfaz utilizando los paneles establecidos.
     */


    public Ventana() {

        this.setTitle("Maquina Expendedora");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(700, 700);
        this.setLayout(new BorderLayout());
        this.setVisible(true);

        exp = new Expendedor(4);
        panelExpendedor = new PanelExpendedor(exp);
        panelComprador = new PanelComprador();

        vuelto = new ArrayList<>();

        ImageIcon expendedorIcono = new ImageIcon("Stuff/Imagenes/expendedorIcono.png");
        e = new JLabel(expendedorIcono);
        e.setBounds(0, 0, expendedorIcono.getIconWidth(), expendedorIcono.getIconHeight());
        panelImagen = new JLayeredPane();
        panelImagen.setPreferredSize(new Dimension(expendedorIcono.getIconWidth(), expendedorIcono.getIconHeight()));

        panelImagen.setLayout(null);
        BotonesMaquina(panelImagen);
        panelImagen.add(e, Integer.valueOf(0));
        panelMonedas = new PanelMonedas(vuelto);

        panelProductos = new PanelProductos(exp);
        panelProductos.setBounds(0, 0, expendedorIcono.getIconWidth(), expendedorIcono.getIconHeight());
        panelImagen.add(panelProductos, Integer.valueOf(0));

        setLayout(new BorderLayout());

        panelIzquierdo = new JPanel();
        panelIzquierdo.setLayout(new GridLayout(3,1));
        panelIzquierdo.add(panelExpendedor);
        panelIzquierdo.add(panelComprador);
        panelIzquierdo.add(panelMonedas);

        add(panelIzquierdo, BorderLayout.WEST);
        add(panelImagen, BorderLayout.CENTER);

        setVisible(true);

    }


    /**
     * Crea los botones que manejan la compra de un product y el saldo.
     * @param panelImagen para posicionar los botones.
     */


    public void BotonesMaquina(JLayeredPane panelImagen) {

        int x = 0;
        int y = 0;

        for (int i = 1; i <= 5; i++) {
            if (i % 2 == 1) {
                x = 0;
                y += 40;
            }

            JButton boton = new JButton(String.valueOf(i));

            boton.setBounds(350 + x, 250 + y, 40, 40);

            int numeroProducto = i;

            boton.addActionListener(e -> {

                try {
                    int saldo = panelMonedas.getSaldo();

                    if (saldo <= 0) {
                        throw new PagoIncorrectoException("No se ha ingresado dinero");
                    }

                    Moneda moneda = panelMonedas.monedaVirtual();

                    cual = switch (numeroProducto) {
                        case 1 -> Catalogo.COCACOLA;
                        case 2 -> Catalogo.FANTA;
                        case 3 -> Catalogo.SPRITE;
                        case 4 -> Catalogo.SUPER8;
                        case 5 -> Catalogo.SNICKERS;
                        default ->  throw new Exception("Producto no encontrado");
                    };

                    comp = new Comprador(moneda, cual, exp);

                    consumir = new JButton("Empuja");
                    consumir.setBounds(25, 510, 300, 110);
                    panelImagen.add(consumir, Integer.valueOf(1));
                    consumir.setVisible(true);

                    int separacionVertical = 0;
                    int vuelto = comp.getVueltoTotal();
                    Moneda m;

                    while ((m = exp.getVuelto()) != null) {

                        separacionVertical += 40;
                        botonMoneda = new JButton("$" + m.getValor());

                        botonMoneda.setBounds(350, 500 + separacionVertical, 40, 40);

                        switch (m.getValor()) {

                            case (1000):
                                botonMoneda.setBackground(Color.GREEN);
                                break;
                            case (500):
                                botonMoneda.setBackground(Color.YELLOW);
                                break;
                            case (100):
                                botonMoneda.setBackground(Color.RED);
                                break;
                        }

                        int valor = m.getValor();
                        botonMoneda.addActionListener(event -> {

                            panelMonedas.agregarSaldo(valor);
                            panelImagen.remove(botonMoneda);
                            panelImagen.repaint();

                        });

                        panelImagen.add(botonMoneda, Integer.valueOf(1));

                    }

                    if (comp.getSabor() != null) {
                        panelComprador.empuja();
                    }

                    consumir.setVisible(true);
                    consumir.addActionListener(ev -> {

                        panelComprador.actualizarComprador(comp, panelMonedas);
                        panelImagen.remove(consumir);
                        panelImagen.revalidate();
                        panelImagen.repaint();
                        panelMonedas.mostrarSaldo();

                    });

                    panelExpendedor.actualizarStock(exp);
                    actualizarImagenesProductos();

                } catch (Exception ex) {

                    JOptionPane.showMessageDialog(this,
                            "No se pudo completar la compra: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
                }
            });
            panelImagen.add(boton, Integer.valueOf(2));

            x += 40;

        }
    }


    /**
     * Actualiza el numero de productos restantes del expendedor.
     */


    public void actualizarImagenesProductos() {
        panelProductos.actualizar();
    }

}


