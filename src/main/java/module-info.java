module com.example.consultorio {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires jakarta.persistence;
requires org.hibernate.orm.core;
requires java.sql;
requires java.xml;
    requires mysql.connector.java;
    requires java.desktop;
    opens com.example.consultorio;
    opens com.example.consultorio.entidades;
    opens com.example.consultorio.dao;


}