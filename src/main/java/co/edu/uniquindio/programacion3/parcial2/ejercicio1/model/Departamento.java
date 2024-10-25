package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Departamento {
    private String IDDepartamento;
    private String nombreDepartamento;
    private String descripcionDepartamento;
    private String ubicacion;
    public static final long serialVersionID = 7L;

    public Departamento(String idDepartamento, String nombreDepartamento, String descripcionDepartamento, String ubicacion) {
        this.IDDepartamento = idDepartamento;
        this.nombreDepartamento = nombreDepartamento;
        this.descripcionDepartamento = descripcionDepartamento;
        this.ubicacion = ubicacion;
    }
}
