package co.edu.uniquindio.uniquindisoft.services;

import java.io.IOException;
import java.lang.reflect.ParameterizedType;
import java.util.List;

public abstract class AbstractDAO <ClaseEntidad, TipoId> implements InterfazDAO<ClaseEntidad, TipoId> {
    private Class<ClaseEntidad> claseEntidad;
    protected GestorDeEntidad gestorDeEntidad;

    @SuppressWarnings("unchecked")
    public AbstractDAO(String rutaArchivo) throws IOException {
        this.claseEntidad = (Class<ClaseEntidad>) (
                (ParameterizedType) getClass().getGenericSuperclass()
        ).getActualTypeArguments()[0];

        this.gestorDeEntidad = new GestorDeEntidad(rutaArchivo);
    }

    @Override
    public List<ClaseEntidad> obtenerTodos() {
        return this.gestorDeEntidad.obtenerTodos(this.claseEntidad);
    }
}
