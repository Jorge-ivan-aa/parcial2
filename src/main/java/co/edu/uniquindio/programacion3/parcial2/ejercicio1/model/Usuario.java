package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.login.CredencialesNoCoinciden;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.enums.TipoUsuario;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services.Login;

import java.io.Serializable;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.loggin.Seguimiento;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.NoArgsConstructor;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Usuario implements Serializable, Login {
    private String nombre;
    private String cedula;
    private String clave;
    private TipoUsuario tipoUsuario;
    public static final long serialVersionID = 5L;

    public Usuario(String nombre, String cedula, String clave) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.clave = clave;
        this.tipoUsuario = TipoUsuario.NORMAL;
    }

    @Override
    public TipoUsuario ingresar(String clave) throws CredencialesNoCoinciden {
        if (verificarCredenciales(this, clave)) {
            Seguimiento.registrarLog(1, "El usuario " + nombre + " ingresó satisfactoriamente");
        } else {
            throw new CredencialesNoCoinciden("Contraseña incorrecta, intenta nuevamente.");
        }

        return getTipoUsuario();
    }

    public boolean verificarCredenciales(Usuario usuario, String clave) {
        return usuario.getClave().equals(clave);
    }


    public void setAdministrador() {
        this.tipoUsuario = TipoUsuario.ADMINISTRADOR;
    }

    public void setNormal() {
        this.tipoUsuario = TipoUsuario.NORMAL;
    }


}