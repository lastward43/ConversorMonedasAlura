package com.conversormonedas;
import javax.swing.*;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class VentanaPrincipal extends JFrame{
	private Conversor conversor;
    private JTextField inputCantidad;
    private JComboBox<String> comboMonedaOrigen;
    private JComboBox<String> comboMonedaDestino;
    private JLabel labelResultado;

    public VentanaPrincipal() {
        conversor = new Conversor();
        setTitle("Convertidor de Monedas");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(4, 2));

        JLabel labelCantidad = new JLabel("Cantidad:");
        inputCantidad = new JTextField();
        JLabel labelMonedaOrigen = new JLabel("De:");
        comboMonedaOrigen = new JComboBox<>(new String[]{"Pesos Argentinos", "Dólar", "Euro", "Libra", "Yen", "Won"});
        JLabel labelMonedaDestino = new JLabel("A:");
        comboMonedaDestino = new JComboBox<>(new String[]{"Pesos Argentinos", "Dólar", "Euro", "Libra", "Yen", "Won"});

        JButton botonConvertir = new JButton("Convertir");
        labelResultado = new JLabel("Resultado: ");

        botonConvertir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                convertirMoneda();
            }
        });

        panel.add(labelCantidad);
        panel.add(inputCantidad);
        panel.add(labelMonedaOrigen);
        panel.add(comboMonedaOrigen);
        panel.add(labelMonedaDestino);
        panel.add(comboMonedaDestino);
        panel.add(botonConvertir);
        panel.add(labelResultado);

        add(panel);
    }

    private void convertirMoneda() {
        try {
            double cantidad = Double.parseDouble(inputCantidad.getText());
            String monedaOrigen = (String) comboMonedaOrigen.getSelectedItem();
            String monedaDestino = (String) comboMonedaDestino.getSelectedItem();
            double resultado = 0.0;

            if (monedaOrigen.equals("Pesos Argentinos")) {
                if (monedaDestino.equals("Dólar")) {
                    resultado = conversor.convertirPesosADolar(cantidad);
                } else if (monedaDestino.equals("Euro")) {
                    resultado = conversor.convertirPesosAEuro(cantidad);
                } else if (monedaDestino.equals("Libra")) {
                    resultado = conversor.convertirPesosALibra(cantidad);
                } else if (monedaDestino.equals("Yen")) {
                    resultado = conversor.convertirPesosAYen(cantidad);
                } else if (monedaDestino.equals("Won")) {
                    resultado = conversor.convertirPesosAWon(cantidad);
                }
            } else if (monedaOrigen.equals("Dólar")) {
                resultado = conversor.convertirDolarAPesos(cantidad);
            } else if (monedaOrigen.equals("Euro")) {
                resultado = conversor.convertirEuroAPesos(cantidad);
            } else if (monedaOrigen.equals("Libra")) {
                resultado = conversor.convertirLibraAPesos(cantidad);
            } else if (monedaOrigen.equals("Yen")) {
                resultado = conversor.convertirYenAPesos(cantidad);
            } else if (monedaOrigen.equals("Won")) {
                resultado = conversor.convertirWonAPesos(cantidad);
            }

            // Redondear el resultado a 2 decimales
            resultado = Math.round(resultado * 100.0) / 100.0;

            labelResultado.setText("Resultado: " + resultado);
        } catch (NumberFormatException e) {
            labelResultado.setText("Ingrese una cantidad válida.");
        }
    }
}
