package com.example.consultorio;

import com.example.configs.dao.DAO;
import com.example.configs.entidades.Agenda;
import com.example.configs.entidades.Paciente;
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

public class ControllerLogin implements Initializable {
   public static int memoriaScene;
    public static int volta;


@FXML
Label data=new Label();
    Agenda agendas;
    @FXML
    private TableView<Agenda> tableView = new TableView<>();
    @FXML
    private TableView<Paciente> tablePacientes = new TableView<>();

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
    private TableColumn<Paciente, String> colunaNomePaciente = new TableColumn<>();
    @FXML
    private TableColumn<Paciente, String> colunaCpf = new TableColumn<>();
@FXML
Label horario;

@FXML
TextField buscaPaciente;

@FXML
Button buscaNomeOuCpf;

@FXML
Button alterar;

@FXML
Button salva;

@FXML
Button libera;
@FXML
RadioButton cpf;

@FXML
Label pacienteNome;
@FXML
Label pacienteCpf;
@FXML
Label pacienteProcedimento;
    private Paciente pacienteCrud;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setColunaAgenda(data, colunaNome, colunaApelido, colunaDoenca, colunaData, colunaProcedimento);
        colunaNomePaciente.setCellValueFactory(new PropertyValueFactory<>("nome"));
        colunaCpf.setCellValueFactory(new PropertyValueFactory<>("cpf"));
        prencherTabela();


    }

    static void setColunaAgenda(Label data, TableColumn<Agenda, String> colunaNome, TableColumn<Agenda, String> colunaApelido, TableColumn<Agenda, String> colunaDoenca, TableColumn<Agenda, String> colunaData, TableColumn<Agenda, String> colunaProcedimento) {
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


        colunaData.setCellValueFactory(new PropertyValueFactory<>("data"));
        colunaProcedimento.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getProcedimento() != null) {
                return new SimpleStringProperty(agenda.getValue().getProcedimento().getNome());
            }
            return null;
        });
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
        dao.fechar();
    }

    static void prencherTablePaciente(TableView<Paciente> tableView, String nome) {

        DAO<Object> dao = new DAO<>(Object.class);
if (!nome.isEmpty()){
      List<Paciente>pacientes=dao.buscaNomePaciente(nome);
        ObservableList<Paciente> paciente = FXCollections.observableArrayList(pacientes);
        tableView.setItems(paciente);}
dao.fechar();
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



@FXML
    protected void obterAgendanda(){
try {


    int i = tableView.getSelectionModel().getSelectedIndex();
    agendas = tableView.getItems().get(i);
    horario.setText(agendas.getData().split("T")[1]);
    tablePacientes.getItems().clear();
    buscaPaciente.setText("");
    alterar.setDisable(false);

    tablePacientes.setDisable(true);
    cpf.setDisable(true);
    buscaPaciente.setDisable(true);
    buscaNomeOuCpf.setDisable(true);
    salva.setDisable(true);
    libera.setDisable(true);

 if (agendas.getPaciente()!=null ) {
     pacienteNome.setText(agendas.getPaciente().getNome());
     pacienteCpf.setText(agendas.getPaciente().getCpf());


 }
}catch (Exception e){
    System.out.println("vaziu");
}



}



    @FXML
    private void prencherTabelaPaciente() {

        tablePacientes.getItems().clear();
        prencherTablePaciente(tablePacientes, buscaPaciente.getText());
    }

@FXML
private void altera(){
    tablePacientes.setDisable(false);
    cpf.setDisable(false);
    buscaPaciente.setDisable(false);
    buscaNomeOuCpf.setDisable(false);
    salva.setDisable(false);
    libera.setDisable(false);
}
@FXML
    private void setSalva(){
        DAO<Object> dao=new DAO<>(Object.class);
        Agenda agenda=dao.buscaAgenda(Math.toIntExact(agendas.getId()));
        Paciente paciente=dao.buscaId(Math.toIntExact(pacienteCrud.getId()));
        agenda.setPaciente(paciente);
        dao.persistirCompleto(agenda);
        dao.fechar();
        prencherTabela();



    }
    @FXML
    protected void obterPaciente(){
        try {


            int i = tablePacientes.getSelectionModel().getSelectedIndex();
            pacienteCrud = tablePacientes.getItems().get(i);
        }catch (Exception e){
            System.out.println("pacientes vaziu");
        }
    }

@FXML
private void liberar(){
    DAO<Object> dao=new DAO<>(Object.class);
    Agenda agenda=dao.buscaAgenda(Math.toIntExact(agendas.getId()));
    agenda.setPaciente(null);
    dao.persistirCompleto(agenda);
    dao.fechar();
    prencherTabela();

}
}





