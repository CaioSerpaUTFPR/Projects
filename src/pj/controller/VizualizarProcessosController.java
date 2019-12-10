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
import javax.swing.JOptionPane;
import pj.PJ;
import pj.model.DadosCompletos;
import pj.model.Processo;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class VizualizarProcessosController implements Initializable {
   
    
    @FXML
    private ComboBox<String> cbStatus;
    @FXML
    private Button btAlterarStatus;
    @FXML
    private Label lbNomeCliente;
    @FXML
    private Button voltaAbertura;
    @FXML
    private Button attDados;
    @FXML
    private Label lbCpf;
    @FXML
    private Label lbRg;
    @FXML
    private Label lbEndereco;
    @FXML
    private Label lbFuncionario;
    @FXML
    private Label lbTipoReclamacao;
    @FXML
    private Label lbNaturezaProblema;
    @FXML
    private Label lbDataReclamacao;
    @FXML
    private Label lbPrazo;
    @FXML
    private Label lbProcedimentos;
    @FXML
    private Label lbProblemaEncontrado;
    @FXML
    private Label lbDataCompra;
    @FXML
    private Label lbGarantia;
    @FXML
    private Label lbSituacao;
    @FXML
    private Label lbCircunstancias;
    @FXML
    private Label lbEfeitos;
    @FXML
    private Label lbDescSolucao;
    @FXML
    private Label lbTempoSolucao;
    @FXML
    private Label lbStatusAtual;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
     
    
        
    }    
    
    @FXML
    private void alterarStatus(ActionEvent event) {
        if (cbStatus.getSelectionModel().getSelectedItem() == null){
            JOptionPane.showMessageDialog(null, "Selecione a nova situação do processo!"); 
        }
        Processo p = new Processo(DadosCompletos.getInstance().getProcessoID(),"", 0,0);
        p.setStatus(cbStatus.getSelectionModel().getSelectedItem());
        Banco banco = new Banco();
        try {
            banco.attProcesso(p);
            JOptionPane.showMessageDialog(null, "Processo atualizado com sucesso!");  
            PJ.mudaTela("consultaProcesso");
        } catch (SQLException ex) {
            Logger.getLogger(VizualizarProcessosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro no banco de dados!"); 
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VizualizarProcessosController.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao atualizar processo!"); 
        }
    }

    @FXML
    private void voltaProcessos(ActionEvent event) {
        lbNomeCliente.setText("");
        lbCpf.setText("");
        lbRg.setText("");
        lbEndereco.setText("");
        lbFuncionario.setText("");
        lbTipoReclamacao.setText("");
        lbNaturezaProblema.setText("");
        lbDataReclamacao.setText("");
        lbPrazo.setText("");
        lbProcedimentos.setText("");
        lbProblemaEncontrado.setText("");
        lbDataCompra.setText("");
        lbGarantia.setText("");
        lbSituacao.setText("");
        lbCircunstancias.setText("");
        lbEfeitos.setText("");
        lbDescSolucao.setText("");
        lbTempoSolucao.setText("");
        lbStatusAtual.setText("");
        PJ.mudaTela("consultaProcesso");
    }

    @FXML
    private void attDados(ActionEvent event) {
        Banco banco = new Banco();
        try {
            banco.getDadosProcesso();
        } catch (SQLException ex) {
            
            Logger.getLogger(VizualizarProcessosController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(VizualizarProcessosController.class.getName()).log(Level.SEVERE, null, ex);
        }
        lbNomeCliente.setText(DadosCompletos.getInstance().getNomeCliente());
        lbCpf.setText(DadosCompletos.getInstance().getCPF());
        lbRg.setText(DadosCompletos.getInstance().getRG());
        lbEndereco.setText(DadosCompletos.getInstance().getEndereco());
        lbFuncionario.setText(DadosCompletos.getInstance().getNomeAtendente());
        lbTipoReclamacao.setText(DadosCompletos.getInstance().getTipoReclamacao());
        lbNaturezaProblema.setText(DadosCompletos.getInstance().getNaturezaProblema());
        lbDataReclamacao.setText(DadosCompletos.getInstance().getDataReclamacao());
        lbPrazo.setText(Integer.toString(DadosCompletos.getInstance().getPrazoSolucao()));
        lbProcedimentos.setText(DadosCompletos.getInstance().getProcedimentosAdotados());
        lbProblemaEncontrado.setText(DadosCompletos.getInstance().getProblemaEncontrado());
        lbDataCompra.setText(DadosCompletos.getInstance().getDataCompra());
        lbGarantia.setText(Integer.toString(DadosCompletos.getInstance().getGarantia()));
        lbSituacao.setText(DadosCompletos.getInstance().getSituacaoProblema());
        lbCircunstancias.setText(DadosCompletos.getInstance().getCircunstancias());
        lbEfeitos.setText(DadosCompletos.getInstance().getEfeitosColaterais());
        lbDescSolucao.setText(DadosCompletos.getInstance().getDescricaoSolucao());
        lbTempoSolucao.setText(Integer.toString(DadosCompletos.getInstance().getTempoSolucao()));
        lbStatusAtual.setText(DadosCompletos.getInstance().getStatus());
        cbStatus.getItems().addAll("Em processo","Finalizada");
    }
    
}
