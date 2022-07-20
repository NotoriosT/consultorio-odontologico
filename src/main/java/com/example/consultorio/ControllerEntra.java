package com.example.consultorio;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class ControllerEntra {
    @FXML
    TextField login;
    @FXML
    TextField senha;
    @FXML
    protected void login() {
        if (login != null && senha != null) {
            System.out.println(login.getText() + senha.getText());
            login.setText("");
            senha.setText("");
        }

        Main.trocaTela(1);
       ControllerLogin.memoriaScene = 1;
    }
}
