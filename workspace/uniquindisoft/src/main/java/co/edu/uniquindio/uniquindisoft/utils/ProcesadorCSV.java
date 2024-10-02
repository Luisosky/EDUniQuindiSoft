package co.edu.uniquindio.uniquindisoft.utils;

import co.edu.uniquindio.uniquindisoft.model.EntidadCSV;
import co.edu.uniquindio.uniquindisoft.services.SuperCache;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ProcesadorCSV<T extends EntidadCSV> {
    private SuperCache cache = new SuperCache();

    public LinkedList<T> leerTodasLasFilas(String csv, Class<T> clazz) throws Exception {
        LinkedList<T> cotizantes = new LinkedList<>();
        String[] lineas = csv.split("\n");
        for (String linea : lineas) {
            String[] campos = linea.split(",");
            T cotizante = clazz.getDeclaredConstructor().newInstance();
            Map<String, String> camposMap = addCampos(campos);
            cotizante.setCampo(camposMap);
            cotizantes.add(cotizante);
            cache.addCache(campos[2], camposMap);
        }
        return cotizantes;
    }

    public Map<String, String> addCampos(String[] campos) {
        Map<String, String> camposMap = new HashMap<>();
        camposMap.put("nombre", campos[0]);
        camposMap.put("apellido", campos[1]);
        camposMap.put("cedula", campos[2]);
        camposMap.put("telefono", campos[3]);
        camposMap.put("correo", campos[4]);
        camposMap.put("direccion", campos[5]);
        camposMap.put("fechaNacimiento", campos[6]);
        camposMap.put("genero", campos[7]);
        camposMap.put("embargo", campos[8]);
        return camposMap;
    }

    public void escribirFila(T entidad) {
        Map<String, String> atributos = entidad.getCampos();
        System.out.println(atributos.get("nombre") + "," + atributos.get("apellido") + "," + atributos.get("cedula") + "," + atributos.get("telefono") + "," + atributos.get("correo") + "," + atributos.get("direccion") + "," + atributos.get("fechaNacimiento") + "," + atributos.get("genero") + "," + atributos.get("embargo"));
    }
}
