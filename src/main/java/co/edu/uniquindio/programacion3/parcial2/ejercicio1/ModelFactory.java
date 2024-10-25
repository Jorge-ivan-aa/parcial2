package co.edu.uniquindio.programacion3.parcial2.ejercicio1;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Departamento;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.ModelRepository;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Proyecto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.DepartamentoPersistente;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.EmpleadoPersistente;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.ModelRepositoryRespaldo;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.ProyectoPersistente;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;
import lombok.Getter;

import java.io.IOException;
import java.util.List;

@Getter
public class ModelFactory {
    private static ModelFactory instance;
    private ModelRepository modelRepository;

    // PERSISTENCIA
    private final EmpleadoPersistente empleadoPersistente;
    private final DepartamentoPersistente departamentoPersistente;
    private final ProyectoPersistente proyectoPersistente;

    private ModelFactory() {
        modelRepository = cargaRespaldo();
        empleadoPersistente = new EmpleadoPersistente();
        departamentoPersistente = new DepartamentoPersistente();
        proyectoPersistente = new ProyectoPersistente();

        if (modelRepository == null) {
            modelRepository = new ModelRepository();
            loadData();
        }
    }


    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public void loadData() {
        List<Empleado> empleados = null;
        List<Proyecto> proyectos = null;
        List<Departamento> departamentos = null;

        try {
            empleados = empleadoPersistente.leer();
            departamentos = departamentoPersistente.leer();
            proyectos = proyectoPersistente.leer();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
//
//        try {
//            proyectos = proyectoPersistente.leer();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }
//
//        try {
//            departamentos = departamentoPersistente.leer();
//        } catch (IOException e) {
//            System.out.println(e.getMessage());
//        }

        if (empleados != null) {
            for (Empleado usuario : empleados) {
                modelRepository.addEmpleado(usuario);
            }
        }
        if (proyectos != null) {
            for (Proyecto proyecto : proyectos) {
                modelRepository.addProyecto(proyecto);
            }
        }
        if (departamentos != null) {
            for (Departamento departamento : departamentos) {
                modelRepository.addDepartamento(departamento);
            }
        }

        guardarRespaldo();
    }

    public ModelRepository cargaRespaldo() {
        return ModelRepositoryRespaldo.cargarRecursoModelRepositoryXML();
    }

    public void guardarRespaldo() {
        ModelRepositoryRespaldo.guardarRecursoModelRepositoryBinario(modelRepository);
        ModelRepositoryRespaldo.guardarRecursoModelRepositoryXML(modelRepository);
    }
}
