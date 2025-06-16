package controlador;

import conexion.CConexion;
import modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

// Controlador para la lógica de validación de empleados en el login
public class LoginControlador {
    // Metodo para validar si un empleado existe en la base de datos
    public Empleado validarEmpleado(String nombre1, String cedula) {
        CConexion conexion = new CConexion(); // Crea una instancia de la conexión
        Connection con = conexion.estableceConexion(); // Establece la conexión
        try {
            // Consulta SQL para buscar al empleado por nombre y cedula
            String sql = "SELECT * FROM empleado WHERE emp_nombre1 = ? AND emp_cedula = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre1);
            ps.setString(2, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                // Si encuentra el empleado, crea y retorna el objeto Empleado
                Empleado empleado = new Empleado(rs.getString("emp_nombre1"), rs.getString("emp_cedula"));
                rs.close();
                ps.close();
                con.close();
                return empleado;
            }
            // Cierra recursos si no encuentra el empleado
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
          
            e.printStackTrace();
        }
        
        return null;
    }
}
