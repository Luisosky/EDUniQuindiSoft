package co.edu.uniquindio.uniquindisoft.model;

public class Cotizante extends EntidadCSV {
    public Cotizante() {
        super();
    }

    public String getNombre() {
        return getCampos().get("nombre");
    }

    public String getApellido() {
        return getCampos().get("apellido");
    }

    public int getEdad() {
        return Integer.parseInt(getCampos().get("edad"));
    }

    public double getSalario() {
        return Double.parseDouble(getCampos().get("salario"));
    }
}