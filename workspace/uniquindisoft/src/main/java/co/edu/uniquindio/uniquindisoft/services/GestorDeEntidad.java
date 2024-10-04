package co.edu.uniquindio.uniquindisoft.services;

import co.edu.uniquindio.uniquindisoft.utils.ProcesadorCSV;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class GestorDeEntidad {
    private Map<Integer, String> mapeoColumnas;
    private String rutaArchivo;

    public GestorDeEntidad(String rutaArchivo) throws IOException {
        this.rutaArchivo = rutaArchivo;
        construirMapaColumnas();
    }

    public void construirMapaColumnas() throws IOException {
        String[] columnas = ProcesadorCSV.leerPrimeraLineaCsv(this.rutaArchivo);
        for (int i = 0; i < columnas.length; i++) {
            assert this.mapeoColumnas != null;
            this.mapeoColumnas.put(i, columnas[i]);
        }
    }

    public <ClaseEntidad> List<ClaseEntidad>obtenerTodos(Class<ClaseEntidad> claseEntidad) {
        LinkedList<ClaseEntidad> entidades = new LinkedList<>();
        try {
            List<String[]> lineas = ProcesadorCSV.leerTodasLasLineasCsv(this.rutaArchivo);
            for (String[] linea : lineas) {
                ClaseEntidad entidad = (ClaseEntidad) claseEntidad.newInstance();
                for (int i = 0; i < linea.length; i++) {
                    String nombreColumna = this.mapeoColumnas.get(i);
                    entidad.getClass().getDeclaredField(nombreColumna).set(entidad, linea[i]);
                }
                entidades.add(entidad);
            }
        } catch (Exception e) {
            e.printStackTrace();
    }
        return entidades;
    }

    public Map<Integer, String> getMapeoColumnas() {
        return mapeoColumnas;
    }

    public void setMapeoColumnas(Map<Integer, String> mapeoColumnas) {
        this.mapeoColumnas = mapeoColumnas;
    }

    public String getRutaArchivo() {
        return rutaArchivo;
    }

    public void setRutaArchivo(String rutaArchivo) {
        this.rutaArchivo = rutaArchivo;
    }



}
