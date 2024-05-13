package expotec1;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.LineBorder;

public class FormAdmin extends JFrame {

    private JTextField bienvenido;
    private JTextField controlsecretario;
    private Font font1 = new Font("Arial", Font.BOLD, 30);
    private Font font2 = new Font("Arial", Font.BOLD, 30);
    private Font flabel = new Font("Arial", Font.BOLD, 16);

    public FormAdmin() {
        //Caracteristicas de la JFRAME  
        this.setLayout(null);
        this.setTitle("interfaz / administrador");
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

        JLabel img = new JLabel(new ImageIcon("img/ADMIN.png"));
        img.setBounds(200, 250, 250, 256);

        JLabel imgy = new JLabel(new ImageIcon("img/ayuda.png"));
        imgy.setBounds(930, 710, 32, 32);

        JLabel userLabel = new JLabel("<html><div style='transform: rotate(90deg); " +
                           "white-space: nowrap;'>Hora 1: 16:50<br>Hora 2: 17:30</div></html>");
        userLabel.setBounds(260, 50, 1000, 100);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(font1);

        this.add(img);
        this.add(imgy);
        this.add(userLabel);
    }

    public void Botones() {

        JButton controldesecretarios = new JButton("<html><center>Control de Secretarios<br></center                                                                                                       ></html>");
        controldesecretarios.setBounds(636, 400, 200, 45);
        controldesecretarios.setFont(flabel);
        controldesecretarios.setForeground(Color.BLACK);
        controldesecretarios.setBackground(Color.decode("#FFC93C"));
        LineBorder border1 = new LineBorder(Color.BLACK, 2);
        controldesecretarios.setBorder(border1);

        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ControlSecretarios ventanaSecundaria = new ControlSecretarios();
                ventanaSecundaria.setVisible(true);
                dispose();
            }
        };
        controldesecretarios.addActionListener(evento1);

        JButton controldedatos = new JButton("<html><center>Control de Datos<br></center                                                                                                       ></html>");
        controldedatos.setBounds(636, 350, 200, 45);
        controldedatos.setFont(flabel);
        controldedatos.setForeground(Color.BLACK);
        controldedatos.setBackground(Color.decode("#FFC93C"));
        LineBorder border2 = new LineBorder(Color.BLACK, 2);
        controldedatos.setBorder(border2);

        ActionListener evento2 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatosUsuario dtu = new DatosUsuario();
                dtu.setVisible(true);
                dispose();
            }
        };
        controldedatos.addActionListener(evento2);

        JButton Factura = new JButton("<html><center>Factura<br></center                                                                                                       ></html>");
        Factura.setBounds(636, 300, 200, 45);
        Factura.setFont(flabel);
        Factura.setForeground(Color.BLACK);
        Factura.setBackground(Color.decode("#FFC93C"));
        LineBorder border3 = new LineBorder(Color.BLACK, 2);
        Factura.setBorder(border3);

        JButton Estadisticas = new JButton("<html><center>Estadisticas<br></center                                                                                                       ></html>");
        Estadisticas.setBounds(636, 250, 200, 45);
        Estadisticas.setFont(flabel);
        Estadisticas.setForeground(Color.BLACK);
        Estadisticas.setBackground(Color.decode("#FFC93C"));
        LineBorder border4 = new LineBorder(Color.BLACK, 2);
        Estadisticas.setBorder(border4);

        ActionListener evento4 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Graficas gf = new Graficas();
                gf.setVisible(true);
            }
        };
        Estadisticas.addActionListener(evento4);

        JButton AgregarUsuario = new JButton("<html><center>Agregar Usuario<br></center                                                                                                       ></html>");
        AgregarUsuario.setBounds(430, 250, 200, 45);
        AgregarUsuario.setFont(flabel);
        AgregarUsuario.setForeground(Color.BLACK);
        AgregarUsuario.setBackground(Color.decode("#FFC93C"));
        LineBorder border5 = new LineBorder(Color.BLACK, 2);
        AgregarUsuario.setBorder(border5);

        JButton Solicitudes = new JButton("<html><center>Solicitudes<br></center                                                                                                       ></html>");
        Solicitudes.setBounds(430, 300, 200, 45);
        Solicitudes.setFont(flabel);
        Solicitudes.setForeground(Color.BLACK);
        Solicitudes.setBackground(Color.decode("#FFC93C"));
        LineBorder border6 = new LineBorder(Color.BLACK, 2);
        Solicitudes.setBorder(border6);

        JButton Registrodemensualidad = new JButton("<html><center>Registro de Mensualidad<br></center                                                                                                       ></html>");
        Registrodemensualidad.setBounds(430, 350, 200, 45);
        Registrodemensualidad.setFont(flabel);
        Registrodemensualidad.setForeground(Color.BLACK);
        Registrodemensualidad.setBackground(Color.decode("#FFC93C"));
        LineBorder border7 = new LineBorder(Color.BLACK, 2);
        Registrodemensualidad.setBorder(border7);

        JButton RegistrodeUsuarios = new JButton("<html><center>Registro de Usuarios<br></center                                                                                                       ></html>");
        RegistrodeUsuarios.setBounds(430, 399, 200, 45);
        RegistrodeUsuarios.setFont(flabel);
        RegistrodeUsuarios.setForeground(Color.BLACK);
        RegistrodeUsuarios.setBackground(Color.decode("#FFC93C"));
        LineBorder border8 = new LineBorder(Color.BLACK, 2);
        RegistrodeUsuarios.setBorder(border8);

        this.add(controldesecretarios);
        this.add(controldedatos);
        this.add(Factura);
        this.add(Estadisticas);
        this.add(AgregarUsuario);
        this.add(Solicitudes);
        this.add(Registrodemensualidad);
        this.add(RegistrodeUsuarios);
    }
}
