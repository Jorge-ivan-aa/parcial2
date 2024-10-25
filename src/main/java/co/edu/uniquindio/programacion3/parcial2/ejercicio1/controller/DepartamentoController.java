package co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.services.GenericController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoYaExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.DepartamentoDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Departamento;

public class DepartamentoController implements GenericController<DepartamentoDto, Departamento> {

    @Override
    public void sincronizarData() {

    }

    @Override
    public void crear(DepartamentoDto departamentoDto) throws ElementoYaExiste {

    }

    @Override
    public Departamento consultar(String identificador) throws ElementoNoExiste {
        return null;
    }

    @Override
    public void actualizar(DepartamentoDto departamentoDto) throws ElementoNoExiste {

    }

    @Override
    public void eliminar(String identificador) throws ElementoNoExiste {

    }

    @Override
    public void persistir() {

    }
}
