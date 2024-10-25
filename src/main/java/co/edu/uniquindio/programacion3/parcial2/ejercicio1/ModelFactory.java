package co.edu.uniquindio.programacion3.parcial2.ejercicio1;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.ModelRepository;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Usuario;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.UsuarioPersistente;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia.ModelRepositoryRespaldo;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;
import lombok.Getter;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

@Getter
public class ModelFactory {
    private static ModelFactory instance;
    private ModelRepository modelRepository;

    // PERSISTENCIA
    private final UsuarioPersistente usuarioPersistente;

    private ModelFactory() {


        modelRepository = cargaRespaldo();
        usuarioPersistente = new UsuarioPersistente();

        if (modelRepository == null) {
            modelRepository = new ModelRepository();
            loadData();
        }
        loadConfig();
    }


    public static ModelFactory getInstance() {
        if (instance == null) {
            instance = new ModelFactory();
        }
        return instance;
    }

    public void loadConfig() {
        String usuario = Persistencia.cargarConfiguracion("usuario");
        String contrasena = Persistencia.cargarConfiguracion("contrasena");

        Usuario admin = new Usuario("admin", usuario, contrasena);
        admin.setAdministrador();

        modelRepository.addUsuario(admin);
    }

    public void loadData() {
        List<Usuario> usuarios = null;
        try {
            usuarios = usuarioPersistente.leer();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        if (usuarios != null) {
            for (Usuario usuario : usuarios) {
                modelRepository.addUsuario(usuario);
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
