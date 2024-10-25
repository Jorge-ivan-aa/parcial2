package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Asignacion {
    private Empleado empleado;
    private Departamento departamento;
    private Proyecto proyecto;

    public Asignacion(Empleado empleado, Departamento departamento, Proyecto proyecto) {
        this.empleado = empleado;
        this.departamento = departamento;
        this.proyecto = proyecto;
    }
}