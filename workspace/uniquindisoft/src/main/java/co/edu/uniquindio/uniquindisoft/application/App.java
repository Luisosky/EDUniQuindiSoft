package co.edu.uniquindio.uniquindisoft.application;

import co.edu.uniquindio.uniquindisoft.model.Cotizante;
import co.edu.uniquindio.uniquindisoft.services.ContributorDAO;
import co.edu.uniquindio.uniquindisoft.services.CotizanteDAO;

import java.io.IOException;

public class App {
    public static void main(String[] args) throws IOException {
       ContributorDAO contributorDAO = new ContributorDAO();
       contributorDAO.obtenerTodos().forEach(System.out::println);

        CotizanteDAO cotizanteDAO = new CotizanteDAO();
        cotizanteDAO.obtenerTodos().forEach(System.out::println);
    }
}
