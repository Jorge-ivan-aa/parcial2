package co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Usuario;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.enums.TipoUsuario;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services.Persistible;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UsuarioPersistente implements Persistible<Usuario> {


    @Override
    public void guardar(List<Usuario> usuarios) throws IOException {
        StringBuilder contenido = new StringBuilder();
        for(Usuario usuario:usuarios)
        {
            contenido.append(
                    usuario.getNombre()).append("@@")
                    .append(usuario.getCedula()).append("@@")
                    .append(usuario.getClave()).append("@@")
                    .append(usuario.getTipoUsuario()).append("\n");
        }
        Persistencia.guardarArchivo("ruta_usuario", contenido.toString(), false);
    }

    @Override
    public List<Usuario> leer() throws IOException {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<String> contenido = Persistencia.leerArchivo("ruta_usuario");
        String[] linea;
        for (String texto : contenido) {
            linea = texto.split("@@");
            Usuario usuario = new Usuario();
            usuario.setNombre(linea[0]);
            usuario.setCedula(linea[1]);
            usuario.setClave(linea[2]);
            usuario.setTipoUsuario(TipoUsuario.valueOf(linea[3]));
            usuarios.add(usuario);
        }
        return usuarios;
    }
}
