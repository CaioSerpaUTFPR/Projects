/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Caio
 */
public class PJ extends Application {
    private static Stage stage;
    private static Scene aberturaTela;
    private static Scene cadastroTela;
    private static Scene reclamacaoTela;
    private static Scene graficoTela;
    private static Scene abrirProcesso;
    private static Scene consultaProcesso;
    public static Scene vizualizaProcesso;
    
    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;
        
        primaryStage.setTitle("ACME");
        //TELA ABERTURA
        Parent abertura = FXMLLoader.load(getClass().getResource("view/abertura.fxml"));
        aberturaTela = new Scene(abertura,600,500);
        
         //TELA RECLAMAÇÃO
        Parent reclamacao = FXMLLoader.load(getClass().getResource("view/reclamacao.fxml"));
        reclamacaoTela = new Scene(reclamacao,710,600);
        
         //TELA CADASTRO
        Parent cadastro = FXMLLoader.load(getClass().getResource("view/cadastroC.fxml"));
        cadastroTela = new Scene(cadastro,600,570);
        
         //TELA CADASTRO
        Parent grafico = FXMLLoader.load(getClass().getResource("view/graficos.fxml"));
        graficoTela = new Scene(grafico,900, 591);
        
        //TELA ABERTURA PROCESSOS
        Parent aberturaProces = FXMLLoader.load(getClass().getResource("view/abrirProcesso.fxml"));
        abrirProcesso = new Scene(aberturaProces,600, 427);
        
        //TELA DE CONSULTA DOS PROCESSOS
        Parent consultaProces = FXMLLoader.load(getClass().getResource("view/consultaProcessos.fxml"));
        consultaProcesso = new Scene(consultaProces,742, 569);
        
        //TELA DE CONSULTA DOS PROCESSOS
        Parent vizualizaProces = FXMLLoader.load(getClass().getResource("view/vizualizarProcessos.fxml"));
        vizualizaProcesso = new Scene(vizualizaProces,790, 630);
        
        primaryStage.setScene(aberturaTela);
        primaryStage.show();
    }
    
    public static void mudaTela(String tela){
        switch(tela){
            case "reclamacao":
                stage.setScene(reclamacaoTela);
                break;
            case "cadastro":
                stage.setScene(cadastroTela);
                break;
            case "grafico":
                stage.setScene(graficoTela);
                break;
            case "abrirProcesso":
                stage.setScene(abrirProcesso);
                break;
            case "consultaProcesso":
                stage.setScene(consultaProcesso);
                break;
            case "vizualizaProcesso":
                stage.setScene(vizualizaProcesso);
                break;
        }
    }
    
    public static void voltarAbertura(){
        stage.setScene(aberturaTela);
    }
    
  

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
