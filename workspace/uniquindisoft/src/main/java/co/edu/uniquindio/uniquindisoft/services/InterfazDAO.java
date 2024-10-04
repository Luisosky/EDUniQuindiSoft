package co.edu.uniquindio.uniquindisoft.services;

import java.util.List;

public interface InterfazDAO <ClaseEntidad, TipoId> {
    public List<ClaseEntidad> obtenerTodos();
}
