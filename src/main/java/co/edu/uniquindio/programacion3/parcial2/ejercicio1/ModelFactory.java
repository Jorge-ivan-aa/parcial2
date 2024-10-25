package co.edu.uniquindio.programacion3.parcial2.ejercicio1;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.ModelRepository;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.EmpleadoPersistente;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.ModelRepositoryRespaldo;
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

    private ModelFactory() {
        modelRepository = cargaRespaldo();
        empleadoPersistente = new EmpleadoPersistente();

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
        try {
            empleados = empleadoPersistente.leer();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (empleados != null) {
            for (Empleado usuario : empleados) {
                modelRepository.addEmpleado(usuario);
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
