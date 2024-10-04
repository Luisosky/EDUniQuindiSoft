package co.edu.uniquindio.uniquindisoft.DAO;

import co.edu.uniquindio.uniquindisoft.model.Contributor;

import java.io.IOException;

public class ContributorDAO extends ADao<Contributor, Integer>{
    public ContributorDAO(String rutaArchivo) throws IOException {
        super(rutaArchivo);
    }
}
