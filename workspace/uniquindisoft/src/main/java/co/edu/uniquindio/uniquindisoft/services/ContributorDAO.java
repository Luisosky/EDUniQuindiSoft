package co.edu.uniquindio.uniquindisoft.services;

import co.edu.uniquindio.uniquindisoft.model.Contributor;

import java.io.IOException;

public class ContributorDAO extends AbstractDAO<Contributor, String> {

    public ContributorDAO() throws IOException {
        super("F:\\IdeaProjects\\persistencia\\contributor.csv");
    }
}
