package co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller.services.GenericController;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoNoExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud.ElementoYaExiste;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.ModelFactory;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto.EmpleadoDto;
import co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.mappers.EmpleadoMapper;

import static co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.loggin.Seguimiento.registrarLog;

import co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.Empleado;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import lombok.Getter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Getter
public class EmpleadoController implements GenericController<EmpleadoDto, Empleado> {

    private final ModelFactory factory;
    private final ObservableList<Empleado> listaEmpleadoObservable;

    public EmpleadoController() {
        this.factory = ModelFactory.getInstance();
        this.listaEmpleadoObservable = FXCollections.observableArrayList();
        this.sincronizarData();
    }
@Override
    public void sincronizarData() {
        listaEmpleadoObservable.clear();
        listaEmpleadoObservable.addAll(this.factory.getModelRepository().getListaEmpleados());
        persistir();
        registrarLog(1,"Se sincronizaron los usuarios.");
    }

    @Override
    public void crear(EmpleadoDto empladoDto) throws ElementoYaExiste {
        
        try {
            consultar(empladoDto.id());
            registrarLog(2,"No se puede crear el elemento, el usuario ya existe");
            throw new ElementoYaExiste("No se puede crear el elemento, el usuario ya existe");
            
        } catch (ElementoNoExiste ignored) {
            Empleado nuevoEmpleado = EmpleadoMapper.empladoDtoToEmpleado(empladoDto);
            factory.getModelRepository().addEmpleado(nuevoEmpleado);
            listaEmpleadoObservable.add(nuevoEmpleado);
            sincronizarData();
            registrarLog(1,"Se ha creado el usuario " + empladoDto.nombre());
            
        }
    }

    @Override
    public Empleado consultar(String id) throws ElementoNoExiste {
        registrarLog(1,"Se consultó el usuario");

        ArrayList<Empleado> Empleados = this.factory.getModelRepository().getListaEmpleados();
        for (Empleado usuario : Empleados) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        
        throw new ElementoNoExiste("El usuario no existe.");
    }    

    @Override
    public void eliminar(String id) throws ElementoNoExiste {
        try {
            Empleado eliminable = consultar(id);
            factory.getModelRepository().removeEmpleado(eliminable);
            sincronizarData();
            registrarLog(1,"Se eliminó el usuario de id " + id + ".");

        } catch (ElementoNoExiste e) {
            registrarLog(2,"No se pudo eliminar el elemento, " + e.getMessage());
            throw new ElementoNoExiste("No se pudo eliminar el elemento, " + e.getMessage());
        }
    }

    @Override
    public void actualizar(EmpleadoDto empladoDto) throws ElementoNoExiste {
        try {
            Empleado actualizable = consultar(empladoDto.id());
            actualizable.setNombre(empladoDto.nombre());
            actualizable.setClave(empladoDto.clave());
            sincronizarData();
            registrarLog(1,"Se actualizó el usuario de id " + actualizable.getCedula() + " correctamente.");

        } catch (ElementoNoExiste e) {
            registrarLog(2,"No se pudo actualizar el elemento, " + e.getMessage());
            throw new ElementoNoExiste("No se pudo actualizar el elemento, " + e.getMessage());
        }
    }

    @Override
    public void persistir() {
        List<Empleado> usuarios = factory.getModelRepository().getListaEmpleados();
        try {
            factory.getEmpleadoPersistente().guardar(usuarios);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

}
