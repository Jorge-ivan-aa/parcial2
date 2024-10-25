package co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.mappers;


import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.EmpleadoDto;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;

public class EmpleadoMapper {
    public static EmpleadoDto empleadoToEmpleadoDto(Empleado empleado) {
        return new EmpleadoDto(
                empleado.getId(),
                empleado.getNombre(),
                empleado.getApellido(),
                empleado.getIdDepartamento()
        );
    }

    public static Empleado empleadoDtoToEmpleado(EmpleadoDto empleadoDto) {
        return new Empleado(
                empleadoDto.Id(),
                empleadoDto.Nombre(),
                empleadoDto.Apellido(),
                empleadoDto.IdDepartamento()
        );
    }
}