/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.controller;

import com.sun.javaws.Main;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.Initializable;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.control.TreeItem;
import javafx.scene.control.TreeView;
import javafx.scene.effect.BoxBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import pj.PJ;

/**
 * FXML Controller class
 *
 * @author Caio
 */
public class AberturaController implements Initializable {
    
    
    @FXML
    private TreeView p1;
    
    @FXML
    private ImageView img;
      
    TreeItem root = new TreeItem("");
        
    TreeItem pergunta1 = new TreeItem("Qual o horario de atendiemto via SAQ ?");
    TreeItem pergunta2 = new TreeItem("Quero fazer uma reclamação pessoalmente, qual o endereço da loja ?");
    TreeItem pergunta3 = new TreeItem("Tenho direito a troca do produto depois de passada a garantia ?");
    TreeItem pergunta4 = new TreeItem("Loja fisica apenas no centro de Bobolandia ?");
    TreeItem pergunta5 = new TreeItem("Qual o prazo para resposta da minha reclamação ?");

    TreeItem resposta1 = new TreeItem("Nosso horario de atendimento começa as 8hrs finalizando as 18hrs!");
    TreeItem resposta2 = new TreeItem("Rua dos bobos, numero 0, Centro, Bobolandia-BB.");
    TreeItem resposta3 = new TreeItem("Somente se for detectado em nossos testes um defeito no produto!");
    TreeItem resposta4 = new TreeItem("Sim, por enquanto apenas no centro, mas estamos apliando nossas instalações para melhor atender nossos clientes!");
    TreeItem resposta5 = new TreeItem("O prazo é definido e comunicado aos clientes pelo atendente ao realizar a reclamação");
    @FXML
    private Hyperlink h1;
    @FXML
    private Hyperlink h2;
    @FXML
    private Hyperlink h3;
    @FXML
    private Button cadastrar;
    
    
  
   
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
       
        p1.setRoot(root);
        root.getChildren().addAll(pergunta1, pergunta2, pergunta3, pergunta4, pergunta5);
        
        pergunta1.getChildren().addAll(resposta1);
        pergunta2.getChildren().addAll(resposta2);
        pergunta3.getChildren().addAll(resposta3);
        pergunta4.getChildren().addAll(resposta4);
        pergunta5.getChildren().addAll(resposta5);
        
        
        Image imagem = new Image("/imagens/acme_logo.jpg");
        img.setImage(imagem);
  

    }    

    @FXML
    private void preencherReclamacao(ActionEvent event) {
        PJ.mudaTela("reclamacao");
        
    }

    @FXML
    private void cadastrarCliente(ActionEvent event) {
        PJ.mudaTela("cadastro");
    }

    @FXML
    private void gerarGraficos(ActionEvent event) {
        PJ.mudaTela("grafico");
    }

    @FXML
    private void consultaProcessos(ActionEvent event) {
        PJ.mudaTela("consultaProcesso");
    }

   
    
}
