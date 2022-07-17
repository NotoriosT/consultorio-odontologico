package com.example.consultorio;

import com.example.consultorio.Main;
import com.example.consultorio.dao.DAO;
import com.example.consultorio.entidades.Agenda;
import com.example.consultorio.entidades.Paciente;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class ControllerLogin implements Initializable {
    private  static int memoriaScene;
    public static int volta;
    public static int sincronia;
    private static Paciente paciente = new Paciente();
    @FXML
    TextField login;
    @FXML
    TextField senha;







    @FXML
    private TableView<Agenda> tableView = new TableView<>();

    @FXML
    private TableColumn<Agenda, String> colunaNome = new TableColumn<>();
    @FXML
    private TableColumn<Agenda, String> colunaData = new TableColumn<>();

    @FXML
    private TableColumn<Agenda, String> colunaProcedimento = new TableColumn<>();


    @FXML
    private TableColumn<Agenda, String> colunaApelido = new TableColumn<>();
    @FXML
    private TableColumn<Agenda, String> colunaDoenca = new TableColumn<>();


    @FXML
    void testando() {
        prencherTabela();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaNome.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getPaciente() != null) {
                return new SimpleStringProperty(agenda.getValue().getPaciente().getNome());
            }
            return null;
        });
        colunaApelido.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getPaciente() != null) {
                return new SimpleStringProperty(agenda.getValue().getPaciente().getNome());
            }
            return null;
        });
        colunaDoenca.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getPaciente() != null) {
                return new SimpleStringProperty(agenda.getValue().getPaciente().getDoencas());
            }
            return null;
        });
        colunaData.setCellValueFactory(new PropertyValueFactory<Agenda, String>("data"));

        colunaProcedimento.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getProcedimento() != null) {
                return new SimpleStringProperty(agenda.getValue().getProcedimento().getNome());
            }
            return null;
        });

        prencherTabela();


    }

    private void prencherTabela() {
        DAO<Object> dao = new DAO<>(Object.class);

        List<Agenda> agenda = dao.obterTodos();
        ObservableList<Agenda> agendas = FXCollections.observableArrayList(agenda);
        tableView.setItems(agendas);
    }

    @FXML
    protected void login() {
        if (login != null && senha != null) {
            System.out.println(login.getText() + senha.getText());
            login.setText("");
            senha.setText("");
        }

        Main.trocaTela(1);
        memoriaScene = 1;
    }

    @FXML
    protected void sair() {
        Main.trocaTela(2);
        System.out.println("sair");
        memoriaScene = 2;
    }

    @FXML
    protected void calendar() {
        Main.trocaTela(3);
        System.out.println("calendario");
        memoriaScene = 3;

    }

    @FXML
    protected void pacientes() {
        Main.trocaTela(4);
        System.out.println("pacientes");
        memoriaScene = 4;

    }


    @FXML
    protected void config() {

        Main.trocaTela(12);

    }


    @FXML
    protected void adcionaPaciente() {

        Main.trocaTela(5);
        System.out.println(memoriaScene);
        volta = memoriaScene;
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





