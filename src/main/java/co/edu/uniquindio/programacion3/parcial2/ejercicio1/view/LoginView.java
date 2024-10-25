package co.edu.uniquindio.programacion3.parcial2.ejercicio1.view;

import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.UsuarioController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.login.CredencialesNoCoinciden;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.login.UsuarioNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Sesion;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.enums.TipoUsuario;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.ViewTools;
import io.github.palexdev.materialfx.controls.MFXPasswordField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class LoginView {

    UsuarioController usuarioController = new UsuarioController();

    @FXML
    private TextField txtCedulaUsuario;

    @FXML
    private MFXPasswordField txtClaveUsuario;

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    void cancelarIniciarSesion(ActionEvent event) {

    }

    @FXML
    void iniciarSesion(ActionEvent event) {
        String clave = txtClaveUsuario.getText();
        String cedula = txtCedulaUsuario.getText();

        if (!ViewTools.hayCamposVacios(clave, cedula)) {
            Sesion sesion = new Sesion(cedula);

            try {
                TipoUsuario tipoUsuario = sesion.ingresar(clave);
                usuarioController.getFactory().getModelRepository().setSesion(sesion);
                seleccionarInterfax(tipoUsuario, sesion.getUsuario().getNombre());
                ViewTools.cerrarVentana(txtCedulaUsuario);

            } catch (UsuarioNoExiste | CredencialesNoCoinciden e) {
                ViewTools.mostrarMensaje("¡Lo sentimos!", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            ViewTools.mostrarMensaje("¡Lo sentimos!", null, "Hay campos vacios.", Alert.AlertType.ERROR);
        }

    }

    void seleccionarInterfax(TipoUsuario tipoUsuario, String usuario) {
        if (Objects.requireNonNull(tipoUsuario) == TipoUsuario.ADMINISTRADOR) {
            ViewTools.ventanaEmergente("templates/baseAdmin.fxml", "ICaja - Administrador", "styles/main.css");
        }
    }

    @FXML
    void registrarUsuario(ActionEvent event) {
        ViewTools.ventanaEmergente("templates/registroUsuario.fxml", "ICaja - Registro de usuario", "styles/main.css");
        ViewTools.cerrarVentana(txtCedulaUsuario);
    }

    @FXML
    void initialize() {

    }
}
