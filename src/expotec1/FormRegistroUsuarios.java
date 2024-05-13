package expotec1;

import javax.swing.*;
import java.awt.*;
import javax.swing.border.LineBorder;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import com.fazecast.jSerialComm.*;
import com.fazecast.jSerialComm.SerialPort;
import com.fazecast.jSerialComm.SerialPortDataListener;
import com.fazecast.jSerialComm.SerialPortEvent;
import javax.smartcardio.*;

public class FormRegistroUsuarios extends JFrame {

    private JTextField J_Text_Field;
    private JButton J_Button;
    private JButton actualizar;
    private JButton mostrar;
    private JButton Eliminar;
    private JButton Lector;
    private JTextField nombre;
    private JComboBox jComboBox1;
    private JTextField apellidos;
    private JTextField placa;
    private JTextField licencia;
    private JTextField secre;
    private JTextField telefono;
    private JTextField correo;
    private JTable tablaUsuarios;
    private JTextField tarjeta;
    private JComboBox Jcomo1;
    private String seleccion;
    private DefaultTableModel modeloTabla;
    private SerialPort serialPort;

    private Font Titulos = new Font("Arial", Font.BOLD, 40);
    private Font Font1 = new Font("Arial", Font.BOLD, 14);
    private final Font fech = new Font("Open Sans", Font.CENTER_BASELINE, 10);

    public FormRegistroUsuarios() {
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
        this.Etiquetas();
        this.CajasTexto();
        this.Botones();
        this.ComBo();
        this.tabla();
    }

    public void Etiquetas() {

        JLabel img = new JLabel(new ImageIcon("img/iniciar-sesion.png"));
        img.setBounds(790, 20, 128, 128);

        JLabel ayu = new JLabel(new ImageIcon("img/ayuda.png"));
        ayu.setBounds(930, 710, 32, 32);

        JLabel userLabel = new JLabel("Registro De Usuarios");
        userLabel.setBounds(290, 35, 500, 100);
        userLabel.setForeground(Color.WHITE);
        userLabel.setFont(Titulos);

        JLabel userlabel = new JLabel("Nombres: ");
        userlabel.setBounds(80, 155, 200, 80);
        userlabel.setForeground(Color.BLACK);
        userlabel.setFont(Font1);

        JLabel apellidos = new JLabel("Apellidos: ");
        apellidos.setBounds(80, 203, 200, 80);
        apellidos.setForeground(Color.BLACK);
        apellidos.setFont(Font1);

        JLabel placa = new JLabel("Placa De Vehiculo: ");
        placa.setBounds(80, 255, 200, 80);
        placa.setForeground(Color.BLACK);
        placa.setFont(Font1);

        JLabel lice = new JLabel("Licencia: ");
        lice.setBounds(80, 300, 200, 80);
        lice.setForeground(Color.BLACK);
        lice.setFont(Font1);

        JLabel Vehiculo = new JLabel("Vehiculo: ");
        Vehiculo.setBounds(580, 165, 200, 50);
        Vehiculo.setForeground(Color.BLACK);
        Vehiculo.setFont(Font1);

        JLabel J_Label = new JLabel("Fecha: ");
        J_Label.setBounds(580, 215, 200, 50);
        J_Label.setForeground(Color.BLACK);
        J_Label.setFont(Font1);

        JLabel tarjeta = new JLabel("Tarjeta: ");
        tarjeta.setBounds(580, 259, 200, 50);
        tarjeta.setForeground(Color.BLACK);
        tarjeta.setFont(Font1);

        JLabel NombreSecretario = new JLabel("<html><center><p style=\"text-align: left;\">Telefono:</p></center></html>");
        NombreSecretario.setFont(Font1);
        NombreSecretario.setBounds(580, 316, 100, 30);
        NombreSecretario.setForeground(Color.BLACK);

        JLabel correo = new JLabel("Correo: ");
        correo.setBounds(400, 370, 200, 50);
        correo.setForeground(Color.BLACK);
        correo.setFont(Font1);

        this.add(Vehiculo);
        this.add(img);
        this.add(ayu);
        this.add(userLabel);
        this.add(placa);
        this.add(apellidos);
        this.add(lice);
        this.add(userlabel);
        this.getContentPane().add(J_Label);
        this.add(NombreSecretario);
        this.add(tarjeta);
        this.add(correo);
    }

