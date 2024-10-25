package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Proyecto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services.Persistible;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoPersistente implements Persistible<Proyecto> {


    @Override
    public void guardar(List<Proyecto> proyectos) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(Proyecto proyecto:proyectos)
        {
            contenido.append(
                    proyecto.getIdProyecto()).append("@@")
                    .append(proyecto.getNombreProyecto()).append("@@")
                    .append(proyecto.getIdDepartamentoResponsable()).append("\n");
        }
        Persistencia.guardarArchivo("ruta_proyecto", contenido.toString(), false);
    }

    @Override
    public List<Proyecto> leer() throws IOException {
        ArrayList<Proyecto> proyectos = new ArrayList<>();
        ArrayList<String> contenido = Persistencia.leerArchivo("ruta_proyecto");
        String[] linea;
        for (String texto : contenido) {
            linea = texto.split("@@");
            Proyecto proyecto = new Proyecto();
            proyecto.setIdProyecto(linea[0]);
            proyecto.setNombreProyecto(linea[1]);
            proyecto.setIdDepartamentoResponsable(linea[2]);
            proyectos.add(proyecto);
        }
        return proyectos;
    }

}
