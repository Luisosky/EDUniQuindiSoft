package co.edu.uniquindio.uniquindisoft.DAO;

import co.edu.uniquindio.uniquindisoft.model.Cotizante;

import java.io.IOException;

public class CotizanteDAO extends ADao<Cotizante, Integer> {
    public CotizanteDAO(String rutaArchivo) throws IOException {
        super(rutaArchivo);
    }
}
