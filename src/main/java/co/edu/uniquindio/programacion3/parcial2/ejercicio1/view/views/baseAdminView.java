package co.edu.uniquindio.programacion3.parcial2.ejercicio1.view.views;

import java.net.URL;
import java.util.ResourceBundle;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.EmpleadoController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.*;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.ViewTools;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

public class baseAdminView {
    private final EmpleadoController empleadoController = new EmpleadoController();

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Empleado> tbUsuariosAdmin;

    @FXML
    private TableColumn<Empleado, String> tbcApellidoEmpleado;

    @FXML
    private TableColumn<Empleado, String> tbcIdDepartamentoEmpleado;

    @FXML
    private TableColumn<Empleado, String> tbcIdEmpleado;

    @FXML
    private TableColumn<Empleado, String> tbcNombreUsuarioEmpleado;

    @FXML
    private TextField txtApellidoEmpleado;

    @FXML
    private TextField txtIdDepartamentoEmpleado;

    @FXML
    private TextField txtIdEmpleado;

    @FXML
    private TextField txtNombreEmpleado;

    
    @FXML
    void crearEmpleadoAction() {
       String id = txtIdEmpleado.getText();
        String nombre = txtNombreEmpleado.getText();
        String apellido = txtApellidoEmpleado.getText();
        String idDepartamento = txtIdDepartamentoEmpleado.getText();

        if (!ViewTools.hayCamposVacios(id,  nombre,  apellido, idDepartamento)) {
            EmpleadoDto usuarioDto = new EmpleadoDto(id,  nombre,  apellido, idDepartamento);

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

        ViewTools.limpiarCampos(txtIdEmpleado,
                txtNombreEmpleado,
                txtApellidoEmpleado,
                txtIdDepartamentoEmpleado);
    }

    @FXML
    void actualizarUsuario() {
        String id = txtIdEmpleado.getText();
        String nombre = txtNombreEmpleado.getText();
        String apellido = txtApellidoEmpleado.getText();
        String idDepartamento = txtIdDepartamentoEmpleado.getText();

        if (!ViewTools.hayCamposVacios(id,  nombre,  apellido, idDepartamento)) {
            EmpleadoDto usuarioDto = new EmpleadoDto(id,  nombre,  apellido, idDepartamento);

            try {
                empleadoController.actualizar(usuarioDto);
                String msj = "Se ha actualizado el usuario de cedula" + id + "correctamente";
                ViewTools.mostrarMensaje("Información", null, msj, Alert.AlertType.INFORMATION);

            } catch (ElementoNoExiste e) {
                ViewTools.mostrarMensaje("Error", null, e.getMessage(), Alert.AlertType.ERROR);
            }
        } else {
            ViewTools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);

        }
        ViewTools.limpiarCampos(txtIdEmpleado,
                txtNombreEmpleado,
                txtApellidoEmpleado,
                txtIdDepartamentoEmpleado);
    }

    @FXML
    void eliminarEmpleadoAction() {
        String id   = txtIdEmpleado.getText();

        if (!ViewTools.hayCamposVacios(id)) {
            try {
                empleadoController.eliminar(id);
                String msj = "Se ha eliminado el usuario de cedula" + id + "correctamente";
                ViewTools.mostrarMensaje("Información", null, msj, Alert.AlertType.INFORMATION);
            } catch (ElementoNoExiste e) {
                ViewTools.mostrarMensaje("Error", null, e.getMessage(), Alert.AlertType.ERROR);
            }

        } else {
            ViewTools.mostrarMensaje("Error", null, "Hay campos vacíos", Alert.AlertType.ERROR);
        }

        ViewTools.limpiarCampos(txtIdEmpleado,
                txtNombreEmpleado,
                txtApellidoEmpleado,
                txtIdDepartamentoEmpleado);
    }

    @FXML
    void initialize() {
        initview();
    }

    private void initview() {
        initDataBinging();
        tbUsuariosAdmin.getItems().clear();
        tbUsuariosAdmin.setItems(empleadoController.getListaEmpleadoObservable());
        listenerSelectionEmpleado();
    }

    private void initDataBinging() {
       tbcIdEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getId()));
        tbcNombreUsuarioEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));
        tbcApellidoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getApellido()));
        tbcIdDepartamentoEmpleado.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getIdDepartamento()));
    }

    private void listenerSelectionEmpleado() {
        tbUsuariosAdmin.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection)
                -> this.mostrarInformacion(newSelection));
    }

    private void mostrarInformacion(Empleado seleccionado) {
        if (seleccionado != null) {
            txtIdEmpleado.setText(seleccionado.getId());
            txtNombreEmpleado.setText(seleccionado.getNombre());
            txtApellidoEmpleado.setText(seleccionado.getApellido());
            txtIdDepartamentoEmpleado.setText(seleccionado.getIdDepartamento());
        }
    }
}
