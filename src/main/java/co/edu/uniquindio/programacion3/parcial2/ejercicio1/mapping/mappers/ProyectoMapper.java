package co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.mappers;


import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.ProyectoDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Proyecto;

public class ProyectoMapper {
    public static ProyectoDto proyectoToProyectoDto(Proyecto proyecto) {
        return new ProyectoDto(
                proyecto.getIdProyecto(),
                proyecto.getNombreProyecto(),
                proyecto.getIdDepartamentoResponsable()
        );
    }

    public static Proyecto proyectoDtoToProyecto(ProyectoDto proyectoDto) {
        return new Proyecto(
                proyectoDto.idProyecto(),
                proyectoDto.nombreProyecto(),
                proyectoDto.idDepartamentoResponsable()
        );
    }
}