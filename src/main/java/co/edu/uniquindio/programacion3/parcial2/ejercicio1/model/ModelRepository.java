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

    private ArrayList<Usuario> listaUsuarios;

    private Sesion sesion;

    public ModelRepository() {
        this.listaUsuarios = new ArrayList<>();
        this.sesion = null;
    }


    // agregar elementos -------------
    public void addUsuario(Usuario usuario) {
        this.listaUsuarios.add(usuario);
    }


    // remover elementos -------------
    public void removeUsuario(int index) {
        this.listaUsuarios.remove(index);
    }
    public void removeUsuario(Usuario usuario) {
        this.listaUsuarios.remove(usuario);
    }

}