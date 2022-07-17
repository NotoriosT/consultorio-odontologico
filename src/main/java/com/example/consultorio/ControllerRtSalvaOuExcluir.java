package com.example.consultorio;

import com.example.consultorio.ControllerLogin;
import com.example.consultorio.Main;
import com.example.consultorio.PacientesConfigs;
import com.example.consultorio.dao.DAO;
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
