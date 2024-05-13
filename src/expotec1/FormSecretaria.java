package expotec1;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class FormSecretaria extends JFrame {

   private JTextField user;
    private JPasswordField password;
    private Font font1 = new Font("Arial", Font.BOLD, 40);
    private Font font2 = new Font("Arial", Font.BOLD, 14);
    private Font flabel = new Font("Arial", Font.BOLD, 16);

    public FormSecretaria() {
        //Caracteristicas de la JFRAME  
        this.setLayout(null);
        this.setTitle("Secretaria");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#5BC0F8"));

        this.Inicializar();
    }

    public void Inicializar() {
        this.Etiquetas();
        this.Botones();
    }

    public void Etiquetas() {

        JLabel img = new JLabel(new ImageIcon("img/secre.png"));
        img.setBounds(200, 260, 256, 256);

        JLabel imgy = new JLabel(new ImageIcon("img/ayuda.png"));
        imgy.setBounds(930, 710, 32, 32);

        JLabel userLabel = new JLabel("Bienvenida/o Secretaria/o");
        userLabel.setBounds(260, 50, 1000, 100);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(font1);

        this.add(img);
        this.add(imgy);
        this.add(userLabel);

    }

    public void Botones() {
        JButton reposiciondetarjeta = new JButton("<html><center>Ingreso De Usuarios<br></center                                                                                                       ></html>");
        reposiciondetarjeta.setBounds(636, 280, 200, 45);
        reposiciondetarjeta.setFont(flabel);
        reposiciondetarjeta.setForeground(Color.BLACK);
        reposiciondetarjeta.setBackground(Color.decode("#FFC93C"));
        LineBorder border = new LineBorder(Color.BLACK, 2);
        reposiciondetarjeta.setBorder(border);
        this.add(reposiciondetarjeta);

        JButton Datos = new JButton("<html><center>Solicitudes<br></center                                                                                                       ></html>");
        Datos.setBounds(636, 410, 200, 45);
        Datos.setFont(flabel);
        Datos.setForeground(Color.BLACK);
        Datos.setBackground(Color.decode("#FFC93C"));
        LineBorder border1 = new LineBorder(Color.BLACK, 2);
        Datos.setBorder(border1);
        this.add(Datos);

        JButton pagodemensualidad = new JButton("<html><center>Pago de mensualidad<br></center                                                                                                       ></html>");
        pagodemensualidad.setBounds(636, 345, 200, 45);
        pagodemensualidad.setFont(flabel);
        pagodemensualidad.setForeground(Color.BLACK);
        pagodemensualidad.setBackground(Color.decode("#FFC93C"));
        LineBorder border2 = new LineBorder(Color.BLACK, 2);
        pagodemensualidad.setBorder(border2);
        this.add(pagodemensualidad);
    }   
}
