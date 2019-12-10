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
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import pj.PJ;
import pj.model.Cliente;
import pj.model.DadosCompletos;
import pj.model.Processo;
import pj.model.ProcessosAbertos;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class ConsultaProcessosController implements Initializable {

    @FXML
    private TableView<ProcessosAbertos> tableview;
    @FXML
    private TableColumn<ProcessosAbertos, String> col_cliente;
    @FXML
    private TableColumn<ProcessosAbertos, String> col_rg;
    @FXML
    private TableColumn<ProcessosAbertos, String> col_atendente;
    @FXML
    private TableColumn<ProcessosAbertos, String> col_status;

    List<ProcessosAbertos> list = new ArrayList<>();
    ObservableList<ProcessosAbertos> processosAbertos = FXCollections.observableArrayList();
    @FXML
    private Button btVizualizar;
    @FXML
    private Button attTableView;
    @FXML
    private Button voltarAbertura;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        col_cliente.setCellValueFactory(
                new PropertyValueFactory<>("nomeCliente"));
        col_rg.setCellValueFactory(
                new PropertyValueFactory<>("rgCliente"));
        col_atendente.setCellValueFactory(
                new PropertyValueFactory<>("nomeFuncionario"));
        col_status.setCellValueFactory(
                new PropertyValueFactory<>("processoStatus"));
        
        Banco banco = new Banco();
        try {
            list = banco.getAllProcessos();
            tableview.setItems(FXCollections.observableArrayList(list));    
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastroCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    



    @FXML
    private void vizualizarProcesso(ActionEvent event) {
        if(tableview.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione um processo antes de continuar!");
        }
        else{
            DadosCompletos.getInstance().setProcessoID(tableview.getSelectionModel().getSelectedItem().getProcessoID());
            //DadosCompletos.getInstance().setNomeCliente(tableview.getSelectionModel().getSelectedItem().getNomeCliente());
            PJ.mudaTela("vizualizaProcesso");
        }
    }    

    @FXML
    private void voltarAbertura(ActionEvent event) {
        PJ.voltarAbertura();
    }

    @FXML
    private void attTableView(ActionEvent event) throws SQLException, ClassNotFoundException {
        Banco banco = new Banco();
        list.clear();
        list = banco.getAllProcessos();
        tableview.setItems(FXCollections.observableArrayList(list));   
    }
}
