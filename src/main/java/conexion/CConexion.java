package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

// Clase para gestionar la conexión a la base de datos MySQL
public class CConexion {
    // Objeto de conexión
    Connection conectar;
    // Usuario de la base de datos
    String usuario = "root";
    // Contraseña de la base de datos
    String contrasenia = "";
    // Nombre de la base de datos
    String bd = "cafeina";
    // IP del servidor de base de datos
    String ip = "localhost";
    // Puerto de conexión
    String puerto = "3306";
    // Cadena de conexión JDBC
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;

    // Método para establecer la conexión con la base de datos
    public Connection estableceConexion(){
        try {
            // Carga el driver de MySQL y realiza la conexión
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
        } catch (Exception e){
            // Muestra un mensaje de error si falla la conexión
            JOptionPane.showMessageDialog(null,"Problemas en la conexion"+ e.toString());
        }
        return conectar;
    }
}
