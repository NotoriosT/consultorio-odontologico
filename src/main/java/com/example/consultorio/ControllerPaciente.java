package com.example.consultorio;

import javafx.fxml.FXML;

public class ControllerPaciente {

    @FXML
    private   void  sair(){
        Main.trocaTela(2);
        System.out.println("sair");

    }

    @FXML
    protected void pacientes() {
        Main.trocaTela(4);
        System.out.println("pacientes");


    }
    @FXML
    protected void home() {

        Main.trocaTela(1);

    }
    @FXML
    protected void adcionaPaciente() {

        Main.trocaTela(5);
        ControllerLogin.volta = ControllerLogin.memoriaScene;
    }
    @FXML
    void calendar(){
        Main.trocaTela(3);
    }
    @FXML
    protected void config() {

        Main.trocaTela(12);

    }

}
