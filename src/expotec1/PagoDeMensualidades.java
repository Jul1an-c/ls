package expotec1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class PagoDeMensualidades extends JFrame {

    private JTextField nombre;
    private JTextField apellido;
    private JTextField correo;
    private JTextField fecha;
    private JTextField tarjeta;
    private JTextField direccion;
    private JTextField codigo;
    private JTextField telefono;
    
    private Font Titulos = new Font("Arial", Font.BOLD, 40);
    private final Font font1 = new Font("Arial", Font.BOLD, 16);
    private final Font font2 = new Font("Arial", Font.BOLD, 20);

    public PagoDeMensualidades() {
        this.setLayout(null);
        this.setTitle("Pago| de Mensualidad");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#5BC0F8"));

        this.inicializarComponentes();
    }

    private void inicializarComponentes() {
        agregarEtiquetas();
        agregarCajasTexto();
        agregarBotones();
        tabla();
    }

    private void agregarEtiquetas() {
        JLabel img = new JLabel(new ImageIcon("img/pago.png"));
        img.setBounds(790, 20, 128, 128);
        
         JLabel imgy = new JLabel(new ImageIcon("img/ayuda.png"));
        imgy.setBounds(930, 710, 32, 32);

        JLabel tituLabel = new JLabel("Pago de Mensualidad");
        tituLabel.setBounds(250, 20, 500, 50);
        tituLabel.setForeground(Color.WHITE);
        tituLabel.setFont(Titulos);

        JLabel nombreLabel = new JLabel("Nombre:");
        nombreLabel.setBounds(80, 170, 100, 50);
        nombreLabel.setForeground(Color.WHITE);
        nombreLabel.setFont(font1);

        JLabel apellidoLabel = new JLabel("Apellido:");
        apellidoLabel.setBounds(400, 170, 100, 50);
        apellidoLabel.setForeground(Color.WHITE);
        apellidoLabel.setFont(font1);

        JLabel resumenLabel = new JLabel("Resumen de Pago:");
        resumenLabel.setBounds(655, 200, 150, 50);
        resumenLabel.setForeground(Color.WHITE);
        resumenLabel.setFont(font1);

        JLabel correoLabel = new JLabel("Correo Electrónico:");
        correoLabel.setBounds(80, 240, 155, 50);
        correoLabel.setForeground(Color.WHITE);
        correoLabel.setFont(font1);

        JLabel fechaLabel = new JLabel("Fecha de Pago:");
        fechaLabel.setBounds(400, 240, 155, 50);
        fechaLabel.setForeground(Color.WHITE);
        fechaLabel.setFont(font1);

        JLabel tarjetaLabel = new JLabel("Número de Tarjeta:");
        tarjetaLabel.setBounds(80, 310, 155, 50);
        tarjetaLabel.setForeground(Color.WHITE);
        tarjetaLabel.setFont(font1);

        JLabel direccionLabel = new JLabel("Dirección:");
        direccionLabel.setBounds(400, 310, 100, 50);
        direccionLabel.setForeground(Color.WHITE);
        direccionLabel.setFont(font1);

        JLabel codigoLabel = new JLabel("Código de Verificación:");
        codigoLabel.setBounds(80, 385, 185, 50);
        codigoLabel.setForeground(Color.WHITE);
        codigoLabel.setFont(font1);

        JLabel telefonoLabel = new JLabel("Teléfono:");
        telefonoLabel.setBounds(400, 385, 100, 50);
        telefonoLabel.setForeground(Color.WHITE);
        telefonoLabel.setFont(font1);

        this.add(img);
        this.add(imgy);
        this.add(tituLabel);
        this.add(nombreLabel);
        this.add(apellidoLabel);
        this.add(correoLabel);
        this.add(fechaLabel);
        this.add(tarjetaLabel);
        this.add(direccionLabel);
        this.add(codigoLabel);
        this.add(telefonoLabel);
        this.add(resumenLabel);
    }

    private void tabla() {
        String[] columnas = {"Nombre de Estudiante", "Apellidos", "Placa de Vehiculo", "Licencia",
            "Vehiculo", "Fecha", "Tarjeta", "Nombre Secretario"};

        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        JTable tabla = new JTable(modeloTabla);

        Object[] fila1 = {"Douglas Jose", "Hurtado", "MO-637JPD", "123-456-7890", "Motocicleta", "24/05/2023", "1234567890", "Andres Catalan"};
        modeloTabla.addRow(fila1);

        Object[] fila2 = {};
        modeloTabla.addRow(fila2);

        Object[] fila3 = {"María Fernanda", "Gómez", "AA-123XYZ", "987-654-3210", "Automóvil", "12/06/2023", "0987654321", "Luisa Rodríguez"};
        modeloTabla.addRow(fila3);

        Object[] fila4 = {};
        modeloTabla.addRow(fila4);

        Object[] fila5 = {"Pedro Antonio", "López", "BB-456ABC", "555-555-5555", "Motocicleta", "18/07/2023", "5555555555", "Juan Martínez"};
        modeloTabla.addRow(fila5);

        Object[] fila6 = {};
        modeloTabla.addRow(fila6);

        Object[] fila7 = {"Ana Gabriela", "Torres", "CC-789DEF", "111-222-3333", "Automóvil", "03/09/2023", "1112223333", "María Sánchez"};
        modeloTabla.addRow(fila7);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds(660, 250, 300, 230);
        

        this.add(scrollPane);
    }

    private void agregarCajasTexto() {
        nombre = new JTextField(20);
        nombre.setBounds(80, 205, 200, 30);
        nombre.setFont(font2);

        apellido = new JTextField(20);
        apellido.setBounds(400, 205, 200, 30);
        apellido.setFont(font2);

        correo = new JTextField(20);
        correo.setBounds(80, 275, 200, 30);
        correo.setFont(font2);

        fecha = new JTextField(20);
        fecha.setBounds(400, 275, 200, 30);
        fecha.setFont(font2);

        tarjeta = new JTextField(20);
        tarjeta.setBounds(80, 345, 200, 30);
        tarjeta.setFont(font2);

        direccion = new JTextField(20);
        direccion.setBounds(400, 345, 200, 30);
        direccion.setFont(font2);

        codigo = new JTextField(20);
        codigo.setBounds(80, 420, 200, 30);
        codigo.setFont(font2);

        telefono = new JTextField(20);
        telefono.setBounds(400, 420, 200, 30);
        telefono.setFont(font2);

        this.add(nombre);
        this.add(apellido);
        this.add(correo);
        this.add(fecha);
        this.add(tarjeta);
        this.add(direccion);
        this.add(codigo);
        this.add(telefono);
    }

    private void agregarBotones() {
        JButton agregarButton = new JButton("<html><center>Pagar<br></html>");
        agregarButton.setBounds(400, 600, 140, 45);
        agregarButton.setFont(font1);
        agregarButton.setForeground(Color.BLACK);
        agregarButton.setForeground(Color.BLACK);
        agregarButton.setBackground(Color.decode("#FFC93C"));
        LineBorder border1 = new LineBorder(Color.BLACK, 2);
        agregarButton.setBorder(border1);

        ActionListener agregarListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        };

        agregarButton.addActionListener(agregarListener);
        this.add(agregarButton);
    }

   
}
