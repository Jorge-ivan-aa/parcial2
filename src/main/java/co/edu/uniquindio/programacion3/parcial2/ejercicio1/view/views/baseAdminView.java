package co.edu.uniquindio.programacion3.parcial2.ejercicio1.view.views;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.UsuarioController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoYaExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.UsuarioDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Usuario;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.ViewTools;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class baseAdminView {

    UsuarioController usuarioController = new UsuarioController();


    @FXML
    private TableView<Usuario> tbUsuariosAdmin;

    @FXML
    private TableColumn<Usuario, String> tbcCedulaUsuarioAdmin;


    @FXML
    private TableColumn<Usuario, String> tbcClaveUsuarioAdmin;

    @FXML
    private TableColumn<Usuario,String> tbcNombreUsuarioAdmin;

    @FXML
    private TextField txtCedulaAdmin;

    @FXML
    private TextField txtClaveAdmin;

    @FXML
    private TextField txtNombreAdmin;

    @FXML
    void crearUsuario() {
        String nombre = txtNombreAdmin.getText();
        String cedula = txtCedulaAdmin.getText();
        String clave = txtClaveAdmin.getText();

        if (!ViewTools.hayCamposVacios(nombre, cedula, clave)) {
            UsuarioDto usuarioDto = new UsuarioDto(nombre,  cedula, clave);

            try {
                usuarioController.crear(usuarioDto);
                String msj = "Se ha creado el usuario " + nombre + "correctamente";
                ViewTools.mostrarMensaje("Información: ", null, msj, Alert.AlertType.INFORMATION);
            } catch (ElementoYaExiste e) {
                ViewTools.mostrarMensaje("Error", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            ViewTools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);

        }

        ViewTools.limpiarCampos(txtCedulaAdmin,
                txtNombreAdmin,
                txtClaveAdmin);
    }

    @FXML
    void actualizarUsuario() {
        String nombre = txtNombreAdmin.getText();
        String cedula = txtCedulaAdmin.getText();
        String clave = txtClaveAdmin.getText();

        if (!ViewTools.hayCamposVacios(nombre,  cedula, clave)) {
            UsuarioDto usuarioDto = new UsuarioDto(nombre,  cedula, clave);

            try {
                usuarioController.actualizar(usuarioDto);
                String msj = "Se ha actualizado el usuario de cedula" + cedula + "correctamente";
                ViewTools.mostrarMensaje("Información", null, msj, Alert.AlertType.INFORMATION);

            } catch (ElementoNoExiste e) {
                ViewTools.mostrarMensaje("Error", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            ViewTools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);

        }
        ViewTools.limpiarCampos(txtCedulaAdmin,
                txtNombreAdmin,
                txtClaveAdmin);
    }

    @FXML
    void eliminarUsuario() {
        String cedula   = txtCedulaAdmin.getText();

        if (!ViewTools.hayCamposVacios(cedula)) {
            try {
                usuarioController.eliminar(cedula);
                String msj = "Se ha eliminado el usuario de cedula" + cedula + "correctamente";
                ViewTools.mostrarMensaje("Información", null, msj, Alert.AlertType.INFORMATION);
            } catch (ElementoNoExiste e) {
                ViewTools.mostrarMensaje("Error", null, e.getMessage(), Alert.AlertType.ERROR);
            }

        } else {
            ViewTools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);
        }

        ViewTools.limpiarCampos(txtCedulaAdmin,
                txtNombreAdmin,
                txtClaveAdmin);
    }

    @FXML
    void initialize() {
        initview();
    }

    private void initview() {
        initDataBinging();
        tbUsuariosAdmin.getItems().clear();
        tbUsuariosAdmin.setItems(usuarioController.getListaUsuarioObservable());
        listenerSelectionUsuario();
    }

    private void initDataBinging() {
        tbcNombreUsuarioAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCedulaUsuarioAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcClaveUsuarioAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClave()));
    }

    private void listenerSelectionUsuario() {
        tbUsuariosAdmin.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)
                -> this.mostrarInformacion(newSelection));
    }

    private void mostrarInformacion(Usuario seleccionado) {
        if (seleccionado != null) {
            txtNombreAdmin.setText(seleccionado.getNombre());
            txtCedulaAdmin.setText(seleccionado.getCedula());
            txtClaveAdmin.setText(seleccionado.getClave());
        }
    }
}
