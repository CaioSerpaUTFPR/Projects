/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.controller;

import banco.Banco;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import pj.PJ;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class GraficosController implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private PieChart graficoAtendimento;
    @FXML
    private Button btGraficoAtendente;
    @FXML
    private Button btMediaPrazo;
    @FXML
    private Label lbMedia;
    @FXML
    private Label lbText1;
    @FXML
    private Label lbText2;
    @FXML
    private Label lbEstatistica;
    

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        voltar.getStyleClass().add("buttonTeste");
    }    

    @FXML
    private void voltar(ActionEvent event) {
        graficoAtendimento.setVisible(false);
        lbMedia.setVisible(false);
        lbText1.setVisible(false);
        lbText2.setVisible(false);
        PJ.voltarAbertura();
    }

    @FXML
    private void popularAtendentes(ActionEvent event) throws SQLException, ClassNotFoundException {
        Banco banco = new Banco();
        int f1 = banco.getAtendimentosFuncionario(1);
        int f2 = banco.getAtendimentosFuncionario(2);
        int f3 = banco.getAtendimentosFuncionario(3);

        ObservableList<PieChart.Data> pieChartData =
        FXCollections.observableArrayList(
                new PieChart.Data("Funcionario 1", f1),
                new PieChart.Data("Funcionario 2", f2),
                new PieChart.Data("Funcionario 3", f3)
            );
            graficoAtendimento.setTitle("Quantidade de atendimentos realizados por funcionario");
            graficoAtendimento.setData(pieChartData);
            graficoAtendimento.setVisible(true);
        
    }

    @FXML
    private void calculaMedia(ActionEvent event) throws SQLException, ClassNotFoundException {
        List<Integer> prazos = new ArrayList<>();
        Banco banco = new Banco();
        float mediaPrazo = 0;
        int divisor = 0;
        prazos = banco.getPrazosSolucao();
        for(int prazo : prazos){
                mediaPrazo += prazo;
                divisor++;
            }
        mediaPrazo /= divisor;
        lbMedia.setText(""+mediaPrazo);
        lbText1.setVisible(true);
        lbText2.setVisible(true);
        lbMedia.setVisible(true);
    }   
}
