/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.controller;

import banco.Banco;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javax.swing.JOptionPane;
import pj.PJ;
import pj.model.Processo;
import pj.model.Solucao;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class AbrirProcessoController implements Initializable {

    @FXML
    private Button btFinalizaProcesso;
    @FXML
    private TextArea descSolucao;
    @FXML
    private TextArea norma;
    @FXML
    private ComboBox<String> cbStatus;
    @FXML
    private TextField tempoRes;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        cbStatus.getItems().addAll("Em processo","Finalizada");
    }    

    @FXML
    private void finalizarProcesso(ActionEvent event) throws SQLException, ClassNotFoundException {
        // VALIDAÇÃO CAMPOS
        if (cbStatus.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione a situação do processo!"); 
        }
        else if("".equals(descSolucao.getText()) || "".equals(norma.getText())|| "".equals(tempoRes.getText())){
            JOptionPane.showMessageDialog(null, "Preencha todos os campos");
        }//VALIDAÇÃO FIM
        else{
            int lastID;
            int lastIDReclamacao;
            Banco banco = new Banco();
            Solucao s = new Solucao(descSolucao.getText(),Integer.parseInt(tempoRes.getText()));
            lastID = banco.criaSolucao(s);
            lastIDReclamacao = banco.getLastIDReclamacao();
            Processo p = new Processo(norma.getText(),cbStatus.getSelectionModel().getSelectedItem(),lastIDReclamacao, lastID);
         try {
                banco.criaProcesso(p);
                JOptionPane.showMessageDialog(null, "Processo finalizado com sucesso!");
                PJ.voltarAbertura();
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(ReclamacaoController.class.getName()).log(Level.SEVERE, null, ex);
                JOptionPane.showMessageDialog(null, "Erro ao finalizar processo!");
            }
        }
    }   
}
