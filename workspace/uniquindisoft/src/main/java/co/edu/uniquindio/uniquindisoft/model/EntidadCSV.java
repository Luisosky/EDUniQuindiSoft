package co.edu.uniquindio.uniquindisoft.model;

import java.util.HashMap;
import java.util.Map;

public abstract class EntidadCSV {
    protected Map<String, String> campos= new HashMap<>();

    public Map<String, String> getCampos() {
        return campos;
    }

    public void setCampo(Map<String, String> campos) {
        this.campos = campos;
    }

}
