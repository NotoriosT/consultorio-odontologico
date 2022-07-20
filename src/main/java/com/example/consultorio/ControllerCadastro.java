package com.example.consultorio;

import javafx.fxml.FXML;

public class ControllerCadastro {

    @FXML
    protected void adcionaPacienteSalvar() {

        Main.trocaTela(10);
    }
    @FXML
    protected void volta() {
        Main.trocaTela(8);

    }

    @FXML
    protected void adcionaPacienteExluir() {

        Main.trocaTela(11);

    }
}
