package com.example.consultorio;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class Main extends Application {
    private  static Stage stages;
    private static Scene mainScene;
    private static Scene menuScene;
    private static Scene calendarScena;
    private static Scene paciente;
    private static Scene configScena;
    private static Scene addPacienteUm;
    private static Scene addPacientedois;
    private static Scene addPacienteTres;
    private static Scene addPacienteQuatro;
    private static Scene addPacienteCadastro;
    private static Scene addSalvar;
    private static Scene addExcluir;
    private static Scene addProcedimento;
    private static Scene addProcedimentoDois;
    private static Scene abrirAgenda;


    String  arquivoCSS= Objects.requireNonNull(getClass().getResource("/css/consultorio.css")).toExternalForm();

    @Override
    public void start(Stage stage) throws IOException {
        stages=stage;
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("hello-view.fxml"));


        mainScene=new Scene(fxmlLoader.load());

        FXMLLoader menu = new FXMLLoader(Main.class.getResource("menu.fxml"));
        menuScene=new Scene(menu.load());


        FXMLLoader calendar = new FXMLLoader(Main.class.getResource("Calendar.fxml"));
        calendarScena=new Scene(calendar.load());

        FXMLLoader pacientes = new FXMLLoader(Main.class.getResource("novoPaciente.fxml"));
       paciente =new Scene(pacientes.load());

        FXMLLoader passo1 = new FXMLLoader(Main.class.getResource("dadosBasicos.fxml"));
        addPacienteUm=new Scene(passo1.load());

         FXMLLoader passo2 = new FXMLLoader(Main.class.getResource("dadosContato.fxml"));
        addPacientedois=new Scene(passo2.load());

        FXMLLoader passo3 = new FXMLLoader(Main.class.getResource("dadosObservacao.fxml"));
        addPacienteTres=new Scene(passo3.load());

        FXMLLoader passo4 = new FXMLLoader(Main.class.getResource("dadosLocalidade.fxml"));
        addPacienteQuatro=new Scene(passo4.load());

        FXMLLoader passo5 = new FXMLLoader(Main.class.getResource("cadastroCliente.fxml"));
        addPacienteCadastro=new Scene(passo5.load());

        FXMLLoader salvar = new FXMLLoader(Main.class.getResource("Salvar.fxml"));
        addSalvar=new Scene(salvar.load());

        FXMLLoader excluir= new FXMLLoader(Main.class.getResource("Excluir.fxml"));
        addExcluir=new Scene(excluir.load());

        FXMLLoader config= new FXMLLoader(Main.class.getResource("Config.fxml"));
       configScena=new Scene(config.load());

        FXMLLoader procedimento= new FXMLLoader(Main.class.getResource("Procedimento.fxml"));
        addProcedimento=new Scene(procedimento.load());

        FXMLLoader procedimentoCadastro= new FXMLLoader(Main.class.getResource("cadastroProcedimento.fxml"));
        addProcedimentoDois=new Scene(procedimentoCadastro.load());

        FXMLLoader agenda = new FXMLLoader(Main.class.getResource("AbrirAgenda.fxml"));
      abrirAgenda=new Scene(agenda.load());


        styleCsss(menuScene, mainScene, calendarScena, paciente, addPacienteUm, addPacientedois, addPacienteTres);
        styleCsss(addPacienteQuatro, addPacienteCadastro, addSalvar, addExcluir, configScena, addProcedimento, addProcedimentoDois);
        abrirAgenda.getStylesheets().add(arquivoCSS);
        stage.setTitle("consultorio");
        stage.setScene(mainScene);
        stage.show();
    }

    private void styleCsss(Scene menuScene, Scene mainScene, Scene calendarScena, Scene paciente, Scene addPacienteUm, Scene addPacientedois, Scene addPacienteTres) {
        menuScene.getStylesheets().add(arquivoCSS);
        mainScene.getStylesheets().add(arquivoCSS);
        calendarScena.getStylesheets().add(arquivoCSS);
        paciente.getStylesheets().add(arquivoCSS);
        addPacienteUm.getStylesheets().add(arquivoCSS);
        addPacientedois.getStylesheets().add(arquivoCSS);
        addPacienteTres.getStylesheets().add(arquivoCSS);
    }

    public static void trocaTela(int i){
        switch (i) {
            case 1 -> stages.setScene(menuScene);

            case 2 -> stages.setScene(mainScene);
            case 3 -> stages.setScene(calendarScena);
            case 4 -> stages.setScene(paciente);
            case 5 -> stages.setScene(addPacienteUm);
            case 6 -> stages.setScene(addPacientedois);
            case 7 -> stages.setScene(addPacienteTres);
            case 8 -> stages.setScene(addPacienteQuatro);
            case 9 -> stages.setScene(addPacienteCadastro);
            case 10 -> stages.setScene(addSalvar);
            case 11 -> stages.setScene(addExcluir);
            case 12 -> stages.setScene(configScena);
            case 13 -> stages.setScene(addProcedimento);
            case 14 -> stages.setScene(addProcedimentoDois);
            case 15 -> stages.setScene(abrirAgenda);
        }

    }

    public static void main(String[] args) {

        launch();
    }
}