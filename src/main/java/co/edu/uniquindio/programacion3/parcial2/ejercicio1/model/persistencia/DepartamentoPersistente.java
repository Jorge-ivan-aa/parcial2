package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Departamento;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services.Persistible;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DepartamentoPersistente implements Persistible<Departamento> {


    @Override
    public void guardar(List<Departamento> departamentos) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(Departamento departamento:departamentos)
        {
            contenido.append(
                    departamento.getIDDepartamento()).append("@@")
                    .append(departamento.getNombreDepartamento()).append("@@")
                    .append(departamento.getDescripcionDepartamento()).append("@@")
                    .append(departamento.getUbicacion()).append("\n");
        }
        Persistencia.guardarArchivo("ruta_departamento", contenido.toString(), false);
    }

    @Override
    public List<Departamento> leer() throws IOException {
        ArrayList<Departamento> departamentos = new ArrayList<>();
        ArrayList<String> contenido = Persistencia.leerArchivo("ruta_departamento");
        String[] linea;
        for (String texto : contenido) {
            linea = texto.split("@@");
            Departamento departamento = new Departamento();
            departamento.setIDDepartamento(linea[0]);
            departamento.setNombreDepartamento(linea[1]);
            departamento.setDescripcionDepartamento(linea[2]);
            departamento.setUbicacion(linea[3]);
            departamentos.add(departamento);
        }
        return departamentos;
    }

}