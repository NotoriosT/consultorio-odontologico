package com.example.consultorio;

import com.example.configs.util.MaskTextField;
import com.example.configs.util.PersistirAgenda;
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

        try {
   LocalTime consulta= LocalTime.parse(tempoDeConsulta.getText());
   LocalTime inicioExe=      LocalTime.parse(inicioDoExpediente.getText());
   LocalTime fimExe   = LocalTime.parse(fimDoExpediente.getText());
   LocalTime inicioAlmo=     LocalTime.parse(inicioDoAlmoco.getText());
   LocalTime fimAlmo =   LocalTime.parse(fimDoAlmoco.getText());

            System.out.println(  !incioDaAgenda.equals(fimDaAgenda.getValue())&&  incioDaAgenda.equals(fimDaAgenda.getValue()) );
        boolean  habilita=  ((!incioDaAgenda.getValue().isBefore(fimDaAgenda.getValue())&&incioDaAgenda.equals(fimDaAgenda.getValue()))|
                !consulta.isBefore(fimExe)|
                inicioExe.isAfter(fimExe)|
                inicioAlmo.isAfter(fimExe) |
                fimAlmo.isAfter(fimExe)
                | inicioAlmo.isAfter(fimAlmo)


        );
        salva.setDisable(habilita);
    }catch (Exception e){


    }}

    @FXML
    private void desabilita(){
        salva.setDisable(true);
    }

    @FXML
    private  void salvar(){
        System.out.println("asdds");
        PersistirAgenda persistirAgenda=new PersistirAgenda(inicioDoExpediente.getText(),
                tempoDeConsulta.getText(), incioDaAgenda.getValue().toString(), fimDaAgenda.getValue().toString(),
                fimDoExpediente.getText(), inicioDoAlmoco.getText(), fimDoAlmoco.getText()

        );
persistirAgenda.prencher();
    }

}
