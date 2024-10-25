package co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.mappers;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.UsuarioDto;


public class UsuarioMapper {

    public static UsuarioDto usuarioToUsuarioDTo(Usuario usuario) {
        return new UsuarioDto(
                usuario.getNombre(),
                usuario.getCedula(),
                usuario.getClave()
        );
    }

    public static Usuario usuarioDtoToUsuario(UsuarioDto usuarioDto) {
        return new Usuario(
                usuarioDto.nombre(),
                usuarioDto.cedula(),
                usuarioDto.clave()
        );
    }
}