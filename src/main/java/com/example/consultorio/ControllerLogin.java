package com.example.consultorio;

import com.example.consultorio.dao.DAO;
import com.example.consultorio.entidades.Agenda;
import com.example.consultorio.entidades.Paciente;
import com.example.consultorio.validadores.CPF;
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
   private static Paciente paciente=new Paciente();
    @FXML
    TextField login;
    @FXML
    TextField senha;

    @FXML
      TextField cpf;
    @FXML
     TextField nome;
    @FXML
      DatePicker dataNascimento;
    @FXML
   RadioButton  maculino ;
    @FXML
        RadioButton  feminino;
    @FXML
    TextField  rg;
    @FXML
    TextField apelido=new TextField();
    @FXML
     RadioButton  casado;
    @FXML
     RadioButton  solteiro;
    @FXML
     TextField  celular;
    @FXML
     TextField  email;
    @FXML
     RadioButton doencaSim;

    @FXML
    RadioButton doencaNao;
    @FXML
    TextField  doencas;
    @FXML
    TextArea doencasObservacoes;
    @FXML
    TextField  logradouro;
    @FXML
    TextField  numroDaCasa;
    @FXML
    TextField  cidade;
    @FXML
    TextField  estado;
    @FXML
    TextField  bairro;
    @FXML
    TextField  cep;
    @FXML
    TextField  coplemento;
    @FXML Button proximo1;

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
        DAO<Object> dao=new DAO<>(Object.class);

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


       //CONTADO

        //DOENÇAS


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
    protected void realmenteSalvar() {
        Main.trocaTela(volta);
        DAO<Object>dao=new DAO<>();
        dao.persistirCompleto(paciente);
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


    protected void addPacienteButooProx(){

            paciente.setNome(nome.getText());
            paciente.setCpf(cpf.getText());
            paciente.setRG(rg.getText());

            if (maculino.isSelected()) {
                paciente.setGenero("masculino");
            }
            if (feminino.isSelected()) {
                paciente.setGenero("feminino");
            }
            paciente.setDate(dataNascimento.getValue());
            paciente.setEstadoCivil("solteiro");
            if (casado.isSelected()) {
                paciente.setEstadoCivil("casado");
            }
            }


    protected void addPacienteButooProxDois(){
        paciente.setCelular(celular.getText());
        paciente.setEmail(email.getText());
    }

    protected void addPacienteButooProxTres(){
        paciente.setDoenca(false);
        paciente.setDoencas("*");
        paciente.setDoencasObservacoes("*");
        if (doencaSim.isSelected()){
            paciente.setDoenca(doencaSim.isSelected());
            paciente.setDoencas(doencas.getText());
            paciente.setDoencasObservacoes(doencasObservacoes.getText());
        }
    }


    protected void addPacienteButooProxQuatro() {

        paciente.setLogradouro(logradouro.getText());
        paciente.setBairro(bairro.getText());
        paciente.setBairro(bairro.getText());
        paciente.setCidade(cidade.getText());
        paciente.setEstado(estado.getText());
        paciente.setNumroDaCasa(numroDaCasa.getText());
        paciente.setCep(cep.getText());
        paciente.setCoplemento(coplemento.getText());
    }


    @FXML
    protected  void teclad(){
proximo1.setDisable(true);
    }

@FXML
protected void habilita(){
    CPF cpf1=new CPF(cpf.getText());
    System.out.println(cpf1.isCPF());
        boolean habilitaBotaoUm=(nome.getText().isEmpty()| cpf.getText().isEmpty()| rg.getText().isEmpty()| dataNascimento.getValue() == null
                |!(maculino.isSelected()|feminino.isSelected())|!(casado.isSelected()|solteiro.isSelected()) |!cpf1.isCPF() );

        proximo1.setDisable(habilitaBotaoUm);
}
}