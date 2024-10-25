package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class Proyectos {
    private  String idProyecto;
    private String nombreProyecto;
    private String idDepartamentoResponsable;
    public static final long serialVersionID = 8L;

    public Proyectos(String idProyecto, String nombreProyecto, String idDepartamentoResponsable) {
        this.idProyecto = idProyecto;
        this.nombreProyecto = nombreProyecto;
        this.idDepartamentoResponsable = idDepartamentoResponsable;

    }
}
