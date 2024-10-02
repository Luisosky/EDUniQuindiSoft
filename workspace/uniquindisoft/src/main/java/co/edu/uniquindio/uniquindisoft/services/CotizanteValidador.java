package co.edu.uniquindio.uniquindisoft.services;


import co.edu.uniquindio.uniquindisoft.model.Contributor;
import co.edu.uniquindio.uniquindisoft.model.Cotizante;
import co.edu.uniquindio.uniquindisoft.utils.ContributorQueue;

import java.util.List;
import java.util.Objects;

public class CotizanteValidador {

    private ContributorQueue contributorQueue = new ContributorQueue();

    public ContributorQueue getContributorQueue() {
        return contributorQueue;
    }

    public List<String> validateAll(Cotizante cotizante) {
        return List.of(
                validarNombre(cotizante.getNombre()),
                validarApellido(cotizante.getApellido()),
                validarEdad(cotizante.getEdad()),
                validarSalario(cotizante.getSalario())
        );
    }

    public String validarNombre(String nombre) {
        if (nombre == null || nombre.isEmpty()) {
            return "El nombre no puede estar vacío";
        }
        return null;
    }

    public String validarApellido(String apellido) {
        if (apellido == null || apellido.isEmpty()) {
            return "El apellido no puede estar vacío";
        }
        return null;
    }

    public String validarEdad(int edad) {
        if (edad < 18) {
            return "El cotizante debe ser mayor de edad";
        }
        return null;
    }

    public String validarSalario(double salario) {
        if (salario < 0) {
            return "El salario no puede ser negativo";
        }
        return null;
    }

    public boolean esValido(Cotizante cotizante) {
        List<String> errors = validateAll(cotizante);
        boolean isValid = errors.stream().allMatch(Objects::isNull);
        if (isValid) {
            Contributor contributor = new Contributor(
                    cotizante.getNombre(),
                    cotizante.getApellido(),
                    cotizante.getEdad(),
                    cotizante.getSalario()
            );
            contributorQueue.addContributor(contributor);
        }
        return isValid;
    }

}

