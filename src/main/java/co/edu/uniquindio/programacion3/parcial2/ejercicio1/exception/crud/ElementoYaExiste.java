package co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud;

public class ElementoYaExiste extends RuntimeException {
    public ElementoYaExiste(String message) {
        super(message);
    }
}
