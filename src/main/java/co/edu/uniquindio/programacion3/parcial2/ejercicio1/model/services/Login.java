package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.login.CredencialesNoCoinciden;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.login.UsuarioNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.enums.TipoUsuario;

public interface Login {
    public TipoUsuario ingresar(String clave) throws UsuarioNoExiste, CredencialesNoCoinciden;
}
