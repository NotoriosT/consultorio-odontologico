package com.example.consultorio;

import javafx.fxml.FXML;

public class ControllerConfig {





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


    @FXML void calendar(){
        Main.trocaTela(3);
    }

    @FXML
    protected void adcionaProcedimento() {

        Main.trocaTela(13);

    }

    @FXML
    protected void abrirAgenda() {

        Main.trocaTela(15);

    }
}
