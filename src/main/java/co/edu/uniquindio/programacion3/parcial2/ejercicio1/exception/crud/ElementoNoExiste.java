package co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud;

public class ElementoNoExiste extends RuntimeException {
    public ElementoNoExiste(String message) {
        super(message);
    }
}
