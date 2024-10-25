module co.edu.uniquindio.programacion.parcial {
    requires static lombok;
    requires java.logging;
    requires MaterialFX;
    requires atlantafx.base;

    exports co.edu.uniquindio.programacion3.parcial2 to javafx.graphics;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.mappers;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.mapping.dto;
    opens co.edu.uniquindio.programacion3.parcial2 to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.model;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.enums;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.services;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.login;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.exception.crud;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1.controller to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.view;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1.view to javafx.fxml;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1 to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.view.views;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1.view.views to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.loggin;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.loggin to javafx.fxml;
    exports co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1.utils.respaldo to javafx.fxml;
    opens co.edu.uniquindio.programacion3.parcial2.ejercicio1.model.persistencia to javafx.fxml;
}