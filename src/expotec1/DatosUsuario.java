package expotec1;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import javax.swing.table.DefaultTableModel;

public class DatosUsuario extends JFrame {

    private Font Titulos = new Font("Arial", Font.BOLD, 40);
    private Font Font1 = new Font("Arial", Font.BOLD, 14);
    private final Font fech = new Font("Open Sans", Font.CENTER_BASELINE, 10);

    public DatosUsuario() {
        //Caracteristicas de la JFRAME  
        this.setLayout(null);
        this.setTitle("Registro De Usuarios ");
        this.setSize(1000, 800);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.getContentPane().setBackground(Color.decode("#5BC0F8"));

        this.Inicializar();
    }

    public void Inicializar() {
        this.tabla();
        this.Etiquetas();
    }

    private JTable tabla;

    public void Etiquetas() {
        JLabel imgy = new JLabel(new ImageIcon("img/ayuda.png"));
        imgy.setBounds(930, 710, 32, 32);

        JLabel userLabel = new JLabel("Datos de Usuario");
        userLabel.setBounds(350, 35, 500, 100);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(Titulos);

        this.add(userLabel);
        this.add(imgy);
    }

    private void tabla() {
        String[] columnas = {"Nombre de Estudiante", "Apellidos", "Placa de Vehiculo", "Licencia", "Edad", "Hora de entrada", "Hora de salida", "No. telefónico", "No. tarjeta", "PCS estacionado", "Correo"};

        DefaultTableModel modeloTabla = new DefaultTableModel(columnas, 0);
        tabla = new JTable(modeloTabla);

        Object[] fila1 = {"Andres Estuardo", "Cabrera Catalan", "MPOJ45", "AC156E4", "16", "7:40am", "5:10 pm", "45854156", "45", "andres@gmail.com"};
        modeloTabla.addRow(fila1);

        Object[] fila2 = {"Juan", "Pérez", "XX-123ABC", "123-456-7890", "Automóvil", "10/06/2023", "12:30 pm", "1234567890", "12", "juan@gmail.com"};
        modeloTabla.addRow(fila2);

        Object[] fila3 = {"María Fernanda", "Gómez", "AA-123XYZ", "987-654-3210", "Automóvil", "12/06/2023", "0987654321", "", "", "maria@gmail.com"};
        modeloTabla.addRow(fila3);

        Object[] fila4 = {"Carlos", "Rodríguez", "YY-987PQR", "111-111-1111", "Motocicleta", "15/06/2023", "", "1111111111", "", "carlos@gmail.com"};
        modeloTabla.addRow(fila4);

        Object[] fila5 = {"Pedro Antonio", "López", "BB-456ABC", "555-555-5555", "Motocicleta", "18/07/2023", "5555555555", "", "", "pedro@gmail.com"};
        modeloTabla.addRow(fila5);

        Object[] fila6 = {"Laura", "González", "ZZ-789DEF", "222-222-2222", "Automóvil", "", "", "2222222222", "34", "laura@gmail.com"};
        modeloTabla.addRow(fila6);

        Object[] fila7 = {"Ana Gabriela", "Torres", "CC-789DEF", "111-222-3333", "Automóvil", "03/09/2023", "1112223333", "", "", "ana@gmail.com"};
        modeloTabla.addRow(fila7);

        JScrollPane scrollPane = new JScrollPane(tabla);
        scrollPane.setBounds((1000 - 800) / 2, (800 - 400) / 2, 800, 400);

        this.add(scrollPane);
    }
}
