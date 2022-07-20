package com.example.consultorio;

import com.example.configs.dao.DAO;
import javafx.fxml.FXML;

public class ControllerRtSalvaOuExcluir {

    @FXML
    protected void realmenteSalvar() {

        Main.trocaTela(ControllerLogin.volta);
        System.out.println(PacientesConfigs.paciente.getNome());
        DAO<Object> dao = new DAO<>();
        dao.persistirCompleto(PacientesConfigs.paciente);
    }

    @FXML
    protected void voltaNAo() {
        Main.trocaTela(9);

    }
}
