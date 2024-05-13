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
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

public class ControlSecretarios extends JPanel {

    private JLabel lblmensaje, lblid, lblusuario, lblcontra, lblimage, lbape;
    private JTextField tfid, tfusuario, tfapelli;
    private ImageIcon img;
    private JButton btnguardar, btnactualizar, btneliminar, btnbuscar;
    private JTable tablaUsuarios;
    private DefaultTableModel modeloTabla;
    private Font Titulos = new Font("Arial", Font.BOLD, 40);
    private Font Font1 = new Font("Arial", Font.BOLD, 20);

    public ControlSecretarios() {
this.setLayout(null);
        this.setSize(1275, 970);
  

        // JLabel "ID"
        lblid = new JLabel("ID_Secretario: ");
        lblid.setBounds(60, 120, 200, 50);
        lblid.setForeground(Color.BLACK);
        lblid.setFont(Font1);
        add(lblid);

        // JLabel "Usuario"
        lblusuario = new JLabel("Nombre:");
        lblusuario.setBounds(420, 120, 200, 50);
        lblusuario.setForeground(Color.BLACK);
        lblusuario.setFont(Font1);
        add(lblusuario);

        // JLabel "Apellido"
        lblcontra = new JLabel("Control de secretarios");
        lblcontra.setBounds(300, 50, 500, 68);
        lblcontra.setForeground(Color.BLACK);
        lblcontra.setFont(Titulos);
        add(lblcontra);

        lbape = new JLabel("Apellidos: ");
        lbape.setBounds(750, 120, 200, 50);
        lbape.setForeground(Color.BLACK);
        lbape.setFont(Font1);
        add(lbape);

        // Campo de texto para el id
        tfid = new JTextField();
        tfid.setBounds(45, 180, 160, 25);
        add(tfid);

        // Campo de texto para el nombre
        tfusuario = new JTextField();
        tfusuario.setBounds(375, 180, 160, 25);
        add(tfusuario);

        // Campo de texto para el Apellidos
        tfapelli = new JTextField();
        tfapelli.setBounds(715, 180, 160, 25);
        add(tfapelli);

        // Botón "Guardar"
        btnguardar = new JButton("Guardar");
        btnguardar.setBounds(40, 270, 130, 25);
        btnguardar.setBackground(Color.decode("#FFC93C"));
        LineBorder border2 = new LineBorder(Color.BLACK, 2);
        add(btnguardar);
        // Botón "Actualizar"
        btnactualizar = new JButton("Actualizar");
        btnactualizar.setBounds(290, 270, 130, 25);
        btnactualizar.setBackground(Color.decode("#FFC93C"));
        LineBorder bordser2 = new LineBorder(Color.BLACK, 2);
        add(btnactualizar);
        // Botón "Eliminar"
        btneliminar = new JButton("Eliminar");
        btneliminar.setBounds(510, 270, 130, 25);
        btneliminar.setBackground(Color.decode("#FFC93C"));
        LineBorder borderg2 = new LineBorder(Color.BLACK, 2);
        add(btneliminar);
        // Botón "Buscar"
        btnbuscar = new JButton("Buscar");
        btnbuscar.setBounds(750, 270, 130, 25);
        btnbuscar.setBackground(Color.decode("#FFC93C"));
        LineBorder bordgser2 = new LineBorder(Color.BLACK, 2);
        add(btnbuscar);

        // Contenedor "JTable"
        tablaUsuarios = new JTable();
        tablaUsuarios.setBounds(30, 340, 925, 400);
        tablaUsuarios.setEnabled(false);// inhabilitar tabla
        add(tablaUsuarios);
        // Columnas de la tablas
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("ID");
        modeloTabla.addColumn("Usuario");
        modeloTabla.addColumn("Apellido");
        tablaUsuarios.setModel(modeloTabla);

        //Eventos cuando se interactua con el boton Guardar
        btnguardar.addActionListener(new ActionListener() {
            //Este método se invoca cuando ocurre un evento de acción, hacer clic en un botón, 
            //y permite definir el código que se ejecutará en respuesta a ese evento.
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                guardarDatos();
                cargarDatos();

            }
        });
        //Eventos cuando se interactua con el boton Actualizar
        btnactualizar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                actualizarDatos();
                cargarDatos();
            }

        });
        //Eventos cuando se interactua con el boton Eliminar
        btneliminar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                eliminarDatos();
                cargarDatos();

            }
        });
        //Eventos cuando se interactua con el boton Buscar
        btnbuscar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                buscarDatos();

            }
        });
        //Llama al Método
        cargarDatos();
    }

    //**************************MÉTODOS*************************************************************
    //Llama al Método Guardar
    private void guardarDatos() {
        //declara una variable para JTextFiel
        String id = tfid.getText();
        Conexion conectar = new Conexion();
        String usuario = tfusuario.getText();
        String Apellido = tfapelli.getText();
        //  Implementa antierrores
        try {
            Connection con = conectar.getConnection();
            // Conectar a la base de datos
            // Consultar la base de datos para Insertar
            String query = "INSERT INTO Secretarios (Id_Secretario, Nombre, Apellido) VALUES (?, ?, ?)";
            //Esta declaración parametrizada permite ejecutar consultas SQL de forma segura, 
            //evitando problemas de seguridad como la inyección de SQL.
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, id);// Establecer un valor de cadena en el primer parámetro
            stmt.setString(2, usuario);// Establecer un valor de cadena en el segundo parámetro
            stmt.setString(3, Apellido);// Establecer un valor de cadena en el tercer  parámetro

            stmt.executeUpdate(); //se utiliza cuando no se espera un conjunto de resultados como respuesta a la instrucción SQL. 
            //Retorna un entero que representa el número de filas afectadas por la instrucción de modificación.

            stmt.close();// Cerrar el PreparedStatement
            con.close();//se utiliza para cerrar la conexión con la base de datos una vez que hayas terminado de utilizarla.
            //Cuadro de dialogo Mensaje mensajes guardados
            JOptionPane.showMessageDialog(ControlSecretarios.this, "Datos guardados correctamente");
            //Excepción específica para manejar errores relacionados con la base de datos, 
            //como problemas de conexión, errores de consulta SQL, violaciones de integridad, entre otros.
        } catch (SQLException ex) {
            //se utiliza para imprimir la traza de una excepción en la consola. 
            //La traza muestra el seguimiento de llamadas de métodos que llevaron a la excepción.
            ex.printStackTrace();
            //Cuadro de dialogo Mensaje error
            JOptionPane.showMessageDialog(ControlSecretarios.this, "Error al guardar los datos");
        }
    }

    private void actualizarDatos() {
        String id = tfid.getText();
        Conexion conectar = new Conexion();
        String usuario = tfusuario.getText();
        String Apellido = tfapelli.getText();

        try {
            Connection con = conectar.getConnection();
            // Consultar la base de datos para Actualizar
            String query = "UPDATE Secretarios SET Nombre = ?, Apellido = ? WHERE Id_Secretario = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, usuario);
            stmt.setString(2, Apellido);
            stmt.setString(3, id);
            stmt.executeUpdate();

            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(ControlSecretarios.this, "Datos actualizados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    private void eliminarDatos() {
        String id = tfid.getText();
        Conexion conectar = new Conexion();

        try {
            Connection con = conectar.getConnection();
            // Consultar la base de datos para Eliminar
            String query = "DELETE  FROM Secretarios WHERE Id_Secretario = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            stmt.executeUpdate();

            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(ControlSecretarios.this, "Datos eliminados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(ControlSecretarios.this, "Error al eliminar los datos");
        }
    }

    private void buscarDatos() {
        String id = tfid.getText();
        Conexion conectar = new Conexion();

        try {
            Connection con = conectar.getConnection();
            // Consultar la base de datos para Selecionar
            String query = "SELECT * FROM Secretarios WHERE Id_Secretario = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, id);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String usuario = rs.getString("Nombre");
                String Apellido = rs.getString("Apellido");
                // devuelve valores en los JTextFiel
                tfusuario.setText(usuario);
                tfapelli.setText(Apellido);

                JOptionPane.showMessageDialog(ControlSecretarios.this, "Datos encontrados");
            } else {
                // devuelve vacios en los JTextFiel 
                tfusuario.setText("");
                tfapelli.setText("");

                JOptionPane.showMessageDialog(ControlSecretarios.this, "Datos no encontrados");
            }

            rs.close();// cerrar el objeto ResultSet
            stmt.close();// Cerrar el PreparedStatement
            con.close();//se utiliza para cerrar la conexión con la base de datos una vez que hayas terminado de utilizarla.
            //Cuadro de dialogo Mensaje mensajes guardados
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(ControlSecretarios.this, "Error al buscar los datos");
        }
    }

    private void cargarDatos() {
        //se utiliza para establecer el número de filas del modelo de una tabla en cero, 
        //lo que efectivamente elimina todas las filas existentes en la tabla.
        modeloTabla.setRowCount(0);
        Conexion conectar = new Conexion();

        try {
            Connection con = conectar.getConnection();
            // Consultar la base de datos para mostrar todo
            String query = "SELECT * FROM Usuarios";
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(query);

            // Obtener los nombres de columna del ResultSet
            // Se obtiene el objeto ResultSetMetaData a partir del ResultSet
            ResultSetMetaData rsmd = rs.getMetaData();
            // Se obtiene el número de columnas en el conjunto de resultados
            int columnCount = rsmd.getColumnCount();
            // Se crea un arreglo para almacenar los nombres de las columnas
            String[] columnNames = new String[columnCount];

            for (int i = 1; i <= columnCount; i++) {
                columnNames[i - 1] = rsmd.getColumnName(i);// Se obtiene el nombre de la columna actual y se guarda en el arreglo
            }
            // Establecer los nombres de columna en el modelo de tabla
            modeloTabla.setColumnIdentifiers(columnNames);

            // Se mueve al siguiente registro en el ResultSet y ejecuta el bucle mientras haya registros
            while (rs.next()) {
                // Se obtienen los valores de las columnas "id", "usuario" y "pass" del registro actual
                String id = rs.getString("Id_Secretario");
                String usuario = rs.getString("Nombre");
                String Apellido = rs.getString("Apellido");
                // Se crea un arreglo de objetos que representa una fila de datos de la tabla
                Object[] fila = {id, usuario, Apellido};
                // Se agrega la fila al modelo de la tabla
                modeloTabla.addRow(fila);

            }

            rs.close();
            stmt.close();
            con.close();
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

}
