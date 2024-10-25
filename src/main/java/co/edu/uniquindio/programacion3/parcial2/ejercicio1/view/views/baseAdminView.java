package co.edu.uniquindio.programacion3.parcial2.ejercicio1.view.views;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.EmpleadoController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoYaExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.ViewTools;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.*;

public class baseAdminView {

    EmpleadoController empleadoController = new EmpleadoController();


    @FXML
    private TableView<Empleado> tbEmpleadosAdmin;

    @FXML
    private TableColumn<Empleado, String> tbcCedulaEmpleadoAdmin;


    @FXML
    private TableColumn<Empleado, String> tbcClaveEmpleadoAdmin;

    @FXML
    private TableColumn<Empleado,String> tbcNombreEmpleadoAdmin;

    @FXML
    private TextField txtCedulaAdmin;

    @FXML
    private TextField txtClaveAdmin;

    @FXML
    private TextField txtNombreAdmin;

    @FXML
    void crearEmpleado() {
        String nombre = txtNombreAdmin.getText();
        String cedula = txtCedulaAdmin.getText();
        String clave = txtClaveAdmin.getText();

        if (!ViewTools.hayCamposVacios(nombre, cedula, clave)) {
            EmpleadoDto usuarioDto = new EmpleadoDto(nombre,  cedula, clave);

            try {
                empleadoController.crear(usuarioDto);
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
    void actualizarEmpleado() {
        String nombre = txtNombreAdmin.getText();
        String cedula = txtCedulaAdmin.getText();
        String clave = txtClaveAdmin.getText();

        if (!ViewTools.hayCamposVacios(nombre,  cedula, clave)) {
            EmpleadoDto usuarioDto = new EmpleadoDto(nombre,  cedula, clave);

            try {
                empleadoController.actualizar(usuarioDto);
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
    void eliminarEmpleado() {
        String cedula   = txtCedulaAdmin.getText();

        if (!ViewTools.hayCamposVacios(cedula)) {
            try {
                empleadoController.eliminar(cedula);
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
        tbEmpleadosAdmin.getItems().clear();
        tbEmpleadosAdmin.setItems(empleadoController.getListaEmpleadoObservable());
        listenerSelectionEmpleado();
    }

    private void initDataBinging() {
        tbcNombreEmpleadoAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcCedulaEmpleadoAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCedula()));
        tbcClaveEmpleadoAdmin.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getClave()));
    }

    private void listenerSelectionEmpleado() {
        tbEmpleadosAdmin.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)
                -> this.mostrarInformacion(newSelection));
    }

    private void mostrarInformacion(Empleado seleccionado) {
        if (seleccionado != null) {
            txtNombreAdmin.setText(seleccionado.getNombre());
            txtCedulaAdmin.setText(seleccionado.getCedula());
            txtClaveAdmin.setText(seleccionado.getClave());
        }
    }
}
