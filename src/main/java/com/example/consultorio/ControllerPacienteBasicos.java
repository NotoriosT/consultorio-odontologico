package com.example.consultorio;

import com.example.configs.util.MaskTextField;
import com.example.configs.validadores.CPF;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPacienteBasicos  implements Initializable {


    @FXML
    MaskTextField cpf;
    @FXML
    MaskTextField nome;
    @FXML
    DatePicker dataNascimento;
    @FXML
    RadioButton maculino ;
    @FXML
    RadioButton  feminino;
    @FXML
    MaskTextField rg;

    @FXML
    RadioButton  casado;
    @FXML
    RadioButton  solteiro;
    @FXML
    Button proximo1;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
nome.setMask("L! L! L!");
cpf.setMask("NNNNNNNNNNN");
rg.setMask("NNNNNNN");

    }

    protected void addPacienteButooProx(){

        PacientesConfigs.paciente.setNome(nome.getText());
        PacientesConfigs.paciente.setCpf(cpf.getText());
        PacientesConfigs.paciente.setRG(rg.getText());

        if (maculino.isSelected()) {
            PacientesConfigs.paciente.setGenero("masculino");
        }
        if (feminino.isSelected()) {
            PacientesConfigs.paciente.setGenero("feminino");
        }
        PacientesConfigs.paciente.setDate(dataNascimento.getValue());
        PacientesConfigs.paciente.setEstadoCivil("solteiro");
        if (casado.isSelected()) {
            PacientesConfigs.paciente.setEstadoCivil("casado");
        }
    }
@FXML
    protected void habilita(){
        CPF cpf1=new CPF(cpf.getText());
        System.out.println(cpf1.isCPF());
        boolean habilitaBotaoUm=(nome.getText().isEmpty()| cpf.getText().isEmpty()| rg.getText().isEmpty()| dataNascimento.getValue() == null
                |!(maculino.isSelected()|feminino.isSelected())|!(casado.isSelected()|solteiro.isSelected()) |!cpf1.isCPF() );

        proximo1.setDisable(habilitaBotaoUm);
    }

    @FXML
    protected  void teclad(){

        proximo1.setDisable(true);
    }




    @FXML
    protected void volta() {
        Main.trocaTela(ControllerLogin.volta);
    }
    @FXML
    protected void adcionaPacienteDois() {
addPacienteButooProx();
        Main.trocaTela(6);
    }
}
