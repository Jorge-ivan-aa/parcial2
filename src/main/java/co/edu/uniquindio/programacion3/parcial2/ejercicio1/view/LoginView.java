package co.edu.uniquindio.programacion3.parcial2.ejercicio1.view;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.UsuarioController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.ViewTools;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo.Persistencia;
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
            String usuario = Persistencia.cargarConfiguracion("usuario");
            String contrasena = Persistencia.cargarConfiguracion("contrasena");

            if (usuario.equals(cedula) && contrasena.equals(clave)) {
                seleccionarInterfax();
            } else {
                ViewTools.mostrarMensaje("¡Lo sentimos!", null, "El usuario o contraseña son incorrectos", Alert.AlertType.ERROR);
            }

        } else {
            ViewTools.mostrarMensaje("¡Lo sentimos!", null, "Hay campos vacios.", Alert.AlertType.ERROR);
        }

    }

    void seleccionarInterfax() {
            ViewTools.ventanaEmergente("templates/baseAdmin.fxml", "ICaja - Admin", "styles/main.css");
            ViewTools.cerrarVentana(txtCedulaUsuario);
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
