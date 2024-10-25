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

    private ArrayList<Empleado> listaEmpleados;

    public ModelRepository() {
        this.listaEmpleados = new ArrayList<>();
    }


    // agregar elementos -------------
    public void addEmpleado(Empleado usuario) {
        this.listaEmpleados.add(usuario);
    }


    // remover elementos -------------
    public void removeEmpleado(int index) {
        this.listaEmpleados.remove(index);
    }
    public void removeEmpleado(Empleado usuario) {
        this.listaEmpleados.remove(usuario);
    }

}