package modelo;

public class Empleado {
    private String nombre1;
    private String cedula;
    // Puedes agregar más campos según la tabla empleado

    public Empleado(String nombre1, String cedula) {
        this.nombre1 = nombre1;
        this.cedula = cedula;
    }

    public String getNombre1() {
        return nombre1;
    }

    public void setNombre1(String nombre1) {
        this.nombre1 = nombre1;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }
}
