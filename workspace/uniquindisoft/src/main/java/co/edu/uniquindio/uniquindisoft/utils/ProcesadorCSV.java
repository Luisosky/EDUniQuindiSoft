package co.edu.uniquindio.uniquindisoft.utils;

import co.edu.uniquindio.uniquindisoft.model.EntidadCSV;
import co.edu.uniquindio.uniquindisoft.services.SuperCache;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class ProcesadorCSV{
    private SuperCache cache = new SuperCache();
    public static final String SEPARADOR_CSV = ";;";

    public static String[] leerPrimeraLineaCsv(String rutaArchivo)
            throws IOException
    {
        File archivo = new File(rutaArchivo);

        try(BufferedReader lector = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))
        ) {
            String primeraLinea = lector.readLine();

            if(primeraLinea != null) {
                return primeraLinea.split(ProcesadorCSV.SEPARADOR_CSV);
            }
        }

        return null;
    }
    public static LinkedList<String[]> leerTodasLasLineasCsv(String rutaArchivo)
            throws IOException {
        return leerTodasLasLineasCsv(rutaArchivo,true);
    }

    public static LinkedList<String[]> leerTodasLasLineasCsv(
            String rutaArchivo, boolean esSaltarPrimera
    ) throws IOException {

        File archivo = new File(rutaArchivo);
        LinkedList<String[]> lineas = new LinkedList<>();

        try(BufferedReader lector = new BufferedReader(
                new InputStreamReader(new FileInputStream(archivo), StandardCharsets.UTF_8))
        ) {
            String linea;
            boolean esPrimeraLinea = esSaltarPrimera;
            while( (linea = lector.readLine()) != null  ) {

                if(esPrimeraLinea) {
                    esPrimeraLinea = false;
                    continue;
                }

                String[] arreglo = linea.split(ProcesadorCSV.SEPARADOR_CSV);
                lineas.add( arreglo );
            }
        }


        return lineas;
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

    public void escribirFila(EntidadCSV entidad) {
        Map<String, String> atributos = entidad.getCampos();
        System.out.println(atributos.get("nombre") + "," + atributos.get("apellido") + "," + atributos.get("cedula") + "," + atributos.get("telefono") + "," + atributos.get("correo") + "," + atributos.get("direccion") + "," + atributos.get("fechaNacimiento") + "," + atributos.get("genero") + "," + atributos.get("embargo"));
    }

    public void procesarCsvYAgregarACache(String rutaArchivo) throws IOException {
        LinkedList<String[]> lineas = leerTodasLasLineasCsv(rutaArchivo);
        for (String[] linea : lineas) {
            Map<String, String> campos = addCampos(linea);
            cache.addCache(campos.get("cedula"), campos);
        }
    }
}
