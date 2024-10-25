package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services.Persistible;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class EmpleadoPersistente implements Persistible<Empleado> {


    @Override
    public void guardar(List<Empleado> usuarios) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(Empleado usuario:usuarios)
        {
            contenido.append(
                    usuario.getId()).append("@@")
                    .append(usuario.getNombre()).append("@@")
                    .append(usuario.getApellido()).append("@@")
                    .append(usuario.getIdDepartamento()).append("\n");
        }
        Persistencia.guardarArchivo("ruta_usuario", contenido.toString(), false);
    }

    @Override
    public List<Empleado> leer() throws IOException {
        ArrayList<Empleado> usuarios = new ArrayList<>();
        ArrayList<String> contenido = Persistencia.leerArchivo("ruta_usuario");
        String[] linea;
        for (String texto : contenido) {
            linea = texto.split("@@");
            Empleado usuario = new Empleado();
            usuario.setId(linea[0]);
            usuario.setNombre(linea[1]);
            usuario.setApellido(linea[2]);
            usuario.setIdDepartamento(linea[3]);
            usuarios.add(usuario);
        }
        return usuarios;
    }
}