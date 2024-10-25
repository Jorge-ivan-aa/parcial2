package co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.services;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoYaExiste;

public interface GenericController<DTO, ELEMENT> {

    void crear(DTO dto) throws ElementoYaExiste;
    ELEMENT consultar(String identificador) throws ElementoNoExiste;
    void eliminar(String identificador) throws ElementoNoExiste;
    void actualizar(DTO dto) throws ElementoNoExiste;

    void sincronizarData();
    void persistir();
}