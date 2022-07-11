package com.example.consultorio;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;

import java.util.Collection;

public class ControllerLogin {
 static int memoriaScene;
   static int volta;

@FXML
    TextField login;
@FXML
TextField senha;


    @FXML
    protected void login() {
        if (login!=null&&senha!=null){
            System.out.println(login.getText()+senha.getText());
            login.setText("");
            senha.setText("");
        }

      Main.trocaTela(1);
memoriaScene=1;
    }

    @FXML
    protected void sair() {
        Main.trocaTela(2);
        System.out.println("sair");
memoriaScene=2;
    }

    @FXML
    protected void calendar() {
        Main.trocaTela(3);
        System.out.println("calendario");
        memoriaScene=3;

    }
    @FXML
    protected void pacientes() {
        Main.trocaTela(4);
        System.out.println("pacientes");
        memoriaScene=4;

    }
    @FXML
    protected void adcionaPaciente() {

        Main.trocaTela(5);
        System.out.println(memoriaScene);
        volta=memoriaScene;


    }
    @FXML
    protected void volta() {
        System.out.println(volta);

        Main.trocaTela(volta);


    }
    @FXML
    protected void adcionaPacienteDois() {

        Main.trocaTela(6);

    }
    @FXML
    protected void adcionaPacienteTres() {

        Main.trocaTela(7);

    }
    @FXML
    protected void adcionaPacienteQuatro() {

        Main.trocaTela(8);

    }
    @FXML
    protected void adcionaPacienteCadastro() {

        Main.trocaTela(9);

    }
    @FXML
    protected void adcionaPacienteSalvar() {

        Main.trocaTela(10);

    }

    @FXML
    protected void adcionaPacienteExluir() {

        Main.trocaTela(11);

    }
    @FXML
    protected void config() {

        Main.trocaTela(12);

    }

    @FXML
    protected void adcionaProcedimento() {

        Main.trocaTela(13);

    }
    @FXML
    protected void adcionaProcedimentoDois() {

        Main.trocaTela(14);

    }

    @FXML
    protected void abrirAgenda() {

        Main.trocaTela(15);

    }

}