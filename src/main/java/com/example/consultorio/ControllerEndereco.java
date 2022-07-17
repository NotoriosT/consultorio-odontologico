package com.example.consultorio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class ControllerEndereco {
    @FXML
    TextField logradouro;
    @FXML
    TextField numroDaCasa;
    @FXML
    TextField cidade;
    @FXML
    TextField estado;
    @FXML
    TextField bairro;
    @FXML
    TextField cep;
    @FXML
    TextField coplemento;
    @FXML
    Button proximo;



    protected void setEndereco() {

        PacientesConfigs.paciente.setLogradouro(logradouro.getText());
        PacientesConfigs.paciente.setBairro(bairro.getText());
        PacientesConfigs.paciente.setBairro(bairro.getText());
        PacientesConfigs.paciente.setCidade(cidade.getText());
        PacientesConfigs.paciente.setEstado(estado.getText());
        PacientesConfigs.paciente.setNumroDaCasa(numroDaCasa.getText());
        PacientesConfigs.paciente.setCep(cep.getText());
        PacientesConfigs.paciente.setCoplemento(coplemento.getText());
    }
    @FXML
    protected void adcionaPacienteCadastro() {
        setEndereco();
        Main.trocaTela(9);

    }

    @FXML
    protected void volta() {
        Main.trocaTela(7);

    }

    @FXML
    protected  void teclad(){

        proximo.setDisable(true);
    }
    @FXML
    protected void habilita(){

        boolean habilitaButton=(logradouro.getText().isEmpty()| cep.getText().isEmpty()|numroDaCasa.getText().isEmpty()
        |cidade.getText().isEmpty()|estado.getText().isEmpty()|bairro.getText().isEmpty()|coplemento.getText().isEmpty()
        );
        proximo.setDisable(habilitaButton);

    }
}