    public void CajasTexto() {
        nombre = new JTextField(20);
        nombre.setBounds(255, 172, 200, 30);
        nombre.setFont(Font1);

        apellidos = new JTextField(20);
        apellidos.setBounds(255, 220, 200, 30);
        apellidos.setFont(Font1);

        placa = new JTextField(20);
        placa.setBounds(255, 273, 200, 30);
        placa.setFont(Font1);

        licencia = new JTextField(20);
        licencia.setBounds(255, 320, 200, 30);
        licencia.setFont(Font1);

        J_Text_Field = new JTextField(20);
        J_Text_Field.setHorizontalAlignment(SwingConstants.CENTER);
        J_Text_Field.setEnabled(false);
        J_Text_Field.setFont(fech);
        J_Text_Field.setDisabledTextColor(Color.BLACK);
        J_Text_Field.setBounds(690, 220, 80, 30);

        tarjeta = new JTextField(80);
        tarjeta.setBounds(690, 265, 200, 30);
        tarjeta.setFont(Font1);

        secre = new JTextField(20);
        secre.setBounds(690, 316, 200, 30);
        secre.setFont(Font1);

        telefono = new JTextField(20);
        telefono.setBounds(690, 316, 200, 30);
        telefono.setFont(Font1);

        correo = new JTextField(20);
        correo.setBounds(490, 372, 200, 30);
        correo.setFont(Font1);//400, 370, 200, 50

        this.add(nombre);
        this.add(telefono);
        this.add(correo);
        this.add(apellidos);
        this.add(placa);
        this.add(licencia);
        this.add(tarjeta);
        this.getContentPane().add(J_Text_Field);
    }

