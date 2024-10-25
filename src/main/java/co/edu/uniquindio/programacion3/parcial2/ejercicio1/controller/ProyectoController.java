package co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.services.GenericController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoYaExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.ProyectoDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Proyecto;

public class ProyectoController implements GenericController<ProyectoDto, Proyecto> {
    @Override
    public void sincronizarData() {

    }

    @Override
    public Proyecto consultar(String identificador) throws ElementoNoExiste {
        return null;
    }

    @Override
    public void crear(ProyectoDto proyectoDto) throws ElementoYaExiste {

    }

    @Override
    public void actualizar(ProyectoDto proyectoDto) throws ElementoNoExiste {

    }

    @Override
    public void eliminar(String identificador) throws ElementoNoExiste {

    }

    @Override
    public void persistir() {

    }
}
