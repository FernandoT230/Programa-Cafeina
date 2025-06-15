package controlador;

import conexion.CConexion;
import modelo.Empleado;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class LoginControlador {
    public Empleado validarEmpleado(String nombre1, String cedula) {
        CConexion conexion = new CConexion();
        Connection con = conexion.estableceConexion();
        try {
            String sql = "SELECT * FROM empleado WHERE emp_nombre1 = ? AND emp_cedula = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, nombre1);
            ps.setString(2, cedula);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Empleado empleado = new Empleado(rs.getString("emp_nombre1"), rs.getString("emp_cedula"));
                rs.close();
                ps.close();
                con.close();
                return empleado;
            }
            rs.close();
            ps.close();
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
