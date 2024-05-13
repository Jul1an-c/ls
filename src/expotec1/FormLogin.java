package expotec1;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class FormLogin extends JFrame {

    private JTextField user;
    private JPasswordField password;
    private JPasswordField vericontra;
    private Font Titulos = new Font("Arial", Font.BOLD, 45);
    private Font Font1 = new Font("Arial", Font.BOLD, 20);

    public FormLogin() {
        //Caracteristicas de la JFRAME  
        this.setLayout(null);
        this.setTitle("Login ");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#5BC0F8"));

        this.Inicializar();
    }

    public void Inicializar() {
        this.Etiquetas();
        this.CajasTexto();
        this.Botones();
    }

    public void Etiquetas() {

        JLabel img = new JLabel(new ImageIcon("img/login.png"));
        img.setBounds(375, 150, 256, 256);

        JLabel ayu = new JLabel(new ImageIcon("img/ayuda.png"));
        ayu.setBounds(930, 710, 32, 32);

        JLabel userLabel = new JLabel("¡Bienvenidos!");
        userLabel.setBounds(350, 50, 367, 68);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(Titulos);

        JLabel userlabel = new JLabel("Usuario: ");
        userlabel.setBounds(300, 450, 200, 50);
        userlabel.setForeground(Color.BLACK);
        userlabel.setFont(Font1);

        JLabel contraseña = new JLabel("Contraseña: ");
        contraseña.setBounds(300, 510, 200, 50);
        contraseña.setForeground(Color.BLACK);
        contraseña.setFont(Font1);



        this.add(img);
        this.add(ayu);
        this.add(userLabel);
        this.add(userlabel);
        this.add(contraseña);

    }

    public void CajasTexto() {
        user = new JTextField(20);
        user.setBounds(450, 455, 200, 30);
        user.setFont(Font1);

        password = new JPasswordField(20);
        password.setBounds(450, 515, 200, 30);
        password.setFont(Font1);


        this.add(user);
        this.add(password);
    }

    public void Botones() {
        JButton iniciar = new JButton("Inicia Sesión");
        iniciar.setBounds(410,  650, 160, 50);
        iniciar.setFont(Font1);
        iniciar.setForeground(Color.BLACK);
        iniciar.setBackground(Color.decode("#FFC93C"));
        LineBorder border = new LineBorder(Color.BLACK, 2);
        iniciar.setBorder(border);

        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Conexion conectar = new Conexion();
                String dato1 = user.getText();
                String dato2 = String.valueOf(password.getPassword());
                String query = "SELECT * FROM Usuarios WHERE Usuario='" + dato1 + "' and Contraseña='" + dato2 + "' ";
                System.out.println(query);

                try {
                    Connection con = conectar.getConnection();
                    Statement stmt = con.createStatement();
                    ResultSet rs = stmt.executeQuery(query);

                    int validar = 0;//Matriz que cuando lo encuentra se almacena
                    while (rs.next()) {
                        validar++;
                    }

                    if (validar > 0) {
                        rs.first();
                        String tipo = rs.getString("TipoUsuario");//compara si son correctos

                        if (tipo.equals("1")) {
                            System.out.println("Bienvenido Administrador");
                            JOptionPane.showMessageDialog(null, "Bienvenido Administrador " + dato1);
                            setVisible(false);
                        } else if (tipo.equals("2")) {
                            System.out.println("Bienvenido Secretario");
                            JOptionPane.showMessageDialog(null, "Bienvenido Secretario " + dato1);
                        } else if (tipo.equals("3")) {
                            System.out.println("Bienvenido Usuario");
                            JOptionPane.showMessageDialog(null, "Bienvenido Usuario " + dato1);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario no existe en la BD, Intentalo De Nuevo");
                    }

                } catch (SQLException ex) {
                    Logger.getLogger(FormLogin.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        };
        iniciar.addActionListener(evento1);

        this.add(iniciar);
    };

}
