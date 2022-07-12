package com.example.consultorio;

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

public class ControllerLogin implements Initializable {
 static int memoriaScene;
   static int volta;
    @FXML
    TextField login;
    @FXML
    TextField senha;

    @FXML
    private TextField cpf;
    @FXML
    private TextField nome;
    @FXML
    private RadioButton  maculino;
    @FXML
    private RadioButton  feminino;
    @FXML
    private TextField  rg;
    @FXML
    private TextField apelido;
    @FXML
    private RadioButton  casado;
    @FXML
    private RadioButton  solteiro;
    @FXML
    private TextField  celular;
    @FXML
    private TextField  email;
    @FXML
    private RadioButton doencaSim;

    @FXML
    private RadioButton doencaNao;
    @FXML
    private TextField  doencas;
    @FXML
    private TextArea doencasObservacoes;
    @FXML
    private  TextField  logradouro;
    @FXML
    private TextField  numroDaCasa;
    @FXML
    private TextField  cidade;
    @FXML
    private TextField  estado;
    @FXML
    private TextField  bairro;
    @FXML
    private TextField  cep;
    @FXML
    private TextField  coplemento;

    @FXML
   private TableView<Agenda> tableView= new TableView<>();

   @FXML
   private TableColumn<Agenda, String> colunaNome =new TableColumn<>();
    @FXML
    private TableColumn<Agenda, String> colunaData =new TableColumn<>();

    @FXML
    private TableColumn<Agenda, String> colunaProcedimento =new TableColumn<>();


    @FXML
    private TableColumn<Agenda, String> colunaApelido =new TableColumn<>();
    @FXML
    private TableColumn<Agenda, String> colunaDoenca =new TableColumn<>();




    @FXML
void testando(){
    prencherTabela();
}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        colunaNome.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getPaciente()!=null){
            return new SimpleStringProperty(agenda.getValue().getPaciente().getNome());}
            return null;
        });
        colunaApelido.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getPaciente()!=null){
                return new SimpleStringProperty(agenda.getValue().getPaciente().getNome());}
            return null;
        });
        colunaDoenca.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getPaciente()!=null){
                return new SimpleStringProperty(agenda.getValue().getPaciente().getDoencas());}
            return null;
        });
        colunaData.setCellValueFactory(new PropertyValueFactory<Agenda, String>("data"));

        colunaProcedimento.setCellValueFactory((agenda) -> {
            if (agenda.getValue().getProcedimento()!=null){
                return new SimpleStringProperty(agenda.getValue().getProcedimento().getNome());}
            return null;
        });

prencherTabela();
    }
   private   void prencherTabela(){
        DAO<Object>dao=new DAO<>(Object.class);

List<Agenda>agenda=dao.obterTodos();
       ObservableList<Agenda> agendas= FXCollections.observableArrayList(agenda);
       tableView.setItems(agendas);
   }
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