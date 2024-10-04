package co.edu.uniquindio.uniquindisoft.services;

import co.edu.uniquindio.uniquindisoft.model.Cotizante;

import java.io.IOException;

public class CotizanteDAO extends AbstractDAO<Cotizante, String> {
    public CotizanteDAO() throws IOException {
        super("F:\\IdeaProjects\\persistencia\\cotizante.csv");
    }
}
