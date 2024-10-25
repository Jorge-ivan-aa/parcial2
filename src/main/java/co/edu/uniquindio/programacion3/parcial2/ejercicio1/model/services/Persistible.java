package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services;

import java.io.IOException;
import java.util.List;

public interface Persistible<T> {
    void guardar(List<T> list) throws IOException;
    List<T> leer() throws IOException;
}