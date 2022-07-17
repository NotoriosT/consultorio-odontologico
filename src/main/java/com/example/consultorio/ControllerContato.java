package com.example.consultorio;

import com.example.consultorio.util.MaskTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerContato implements Initializable {
    @FXML
    MaskTextField celular;
    @FXML
    MaskTextField email;

    @FXML
    Button proximo;

    protected void setContado(){
        PacientesConfigs.paciente.setCelular(celular.getText());
        PacientesConfigs.paciente.setEmail(email.getText());
    }

    @FXML
    protected void adcionaPacienteTres()  {
        setContado();

        Main.trocaTela(7);

    }


    @FXML
    protected void volta() {
        Main.trocaTela(5);

    }

    @FXML
    protected  void teclad(){

        proximo.setDisable(true);
    }
    @FXML
    protected void habilita(){

        boolean habilitaButton=(celular.getText().isEmpty()| email.getText().isEmpty() );
        proximo.setDisable(habilitaButton);

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        celular.setMask("NNNNNNNNNNN");
        email.setMask("M!@M!.P!");
    }
}
