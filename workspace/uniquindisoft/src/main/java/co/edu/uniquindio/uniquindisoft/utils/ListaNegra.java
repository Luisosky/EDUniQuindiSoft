package co.edu.uniquindio.uniquindisoft.utils;

import co.edu.uniquindio.uniquindisoft.model.Contributor;

public class ListaNegra {
    private LinkedListCustom<Contributor> listaNegra = new LinkedListCustom<>();

    public void addContributor(Contributor contributor) {
        listaNegra.add(contributor);
    }

    public LinkedListCustom<Contributor> getListaNegra() {
        return listaNegra;
    }

}