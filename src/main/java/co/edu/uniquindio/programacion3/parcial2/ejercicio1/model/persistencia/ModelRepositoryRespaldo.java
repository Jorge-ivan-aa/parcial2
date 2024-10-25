package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.ModelRepository;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.loggin.Seguimiento;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Serializado;

public class ModelRepositoryRespaldo {

    private static final String RUTA_RESPALDO_DAT = "src/main/resources/persistencia/respaldo/respaldo.dat";
    private static final String RUTA_RESPALDO_XML = "src/main/resources/persistencia/respaldo/respaldo.xml";


    //------------------------------------SERIALIZACIÓN  y XML


    public static ModelRepository cargarRecursoModelRepositoryBinario() {

        ModelRepository modelRepository = null;

        try {
            modelRepository = (ModelRepository) Serializado.cargarRecursoSerializado(RUTA_RESPALDO_DAT);
            Seguimiento.registrarLog(1, "Se cargó el recurso de respaldo binario correctamente");

        } catch (Exception e) {
            Seguimiento.registrarLog(3, e.getMessage());
        }
        return modelRepository;
    }

    public static void guardarRecursoModelRepositoryBinario(ModelRepository modelRepository) {
        try {
            Serializado.salvarRecursoSerializado(RUTA_RESPALDO_DAT, modelRepository);
            Seguimiento.registrarLog(1, "Se guardó el recurso de respaldo binario correctamente");

        } catch (Exception e) {
            Seguimiento.registrarLog(3, e.getMessage());
        }
    }


    public static ModelRepository cargarRecursoModelRepositoryXML() {

        ModelRepository modelRepository = null;

        try {
            modelRepository = (ModelRepository)Serializado.cargarRecursoSerializadoXML(RUTA_RESPALDO_XML);
            Seguimiento.registrarLog(1, "Se cargó el recurso de respaldo xml correctamente");

        } catch (Exception e) {
            Seguimiento.registrarLog(3, e.getMessage());
        }
        return modelRepository;

    }



    public static void guardarRecursoModelRepositoryXML(ModelRepository modelRepository) {

        try {
            Serializado.salvarRecursoSerializadoXML(RUTA_RESPALDO_XML, modelRepository);
            Seguimiento.registrarLog(1, "Se guardó el recurso de respaldo xml correctamente");

        } catch (Exception e) {
            Seguimiento.registrarLog(3, e.getMessage());

        }
    }
}
