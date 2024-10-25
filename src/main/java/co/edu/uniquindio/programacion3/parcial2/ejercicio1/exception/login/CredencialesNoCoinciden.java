package co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.login;

public class CredencialesNoCoinciden extends RuntimeException {
    public CredencialesNoCoinciden(String message) {
        super(message);
    }
}