    public void ComBo() {
        Jcomo1 = new javax.swing.JComboBox<>();
        Jcomo1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[]{"Seleccione Su Opción", "Carro", "Moto"}));
        Jcomo1.setBounds(690, 172, 200, 30);
        Jcomo1.setFont(Font1);
        ActionListener evento1 = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                seleccion = (String) Jcomo1.getSelectedItem();
            }

        };
        Jcomo1.addActionListener(evento1);
        this.add(Jcomo1);
    }

    public void Botones() {
        JButton agregar = new JButton("Registrar");
        agregar.setBounds(610, 480, 130, 40);
        agregar.setFont(Font1);
        agregar.setForeground(Color.BLACK);
        agregar.setBackground(Color.decode("#FFC93C"));
        LineBorder border = new LineBorder(Color.BLACK, 2);
        agregar.setBorder(border);
        String datso = null;
        agregar.getItemListeners();
        System.out.println(datso);
        this.add(agregar);

        JButton actualizar = new JButton("Actualizar");
        actualizar.setBounds(800, 480, 130, 40);
        actualizar.setFont(Font1);
        actualizar.setForeground(Color.BLACK);
        actualizar.setBackground(Color.decode("#FFC93C"));
        LineBorder bordeborder = new LineBorder(Color.BLACK, 2);
        actualizar.setBorder(border);
        this.add(actualizar);

        JButton Eliminar = new JButton("Eliminar");
        Eliminar.setBounds(610, 580, 130, 40);
        Eliminar.setFont(Font1);
        Eliminar.setForeground(Color.BLACK);
        Eliminar.setBackground(Color.decode("#FFC93C"));
        LineBorder bordebordersr = new LineBorder(Color.BLACK, 2);
        Eliminar.setBorder(border);
        this.add(Eliminar);

        JButton Buscar = new JButton("Buscar");
        Buscar.setBounds(800, 580, 130, 40);
        Buscar.setFont(Font1);
        Buscar.setForeground(Color.BLACK);
        Buscar.setBackground(Color.decode("#FFC93C"));
        LineBorder bordebordsersr = new LineBorder(Color.BLACK, 2);
        Buscar.setBorder(bordebordsersr);
        this.add(Buscar);

        JButton mostrar = new JButton("Mostrar");
        mostrar.setBounds(800, 640, 130, 40);
        mostrar.setFont(Font1);
        mostrar.setForeground(Color.BLACK);
        mostrar.setBackground(Color.decode("#FFC93C"));
        LineBorder bordebordssersr = new LineBorder(Color.BLACK, 2);
        mostrar.setBorder(bordebordsersr);
        this.add(mostrar);

        JButton Lector = new JButton("LECTOR");
        Lector.setBounds(800, 550, 130, 40);
        Lector.setFont(Font1);
        Lector.setForeground(Color.BLACK);
        Lector.setBackground(Color.decode("#FFC93C"));
        LineBorder Lectords = new LineBorder(Color.BLACK, 2);
        Lector.setBorder(bordebordsersr);
        this.add(Lector);

        Lector.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tarjeta.setText("Lector conectado. Por favor, agregue su tarjeta.");
                // Código para inicializar el lector RFID
                SerialPort[] ports = SerialPort.getCommPorts();
                if (ports.length > 0) {
                    serialPort = ports[0];
                    serialPort.openPort();
                    // Configurar la velocidad de transmisión, bits de datos, paridad, etc.
                    serialPort.setBaudRate(9600);
                    serialPort.setNumDataBits(8);
                    serialPort.setParity(SerialPort.NO_PARITY);
                    // Agregar el listener para capturar los eventos de lectura de datos
                    serialPort.addDataListener(new SerialPortDataListener() {
                        @Override
                        public int getListeningEvents() {
                            return SerialPort.LISTENING_EVENT_DATA_AVAILABLE;
                        }

                        @Override
                        public void serialEvent(SerialPortEvent event) {
                            if (event.getEventType() != SerialPort.LISTENING_EVENT_DATA_AVAILABLE) {
                                return;
                            }
                            byte[] newData = new byte[serialPort.bytesAvailable()];
                            int numRead = serialPort.readBytes(newData, newData.length);
                            String cardData = new String(newData);
                            // Aquí puedes procesar los datos de la tarjeta leída
                            // y mostrarlos en el JTextArea
                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    tarjeta.setText(cardData);
                                }
                            });
                        }
                    });
                }
            }
        });

        J_Button = new JButton("<html><center>Seleccione La Fecha<br></center></html>");
        J_Button.setFont(Font1);
        J_Button.setBounds(775, 215, 150, 40);
        this.getContentPane().add(J_Button);

        J_Button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                J_Text_Field.setText(new FechaMost(FormRegistroUsuarios.this).Set_Picked_Date());
            }
        });

        actualizar.addActionListener(new ActionListener() {
            //Este método se invoca cuando ocurre un evento de acción, hacer clic en un botón, 
            //y permite definir el código que se ejecutará en respuesta a ese evento.
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                actualizarDatos();
                cargarDatos();

            }
        });

        agregar.addActionListener(new ActionListener() {
            //Este método se invoca cuando ocurre un evento de acción, hacer clic en un botón, 
            //y permite definir el código que se ejecutará en respuesta a ese evento.
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                guardarDatos();
                cargarDatos();

            }
        });

        Eliminar.addActionListener(new ActionListener() {
            //Este método se invoca cuando ocurre un evento de acción, hacer clic en un botón, 
            //y permite definir el código que se ejecutará en respuesta a ese evento.
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                eliminarDatos();
                cargarDatos();

            }
        });

        Buscar.addActionListener(new ActionListener() {
            //Este método se invoca cuando ocurre un evento de acción, hacer clic en un botón, 
            //y permite definir el código que se ejecutará en respuesta a ese evento.
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                buscarDatos();
                cargarDatos();

            }
        });

        mostrar.addActionListener(new ActionListener() {
            //Este método se invoca cuando ocurre un evento de acción, hacer clic en un botón, 
            //y permite definir el código que se ejecutará en respuesta a ese evento.
            public void actionPerformed(ActionEvent e) {
                // Se llama a los Método
                cargarDatos();

            }
        });
    }

    private void tabla() {
        tablaUsuarios = new JTable();
        tablaUsuarios.setBounds(65, 435, 500, 300);
        add(tablaUsuarios);
        // Columnas de la tablas
        modeloTabla = new DefaultTableModel();
        modeloTabla.addColumn("Nombre");
        modeloTabla.addColumn("Apellidos");
        modeloTabla.addColumn("Placa");
        modeloTabla.addColumn("Licencia");
        modeloTabla.addColumn("Fecha");
        modeloTabla.addColumn("Vehiculo");
        modeloTabla.addColumn("Telefono");
        modeloTabla.addColumn("Correo");
        modeloTabla.addColumn("NTarjeta");
        tablaUsuarios.setModel(modeloTabla);

        JScrollPane scrollPane = new JScrollPane(tablaUsuarios);
        scrollPane.setBounds(65, 435, 500, 300);

        this.add(scrollPane);
        this.add(tablaUsuarios);
    }

    class FechaMost {

        int DATE_MONTH = java.util.Calendar.getInstance().get(java.util.Calendar.MONTH);
        int DATE_YEAR = java.util.Calendar.getInstance().get(java.util.Calendar.YEAR);
        ;
        JLabel J_Label;
        String DATE_DAY = "";
        JDialog J_Dialog;
        JButton[] J_Button = new JButton[49];

        public FechaMost(JFrame J_Frame_Parent) {
            J_Dialog = new JDialog(J_Frame_Parent);
            J_Dialog.setModal(true);
            String[] Header = {"Domingo", "Lunes", "Martes", "Miércoles", "Jueves", "Viernes", "Sábado"};
            J_Frame_Parent.setFont(Font1);

            JPanel J_Panel1 = new JPanel(new GridLayout(7, 7));
            J_Panel1.setPreferredSize(new Dimension(430, 246)); // Ajuste de dimensiones

            for (int i = 0; i < J_Button.length; i++) {
                final int selection = i;
                J_Button[i] = new JButton();
                J_Button[i].setFocusPainted(false);
                J_Button[i].setBackground(Color.white);

                if (i > 6) {
                    J_Button[i].addActionListener(new ActionListener() {
                        public void actionPerformed(ActionEvent ae) {
                            DATE_DAY = J_Button[selection].getActionCommand();
                            J_Dialog.dispose();
                        }
                    });
                }

                if (i < 7) {
                    J_Button[i].setText(Header[i]);
                    J_Button[i].setForeground(Color.red);
                }

                J_Panel1.add(J_Button[i]);
            }

            JPanel J_Panel2 = new JPanel(new GridLayout(1, 3));
            JButton Previous_Button = new JButton("<< Anterior");
            Previous_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    DATE_MONTH--;
                    Display_Date();
                }
            });
            J_Panel2.add(Previous_Button);
            J_Label = new JLabel("", JLabel.CENTER);
            J_Panel2.add(J_Label);
            JButton Next_Button = new JButton("Siguiente >>");
            Next_Button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent ae) {
                    DATE_MONTH++;
                    Display_Date();
                }
            });
            J_Panel2.add(Next_Button);

            J_Dialog.add(J_Panel1, BorderLayout.CENTER);
            J_Dialog.add(J_Panel2, BorderLayout.SOUTH);
            J_Dialog.pack();
            J_Dialog.setLocationRelativeTo(J_Frame_Parent);
            Display_Date();
            J_Dialog.setVisible(true);
        }

        public void Display_Date() {
            for (int i = 7; i < J_Button.length; i++) {
                J_Button[i].setText("");
            }
            java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat("MMMM yyyy");
            java.util.Calendar Calendar = java.util.Calendar.getInstance();
            Calendar.set(DATE_YEAR, DATE_MONTH, 1);
            int Day_Of_Week = Calendar.get(java.util.Calendar.DAY_OF_WEEK);
            int Days_In_Month = Calendar.getActualMaximum(java.util.Calendar.DAY_OF_MONTH);
            for (int i = 6 + Day_Of_Week, Day = 1; Day <= Days_In_Month; i++, Day++) {
                J_Button[i].setText("" + Day);
            }
            J_Label.setText(Simple_Date_Format.format(Calendar.getTime()));
            J_Dialog.setTitle("Fecha");
        }

        public String Set_Picked_Date() {
            if (DATE_DAY.equals("")) {
                return DATE_DAY;
            }
            java.text.SimpleDateFormat Simple_Date_Format = new java.text.SimpleDateFormat("yyyy-MM-dd");
            java.util.Calendar Calendar = java.util.Calendar.getInstance();
            Calendar.set(DATE_YEAR, DATE_MONTH, Integer.parseInt(DATE_DAY));
            return Simple_Date_Format.format(Calendar.getTime());
        }
    }

    private void guardarDatos() {
        //declara una variable para JTextFiel
        Conexion conectar = new Conexion();
        String nombres = nombre.getText();
        String apellido = apellidos.getText();
        String plac = placa.getText();
        String licenc = licencia.getText();
        String vehiculo = seleccion;
        String telef = telefono.getText();
        String corre = correo.getText();
        String fecha = J_Text_Field.getText();
        String tarjetat = tarjeta.getText();
        //  Implementa antierrores
        try {
            Connection con = conectar.getConnection();
            // Conectar a la base de datos
            // Consultar la base de datos para Insertar

            String query = "INSERT INTO Registro_Usuarios (Nombre, Apellidos, Placa, Licencia, Fecha, Vehiculo, Telefono, Correo, NTarjeta) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
            //Esta declaración parametrizada permite ejecutar consultas SQL de forma segura, 
            //evitando problemas de seguridad como la inyección de SQL.
            System.out.println(query);
            PreparedStatement stmt = con.prepareStatement(query);

            stmt.setString(1, nombres);// Establecer un valor de cadena en el primer parámetro
            stmt.setString(2, apellido);// Establecer un valor de cadena en el segundo parámetro
            stmt.setString(3, plac);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(4, licenc);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(5, fecha);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(6, vehiculo);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(7, telef);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(8, corre);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(9, tarjetat);// Establecer un valor de cadena en el tercer  parámetro    

            stmt.executeUpdate(); //se utiliza cuando no se espera un conjunto de resultados como respuesta a la instrucción SQL. 
            //Retorna un entero que representa el número de filas afectadas por la instrucción de modificación.

            stmt.close();// Cerrar el PreparedStatement
            con.close();//se utiliza para cerrar la conexión con la base de datos una vez que hayas terminado de utilizarla.
            //Cuadro de dialogo Mensaje mensajes guardados
            JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Datos guardados correctamente");
            //Excepción específica para manejar errores relacionados con la base de datos, 
            //como problemas de conexión, errores de consulta SQL, violaciones de integridad, entre otros.
        } catch (SQLException ex) {
            //se utiliza para imprimir la traza de una excepción en la consola. 
            //La traza muestra el seguimiento de llamadas de métodos que llevaron a la excepción.
            ex.printStackTrace();
            //Cuadro de dialogo Mensaje error
            JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Error al guardar los datos");
        }
    }

    private void actualizarDatos() {
        Conexion conectar = new Conexion();
        String nombres = nombre.getText();
        String apellido = apellidos.getText();
        String plac = placa.getText();
        String licenc = licencia.getText();
        String vehiculo = seleccion;
        String telef = telefono.getText();
        String corre = correo.getText();
        String fecha = J_Text_Field.getText();
        String tarjetat = tarjeta.getText();

        try {
            Connection con = conectar.getConnection();
            // Consultar la base de datos para Actualizar
            String query = "UPDATE Registro_Usuarios SET Nombre = ?, Apellidos = ?, Placa = ?, Licencia = ?, Fecha = ?, Vehiculo = ?, Telefono = ?, Correo = ? WHERE NTarjeta = ?";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, nombres);// Establecer un valor de cadena en el primer parámetro
            stmt.setString(2, apellido);// Establecer un valor de cadena en el segundo parámetro
            stmt.setString(3, plac);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(4, licenc);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(5, fecha);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(6, vehiculo);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(7, telef);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(8, corre);// Establecer un valor de cadena en el tercer  parámetro
            stmt.setString(9, tarjetat);// Establecer un valor de cadena en el tercer  parámetro
            stmt.executeUpdate();

            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Datos actualizados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();

        }
    }

    private void eliminarDatos() {
        String tarjetat = tarjeta.getText();
        Conexion conectar = new Conexion();

        try {
            Connection con = conectar.getConnection();
            // Consultar la base de datos para Eliminar
            String query = "DELETE  FROM Registro_Usuarios WHERE NTarjeta = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, tarjetat);
            stmt.executeUpdate();

            stmt.close();
            con.close();

            JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Datos eliminados correctamente");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Error al eliminar los datos");
        }
    }

    private void buscarDatos() {
        String tarjetat = tarjeta.getText();
        Conexion conectar = new Conexion();

        try {
            Connection con = conectar.getConnection();
            // Consultar la base de datos para Selecionar
            String query = "SELECT * FROM Registro_Usuarios WHERE NTarjeta = ?";
            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setString(1, tarjetat);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String nombres = rs.getString("Nombre");
                String Apellidos = rs.getString("Apellidos");
                String placas = rs.getString("Placa");
                String licen = rs.getString("Licencia");
                String fech = rs.getString("Fecha");
                String telef = rs.getString("Telefono");
                String corre = rs.getString("Correo");
                String tarjet = rs.getString("NTarjeta");

                // devuelve valores en los JTextFiel
                nombre.setText(nombres);
                apellidos.setText(Apellidos);
                placa.setText(placas);
                licencia.setText(licen);
                J_Text_Field.setText(fech);
                telefono.setText(telef);
                correo.setText(corre);
                apellidos.setText(Apellidos);
                tarjeta.setText(tarjet);

                JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Datos encontrados");
            } else {
                // devuelve vacios en los JTextFiel 
                nombre.setText("");
                apellidos.setText("");
                placa.setText("");
                licencia.setText("");
                J_Text_Field.setText("");
                telefono.setText("");
                correo.setText("");
                apellidos.setText("");
                tarjeta.setText("");

                JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Datos no encontrados");
            }

            rs.close();// cerrar el objeto ResultSet
            stmt.close();// Cerrar el PreparedStatement
            con.close();//se utiliza para cerrar la conexión con la base de datos una vez que hayas terminado de utilizarla.
            //Cuadro de dialogo Mensaje mensajes guardados
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(FormRegistroUsuarios.this, "Error al buscar los datos");
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
            String query = "SELECT * FROM Registro_Usuarios";
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
                String nombre = rs.getString("Nombre");
                String apellidos = rs.getString("Apellidos");
                String aplaca = rs.getString("Placa");
                String licencia = rs.getString("Licencia");
                String fecha = rs.getString("Fecha");
                String vehiculo = rs.getString("Vehiculo");
                String telefono = rs.getString("Telefono");
                String correo = rs.getString("Correo");
                String tarjeta = rs.getString("NTarjeta");
                // Se crea un arreglo de objetos que representa una fila de datos de la tabla
                Object[] fila = {nombre, apellidos, aplaca, licencia, fecha, vehiculo, telefono, correo, tarjeta};
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
