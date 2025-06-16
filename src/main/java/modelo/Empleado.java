package modelo;

// Clase que representa a un empleado
public class Empleado {
    // Nombre del empleado
    private String nombre1;
    // Cédula del empleado
    private String cedula;
    // Puedes agregar más campos según la tabla empleado

    // Constructor de la clase Empleado
    public Empleado(String nombre1, String cedula) {
        this.nombre1 = nombre1;
        this.cedula = cedula;
    }

    // Devuelve el nombre del empleado
    public String getNombre1() {
        return nombre1;
    }

    // Establece el nombre del empleado
    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    // Devuelve la cédula del empleado
    public String getCedula() {
        return cedula;
    }

    // Establece la cédula del empleado
    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
