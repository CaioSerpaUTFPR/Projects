/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.controller;

import pj.model.Cliente;
import banco.Banco;
import java.io.IOException;
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
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javax.swing.JOptionPane;
import pj.PJ;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class CadastroCController implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private TextField nome;
    @FXML
    private TextField end;
    @FXML
    private TextField rg;
    @FXML
    private TextField cpf;
    @FXML
    private TableView<Cliente> tableview;
    @FXML
    private TableColumn<Cliente, String> col_nome;
    @FXML
    private TableColumn<Cliente, String> col_rg;
    @FXML
    private TableColumn<Cliente, String> col_id;
    @FXML
    private Button btExcluirC;
    @FXML
    private Button btAttC;
    @FXML
    private Button btCadastrar;    
    @FXML
    private Button btCancelarAtt;
    @FXML
    private Button btAtualizarDados;
    
    List<Cliente> list = new ArrayList<>();
    ObservableList<Cliente> clientes = FXCollections.observableArrayList();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        col_nome.setCellValueFactory(
                new PropertyValueFactory<>("Nome"));
        col_rg.setCellValueFactory(
                new PropertyValueFactory<>("rg"));
        col_id.setCellValueFactory(
                new PropertyValueFactory<>("id"));
        
        Banco banco = new Banco();
        try {
            list = banco.getAllClientes();
            tableview.setItems(FXCollections.observableArrayList(list));    
        } catch (SQLException | ClassNotFoundException ex) {
            Logger.getLogger(CadastroCController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    

    @FXML
    private void voltar(ActionEvent event) {
        btCadastrar.setVisible(true);
        btAttC.setVisible(true);
        btCancelarAtt.setVisible(false);
        btAtualizarDados.setVisible(false);
        
        nome.setText("");
        cpf.setText("");
        rg.setText("");
        end.setText("");
        PJ.voltarAbertura();
    }

    @FXML
    private void cadastrarCliente(ActionEvent event) throws SQLException, ClassNotFoundException, IOException {
        //VALIDAÇÃO DOS CAMPOS 
        if("".equals(nome.getText()) || "".equals(rg.getText()) || "".equals(cpf.getText()) || 
            "".equals(end.getText())){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }  
        else{
            Banco banco = new Banco();
            try {
                Cliente c = new Cliente(nome.getText(), rg.getText(), cpf.getText(), end.getText());
                banco.cadastroCliente(c);
                JOptionPane.showMessageDialog(null, "Usuario criado com sucesso! ");   
                list.clear();
                list = banco.getAllClientes();
                tableview.setItems(FXCollections.observableArrayList(list));
            }
            catch (Exception ex) {
                 JOptionPane.showMessageDialog(null, "Erro ao criar usuario! Verifique os campos de cadastro! ");
            }  
        }  
    }  

    @FXML
    private void attCliente(ActionEvent event) {
        btCadastrar.setVisible(false);
        btAttC.setVisible(false);
        btCancelarAtt.setVisible(true);
        btAtualizarDados.setVisible(true);
        
        nome.setText(tableview.getSelectionModel().getSelectedItem().getNome());
        cpf.setText(tableview.getSelectionModel().getSelectedItem().getCpf());
        rg.setText(tableview.getSelectionModel().getSelectedItem().getRg());
        end.setText(tableview.getSelectionModel().getSelectedItem().getEndereco());  
    }

    @FXML
    private void cancelarAtt(ActionEvent event) {
        btCadastrar.setVisible(true);
        btAttC.setVisible(true);
        btCancelarAtt.setVisible(false);
        btAtualizarDados.setVisible(false);
        
        nome.setText("");
        cpf.setText("");
        rg.setText("");
        end.setText("");
    }
    private void cancelarAtt() {
        btCadastrar.setVisible(true);
        btAttC.setVisible(true);
        btCancelarAtt.setVisible(false);
        btAtualizarDados.setVisible(false);
        
        nome.setText("");
        cpf.setText("");
        rg.setText("");
        end.setText("");
    }

    @FXML
    private void atualizarDados(ActionEvent event) {
        //VALIDAÇÃO DOS CAMPOS 
        if("".equals(nome.getText()) || "".equals(rg.getText()) || "".equals(cpf.getText()) || 
            "".equals(end.getText())){
             JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }
        else{
            Banco banco = new Banco();
            try {
                Cliente c = new Cliente(nome.getText(), rg.getText(), cpf.getText(), end.getText());
                c.setId(tableview.getSelectionModel().getSelectedIndex()+1);
                banco.attCliente(c);                
                JOptionPane.showMessageDialog(null, "Usuario atualizado com sucesso! ");
                list.clear();
                list = banco.getAllClientes();
                tableview.setItems(FXCollections.observableArrayList(list));
                this.cancelarAtt();
            }
            catch (Exception ex) {
                Logger.getLogger(CadastroCController.class.getName()).log(Level.SEVERE, null, ex);
                 JOptionPane.showMessageDialog(null, "Erro ao atualizar usuario! ");
            }
            
            
        }
    }
}
