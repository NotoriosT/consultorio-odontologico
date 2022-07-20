package com.example.consultorio;

import com.example.configs.dao.DAO;
import com.example.configs.entidades.Agenda;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class ControllerCalendar implements Initializable {
    @FXML
    Label data=new Label();

    @FXML
    DatePicker datePicker;

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
    @FXML
    void  busca(){

if (datePicker.getValue()!=null){
            DAO<Object> dao = new DAO<>(Object.class);
            List<Agenda> agenda = dao.obterData(datePicker.getValue().toString());
            ObservableList<Agenda> agendas = FXCollections.observableArrayList(agenda);
            tableView.setItems(agendas);}
        }



    private void prencherTabela() {
        ControllerLogin.prencherTable(tableView);
    }
    @FXML
  private   void  sair(){
        Main.trocaTela(2);
        System.out.println("sair");

    }

    @FXML
    protected void pacientes() {
        Main.trocaTela(4);
        System.out.println("pacientes");


    }
    @FXML
    protected void home() {

        Main.trocaTela(1);

    }

    @FXML
    protected void config() {

        Main.trocaTela(12);

    }

    @FXML
    protected void abrirAgenda() {

        Main.trocaTela(15);

    }
}
