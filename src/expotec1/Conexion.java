package expotec1;

import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class Conexion {

    private static String user = "root";
    private static String password = "compu123#";
    private static String url = "jdbc:mysql://localhost:3306/park23";

    public Connection getConnection() {
        Connection conectar = null;
        try {
            conectar = (Connection) DriverManager.getConnection(url, user, password);
            System.out.println("Conexion Establecida");
        } catch (SQLException e) {
            System.out.println("Error en la conexion");
        }
        return conectar;
    }

    Statement createStatement() {
        throw new UnsupportedOperationException("Not supported yet."); 
    }
}
