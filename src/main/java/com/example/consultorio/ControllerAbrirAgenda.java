package com.example.consultorio;

import com.example.configs.util.MaskTextField;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;

import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ResourceBundle;

public class ControllerAbrirAgenda implements Initializable {
    @FXML
MaskTextField tempoDeConsulta;
    @FXML
MaskTextField inicioDoExpediente;

    @FXML
MaskTextField fimDoExpediente;
    @FXML
MaskTextField inicioDoAlmoco;

    @FXML
MaskTextField fimDoAlmoco;

    @FXML
DatePicker   incioDaAgenda;

    @FXML
DatePicker   fimDaAgenda;

@FXML
Label data;

@FXML
    Button salva;


    @FXML
   private void  volta(){
        tempoDeConsulta.setText("");
        inicioDoExpediente.setText("");
        fimDoExpediente.setText("");
        inicioDoAlmoco.setText("");
        fimDoAlmoco.setText("");

        Main.trocaTela(12);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        LocalDate localDate=LocalDate.now();
tempoDeConsulta.setMask("NN:NN");
inicioDoExpediente.setMask("NN:NN");
fimDoExpediente.setMask("NN:NN");
inicioDoAlmoco.setMask("NN:NN");
fimDoAlmoco.setMask("NN:NN");

        data.setText(localDate.toString());
    }

    @FXML
    private  void verifica(){
        System.out.println(tempoDeConsulta.getText());
        try {
        LocalTime.parse(tempoDeConsulta.getText());
        LocalTime.parse(inicioDoExpediente.getText());
        LocalTime.parse(fimDoExpediente.getText());
        LocalTime.parse(inicioDoAlmoco.getText());
        LocalTime.parse(fimDoAlmoco.getText());
        boolean  habilita=  (!incioDaAgenda.getValue().isBefore(fimDaAgenda.getValue()) );
        salva.setDisable(habilita);
    }catch (Exception e){

    }


    }
    @FXML
    private void desabilita(){
        salva.setDisable(true);
    }
}
