package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.enums.TipoUsuario;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Empleado {
    private String Id;
    private String Nombre;
    private String Apellido;
    private String IdDepartamento;
    public static final long serialVersionID = 6L;

    public Empleado(String id, String nombre, String apellido, String idDepartamento) {
        this.Id = id;
        this.Nombre = nombre;
        this.Apellido = apellido;
        this.IdDepartamento = idDepartamento;
    }

}
