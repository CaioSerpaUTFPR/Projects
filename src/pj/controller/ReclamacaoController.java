/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.controller;

import pj.model.Cliente;
import pj.model.Funcionario;
import banco.Banco;
import java.net.URL;
import java.sql.ResultSet;
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
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pj.PJ;
import pj.model.Detalhe;
import pj.model.Reclamacao;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class ReclamacaoController implements Initializable {

    @FXML
    private Button voltar;
    @FXML
    private ComboBox<String> cbAtendente;
    @FXML
    public ComboBox<String> cbCliente;
    
    private ResultSet resposta;
    @FXML
    private ChoiceBox<String> tipoReclamcao;
    @FXML
    private TextField procedimentos;
    @FXML
    private TextField prazoSolucao;
    @FXML
    private DatePicker dataCompra;
    @FXML
    private DatePicker dataReclamacao;
    @FXML
    private TextField circunstancias;
    @FXML
    private TextField efeitosColaterais;
    @FXML
    private TextField situacaoProblema;
    @FXML
    private TextField problemaEncontrado;
    @FXML
    private TextField garantia;
    @FXML
    private TextField naturezaProblema;
    
    List<Cliente> listaCliente = new ArrayList<>();
    ObservableList<Cliente> clientes = FXCollections.observableArrayList();
    
    List<Funcionario> listaFuncionario = new ArrayList<>();
    ObservableList<Funcionario> pessoas = FXCollections.observableArrayList();
    @FXML
    private Button atualizar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tipoReclamcao.getItems().addAll("SAC","Presencial","Fale Conosco");
        Banco banco = new Banco();
        try {
            
            listaCliente = banco.getAllClientes();
            for(Cliente c : listaCliente){
                cbCliente.getItems().add(c.getNome());
            }  
        } catch (SQLException ex) {
            Logger.getLogger(ReclamacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReclamacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            listaFuncionario = banco.getAllFuncionarios();
            for(Funcionario f : listaFuncionario){
                cbAtendente.getItems().add(f.getNome()); 
            }   
        } catch (SQLException ex) {
            Logger.getLogger(ReclamacaoController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ReclamacaoController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
   
    @FXML
    private void voltar(ActionEvent event) {
        PJ.voltarAbertura();
    }

    @FXML
    private void criarReclamacao(ActionEvent event) throws SQLException {
         //VALIDAÇÃO DOS CAMPOS 
        if (cbCliente.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione o cliente!"); 
        }
        else if (cbAtendente.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione o atendente!"); 
        }
        else if (tipoReclamcao.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione o tipo de reclamação!"); 
        }
        else if("".equals(garantia.getText()) || "".equals(procedimentos.getText()) || "".equals(prazoSolucao.getText()) || 
        "".equals(dataCompra.getValue()) || "".equals(dataReclamacao.getValue()) || "".equals(circunstancias.getText())
        || "".equals(efeitosColaterais.getText())|| "".equals(situacaoProblema.getText())
        || "".equals(problemaEncontrado.getText()) || "".equals(naturezaProblema.getText())){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }//VALIDAÇÃO FIM
        
        else{
            int lastID;
            Banco banco = new Banco();
            Detalhe d = new Detalhe(problemaEncontrado.getText(),dataCompra.getValue(), dataReclamacao.getValue(), Integer.parseInt(garantia.getText()),situacaoProblema.getText(), circunstancias.getText(),efeitosColaterais.getText());
            lastID = banco.criaDetalhes(d);
            Reclamacao r = new Reclamacao(
                    tipoReclamcao.getSelectionModel().getSelectedItem(),
                    naturezaProblema.getText(),
                    Integer.parseInt(prazoSolucao.getText()),
                    procedimentos.getText(),
                    lastID,
                    cbAtendente.getSelectionModel().getSelectedIndex(),
                    cbCliente.getSelectionModel().getSelectedIndex());
            try {
                banco.criaReclamacao(r);
                JOptionPane.showMessageDialog(null, "Reclamação criada com sucesso!");
                PJ.mudaTela("abrirProcesso");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReclamacaoController.class.getName()).log(Level.SEVERE, null, ex);
            }
        }  
    }

    @FXML
    private void attCombos(ActionEvent event) throws SQLException, ClassNotFoundException {
        Banco banco = new Banco();
        
        listaCliente.clear();
        cbCliente.getItems().clear();
        listaCliente = banco.getAllClientes();
        for(Cliente c : listaCliente){
                cbCliente.getItems().add(c.getNome());
        }        
    }
}
