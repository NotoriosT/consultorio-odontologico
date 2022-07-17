package com.example.consultorio;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class ControllerDoencas {

    @FXML
    RadioButton doencaSim;

    @FXML
    RadioButton doencaNao;
    @FXML
    TextField doencas;
    @FXML
    TextArea doencasObservacoes;

    @FXML
    Button proximo;

    protected void setDoencas() {
        PacientesConfigs.paciente.setDoenca(false);
        PacientesConfigs.paciente.setDoencas("*");
        PacientesConfigs.paciente.setDoencasObservacoes("*");
        if (doencaSim.isSelected()) {
            PacientesConfigs.paciente.setDoenca(doencaSim.isSelected());
            PacientesConfigs.paciente.setDoencas(doencas.getText());
            PacientesConfigs.paciente.setDoencasObservacoes(doencasObservacoes.getText());
        }
    }

    @FXML
    protected void adcionaPacienteQuatro() {
        setDoencas();

        Main.trocaTela(8);


    }

    @FXML
    protected void volta() {
        Main.trocaTela(6);

    }
    @FXML
    protected  void teclad(){

        proximo.setDisable(true);
    }
    @FXML
    protected void habilita(){

        boolean habilitaButton=(doencas.getText().isEmpty()| doencasObservacoes.getText().isEmpty()
                |!(doencaSim.isSelected()|doencaNao.isSelected())
        );
        proximo.setDisable(habilitaButton);

    }
    @FXML
    protected  void setDoencaNao(){
        proximo.setDisable(false);
        doencas.setText("N/");
        doencasObservacoes.setText("N/");
        doencas.setDisable(true);
        doencasObservacoes.setDisable(true);
    }
    @FXML
    protected  void setDoencaSim(){

        if (doencaSim.isSelected()){
            doencas.setDisable(false);
            doencasObservacoes.setDisable(false);
            doencas.setText("");
            doencasObservacoes.setText("");
            habilita();
        }
    }
}
