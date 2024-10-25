package co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.mappers;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.DepartamentoDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Departamento;

public class DepartamentoMapper {
    public static DepartamentoDto departamentoToDepartamentoDto(Departamento departamento) {
        return new DepartamentoDto(
                departamento.getIDDepartamento(),
                departamento.getNombreDepartamento(),
                departamento.getDescripcionDepartamento(),
                departamento.getUbicacion()
        );
    }

    public static Departamento departamentoDtoToDepartamento(DepartamentoDto departamentoDto) {
        return new Departamento(
                departamentoDto.IDDepartamento(),
                departamentoDto.nombreDepartamento(),
                departamentoDto.descripcionDepartamento(),
                departamentoDto.ubicacion()
        );
    }
}