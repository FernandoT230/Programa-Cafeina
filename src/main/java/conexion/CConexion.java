package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

public class CConexion {
    Connection conectar;
    String usuario = "root";
    String contrasenia = "";
    String bd = "cafeina";
    String ip = "localhost";
    String puerto = "3306";
    String cadena = "jdbc:mysql://"+ip+":"+puerto+"/"+bd;

    public Connection estableceConexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conectar = DriverManager.getConnection(cadena,usuario,contrasenia);
        } catch (Exception e){
            JOptionPane.showMessageDialog(null,"Problemas en la conexion"+ e.toString());
        }
        return conectar;
    }
}
