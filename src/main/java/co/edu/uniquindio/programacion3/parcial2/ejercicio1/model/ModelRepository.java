package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model;

import java.io.Serializable;
import java.util.ArrayList;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ModelRepository implements Serializable {

    private ArrayList<Departamento> listaDepartamentos;
    private ArrayList<Proyecto> listaProyectos;
    private ArrayList<Empleado> listaEmpleados;

    public ModelRepository() {
        this.listaEmpleados = new ArrayList<>();
        this.listaDepartamentos = new ArrayList<>();
        this.listaProyectos = new ArrayList<>();
    }



    // agregar elementos -------------
    public void addEmpleado(Empleado usuario) {
        this.listaEmpleados.add(usuario);
    }

    public void addProyecto(Proyecto proyecto) {
        this.listaProyectos.add(proyecto);
    }

    public void addDepartamento(Departamento departamento) {
        this.listaDepartamentos.add(departamento);
    }


    // remover elementos -------------
    public void removeEmpleado(int index) {
        this.listaEmpleados.remove(index);
    }
    public void removeEmpleado(Empleado usuario) {
        this.listaEmpleados.remove(usuario);
    }

    public void removeProyecto(int index) {
        this.listaProyectos.remove(index);
    }
    public void removeProyecto(Proyecto proyecto) {
        this.listaProyectos.remove(proyecto);
    }

    public void removeDepartamento(int index) {
        this.listaDepartamentos.remove(index);
    }
    public void removeDepartamento(Departamento departamento) {
        this.listaDepartamentos.remove(departamento);
    }

}