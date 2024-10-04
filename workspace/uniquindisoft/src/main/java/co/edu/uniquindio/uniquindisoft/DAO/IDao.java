package co.edu.uniquindio.uniquindisoft.DAO;

import java.util.List;

public interface IDao<ClaseEntidad, TipoId> {

    public List<ClaseEntidad> obtenerTodos();
}