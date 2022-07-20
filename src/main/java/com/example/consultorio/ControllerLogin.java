package com.example.consultorio;

import com.example.configs.dao.DAO;
import com.example.configs.entidades.Agenda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;

import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

import static java.lang.Integer.parseInt;

public class ControllerLogin implements Initializable {
   public static int memoriaScene;
    public static int volta;


@FXML
Label data=new Label();

@FXML
DatePicker datePicker;

@FXML
void  mostra(){
    System.out.println(datePicker.getValue().toString());
}

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
        LocalDate localDate=LocalDate.now();

      data.setText(localDate.toString());
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
        prencherTable(tableView);
    }

    static void prencherTable(TableView<Agenda> tableView) {
        LocalDate localDate=LocalDate.now();


        DAO<Object> dao = new DAO<>(Object.class);

        List<Agenda> agenda = dao.obterData(  localDate.toString());
        ObservableList<Agenda> agendas = FXCollections.observableArrayList(agenda);
        tableView.setItems(agendas);
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
    protected void adcionaProcedimentoDois() {

        Main.trocaTela(14);

    }











}





