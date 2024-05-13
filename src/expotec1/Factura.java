package expotec1;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

public class Factura extends JFrame {

    private JTextField factura;
    private JTextField fecha;
    private JTextField nombre;
    private JTextField direccion;
    private JTextField nit;
    private JTextField detalles;
    private JTextField precio;
    private JTextField sub;
    private JTextField impuestos;
    private JTextField monto;
    private JTextField total;
    private JTextField Cuenta;
    
    private final Font font1 = new Font("Arial", Font.BOLD, 16);
    private final Font font2 = new Font("Arial", Font.BOLD, 20);

    public Factura() {
        this.setLayout(null);
        this.setTitle("Factura ");
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
    }

    private void agregarEtiquetas() {
        JLabel img = new JLabel(new ImageIcon("img/Dinero.png"));
        img.setBounds(310, 50, 400, 128);

        JLabel in = new JLabel(new ImageIcon("img/interrogatorio.png"));
        in.setBounds(700, 700, 450, 32);

        JLabel tituLabel = new JLabel("Reporte de Factura");
        tituLabel.setBounds(410, 10, 250, 50);
        tituLabel.setForeground(Color.WHITE);
        tituLabel.setFont(font2);

        JLabel noLabel = new JLabel("No.Factura:");
        noLabel.setBounds(200, 170, 100, 50);
        noLabel.setForeground(Color.WHITE);
        noLabel.setFont(font1);

        JLabel fechaLabel = new JLabel("Fecha de Emisión:");
        fechaLabel.setBounds(600, 170, 170, 50);
        fechaLabel.setForeground(Color.WHITE);
        fechaLabel.setFont(font1);

        JLabel nomLabel = new JLabel("Nombre:");
        nomLabel.setBounds(200, 240, 155, 50);
        nomLabel.setForeground(Color.WHITE);
        nomLabel.setFont(font1);

        JLabel direLabel = new JLabel("Dirección del Cliente:");
        direLabel.setBounds(600, 240, 175, 50);
        direLabel.setForeground(Color.WHITE);
        direLabel.setFont(font1);

        JLabel nittaLabel = new JLabel("NIT:");
        nittaLabel.setBounds(200, 310, 155, 50);
        nittaLabel.setForeground(Color.WHITE);
        nittaLabel.setFont(font1);

        JLabel deLabel = new JLabel("Detalles:");
        deLabel.setBounds(600, 310, 100, 50);
        deLabel.setForeground(Color.WHITE);
        deLabel.setFont(font1);

        JLabel preLabel = new JLabel("Precio Unitario:");
        preLabel.setBounds(200, 385, 185, 50);
        preLabel.setForeground(Color.WHITE);
        preLabel.setFont(font1);

        JLabel suLabel = new JLabel("Sub. Total:");
        suLabel.setBounds(600, 385, 100, 50);
        suLabel.setForeground(Color.WHITE);
        suLabel.setFont(font1);

        JLabel imLabel = new JLabel("Impuestos:");
        imLabel.setBounds(200, 460, 185, 50);
        imLabel.setForeground(Color.WHITE);
        imLabel.setFont(font1);

        JLabel monLabel = new JLabel("Monto:");
        monLabel.setBounds(600, 460, 100, 50);
        monLabel.setForeground(Color.WHITE);
        monLabel.setFont(font1);

        JLabel totalLabel = new JLabel("Total a Pagar:");
        totalLabel.setBounds(200, 530, 185, 50);
        totalLabel.setForeground(Color.WHITE);
        totalLabel.setFont(font1);

        JLabel CuentaLabel = new JLabel("Cuenta Bancaria:");
        CuentaLabel.setBounds(600, 530, 150, 50);
        CuentaLabel.setForeground(Color.WHITE);
        CuentaLabel.setFont(font1);

        this.add(img);
        this.add(tituLabel);
        this.add(noLabel);
        this.add(fechaLabel);
        this.add(nomLabel);
        this.add(direLabel);
        this.add(nittaLabel);
        this.add(deLabel);
        this.add(preLabel);
        this.add(suLabel);
        this.add(imLabel);
        this.add(monLabel);
        this.add(totalLabel);
        this.add(CuentaLabel);
        this.add(in);
    }

    private void agregarCajasTexto() {
        factura = new JTextField(20);
        factura.setBounds(200, 205, 200, 30);
        factura.setFont(font2);

        fecha = new JTextField(20);
        fecha.setBounds(600, 205, 200, 30);
        fecha.setFont(font2);

        nombre = new JTextField(20);
        nombre.setBounds(200, 275, 200, 30);
        nombre.setFont(font2);

        direccion = new JTextField(20);
        direccion.setBounds(600, 275, 200, 30);
        direccion.setFont(font2);

        nit = new JTextField(20);
        nit.setBounds(200, 345, 200, 30);
        nit.setFont(font2);

        detalles = new JTextField(20);
        detalles.setBounds(600, 345, 200, 30);
        detalles.setFont(font2);

        precio = new JTextField(20);
        precio.setBounds(200, 420, 200, 30);
        precio.setFont(font2);

        sub = new JTextField(20);
        sub.setBounds(600, 420, 200, 30);
        sub.setFont(font2);

        impuestos = new JTextField(20);
        impuestos.setBounds(200, 495, 200, 30);
        impuestos.setFont(font2);

        monto = new JTextField(20);
        monto.setBounds(600, 495, 200, 30);
        monto.setFont(font2);

        total = new JTextField(20);
        total.setBounds(200, 565, 200, 30);
        total.setFont(font2);

        Cuenta = new JTextField(20);
        Cuenta.setBounds(600, 565, 200, 30);
        Cuenta.setFont(font2);

        this.add(factura);
        this.add(fecha);
        this.add(nombre);
        this.add(direccion);
        this.add(nit);
        this.add(detalles);
        this.add(precio);
        this.add(sub);
        this.add(impuestos);
        this.add(monto);
        this.add(total);
        this.add(Cuenta);
    }

    private void agregarBotones() {
        JButton agregarButton = new JButton("<html><center>Imprimir Factura<br></html>");
        agregarButton.setBounds(430, 650, 140, 45);
        agregarButton.setFont(font1);
        agregarButton.setForeground(Color.BLACK);
        agregarButton.setBackground(Color.decode("#FFC93C"));
        LineBorder border1 = new LineBorder(Color.BLACK, 2);
        agregarButton.setBorder(border1);

        this.add(agregarButton);
    }
}