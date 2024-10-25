package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services.Persistible;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPersistente implements Persistible<Empleado> {


    @Override
    public void guardar(List<Empleado> empleados) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(Empleado empleado:empleados)
        {
            contenido.append(
                    empleado.getId()).append("$$")
                    .append(empleado.getNombre()).append("$$")
                    .append(empleado.getApellido()).append("$$")
                    .append(empleado.getIdDepartamento()).append("\n");
        }
        Persistencia.guardarArchivo("empleado.txt", contenido.toString(), false);
    }

    @Override
    public List<Empleado> leer() throws IOException {
        ArrayList<Empleado> empleados = new ArrayList<>();
        ArrayList<String> contenido = Persistencia.leerArchivo("ruta_empleado");
        String[] linea;
        for (String texto : contenido) {
            linea = texto.split("$$");
            Empleado empleado = new Empleado();
            empleado.setId(linea[0]);
            empleado.setNombre(linea[1]);
            empleado.setApellido(linea[2]);
            empleado.setIdDepartamento(linea[3]);
            empleados.add(empleado);
        }
        return empleados;
    }
}