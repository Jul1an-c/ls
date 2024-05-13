package expotec1;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.border.LineBorder;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.DefaultTableModel;

public class Tabla extends JFrame {

    private Font Titulos = new Font("Arial", Font.BOLD, 40);
    private Font Font1 = new Font("Arial", Font.BOLD, 14);
    private JTable tabla;

    public Tabla() {
        //Caracteristicas de la JFRAME  
        this.setLayout(null);
        this.setTitle("Fechas");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#5BC0F8"));

        this.Inicializar();
    }

    public void Inicializar() {
        Etiquetas();
        CajasTexto();
        ComBo();
        Botones();
        Tabla();
    }

    public void Etiquetas() {
        JLabel etiquetaNombre = new JLabel("Nombre de Estudiante:");
        etiquetaNombre.setFont(Font1);
        etiquetaNombre.setBounds(50, 50, 200, 30);
        this.add(etiquetaNombre);

        JLabel etiquetaTipoVehiculo = new JLabel("Tipo Vehiculo:");
        etiquetaTipoVehiculo.setFont(Font1);
        etiquetaTipoVehiculo.setBounds(50, 100, 200, 30);
        this.add(etiquetaTipoVehiculo);

        JLabel etiquetaPlacaVehiculo = new JLabel("Placa de Vehiculo:");
        etiquetaPlacaVehiculo.setFont(Font1);
        etiquetaPlacaVehiculo.setBounds(50, 150, 200, 30);
        this.add(etiquetaPlacaVehiculo);

        JLabel etiquetaFecha = new JLabel("Fecha:");
        etiquetaFecha.setFont(Font1);
        etiquetaFecha.setBounds(50, 200, 200, 30);
        this.add(etiquetaFecha);

        JLabel etiquetaMarcaVehiculo = new JLabel("Marca de Vehiculo:");
        etiquetaMarcaVehiculo.setFont(Font1);
        etiquetaMarcaVehiculo.setBounds(50, 250, 200, 30);
        this.add(etiquetaMarcaVehiculo);

        JLabel etiquetaNumLicencia = new JLabel("No. Licencia:");
        etiquetaNumLicencia.setFont(Font1);
        etiquetaNumLicencia.setBounds(50, 300, 200, 30);
        this.add(etiquetaNumLicencia);

        JLabel etiquetaNombreSecretario = new JLabel("Nombre Secretario:");
        etiquetaNombreSecretario.setFont(Font1);
        etiquetaNombreSecretario.setBounds(50, 350, 200, 30);
        this.add(etiquetaNombreSecretario);
    }

    public void CajasTexto() {
        JTextField campoNombre = new JTextField();
        campoNombre.setBounds(250, 50, 200, 30);
        this.add(campoNombre);

        JTextField campoTipoVehiculo = new JTextField();
        campoTipoVehiculo.setBounds(250, 100, 200, 30);
        this.add(campoTipoVehiculo);

        JTextField campoPlacaVehiculo = new JTextField();
        campoPlacaVehiculo.setBounds(250, 150, 200, 30);
        this.add(campoPlacaVehiculo);

        JTextField campoFecha = new JTextField();
        campoFecha.setBounds(250, 200, 200, 30);
        this.add(campoFecha);

        JTextField campoMarcaVehiculo = new JTextField();
        campoMarcaVehiculo.setBounds(250, 250, 200, 30);
        this.add(campoMarcaVehiculo);

        JTextField campoNumLicencia = new JTextField();
        campoNumLicencia.setBounds(250, 300, 200, 30);
        this.add(campoNumLicencia);

        JTextField campoNombreSecretario = new JTextField();
        campoNombreSecretario.setBounds(250, 350, 200, 30);
        this.add(campoNombreSecretario);
    }

    public void ComBo() {
        JComboBox<String> comboNombre = new JComboBox<>();
        comboNombre.setBounds(500, 50, 200, 30);
        this.add(comboNombre);

        // Agrega más combobox si es necesario
    }

    public void Botones() {
        JButton botonGuardar = new JButton("Guardar");
        botonGuardar.setBounds(50, 400, 100, 30);
        this.add(botonGuardar);

        JButton botonCancelar = new JButton("Cancelar");
        botonCancelar.setBounds(160, 400, 100, 30);
        this.add(botonCancelar);

        // Agrega más botones si es necesario
    }

    public void Tabla() {
        String[] columnas = {"Nombre de Estudiante", "Tipo Vehiculo", "Placa de Vehiculo", "Fecha",
                "Marca de Vehiculo", "No. Licencia", "Nombre Secretario"};

        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);
        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(500, 100, 400, 300);
        this.add(scrollPane);
    }
}