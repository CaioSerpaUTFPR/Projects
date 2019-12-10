/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.model;

/**
 *
 * @author Caio
 */
public class Reclamacao {
    private int id;
    private String tipo;
    private String natureza_problema;
    private int prazo_solucao;
    private String procedimentos_adotados;
    private int detalhes_id;
    private int funcionario_id;
    private int consumidor_id;

    public Reclamacao(int id, String tipo, String natureza_problema, int prazo_solucao, String procedimentos_adotados, int detalhes_id, int funcionario_id, int consumidor_id) {
        this.id = id;
        this.tipo = tipo;
        this.natureza_problema = natureza_problema;
        this.prazo_solucao = prazo_solucao;
        this.procedimentos_adotados = procedimentos_adotados;
        this.detalhes_id = detalhes_id;
        this.funcionario_id = funcionario_id;
        this.consumidor_id = consumidor_id;
    }

    public Reclamacao(String tipo, String natureza_problema, int prazo_solucao, String procedimentos_adotados, int detalhes_id, int funcionario_id, int consumidor_id) {
        this.tipo = tipo;
        this.natureza_problema = natureza_problema;
        this.prazo_solucao = prazo_solucao;
        this.procedimentos_adotados = procedimentos_adotados;
        this.detalhes_id = detalhes_id;
        this.funcionario_id = funcionario_id;
        this.consumidor_id = consumidor_id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getNatureza_problema() {
        return natureza_problema;
    }

    public void setNatureza_problema(String natureza_problema) {
        this.natureza_problema = natureza_problema;
    }

    public int getPrazo_solucao() {
        return prazo_solucao;
    }

    public void setPrazo_solucao(int prazo_solucao) {
        this.prazo_solucao = prazo_solucao;
    }

    public String getProcedimentos_adotados() {
        return procedimentos_adotados;
    }

    public void setProcedimentos_adotados(String procedimentos_adotados) {
        this.procedimentos_adotados = procedimentos_adotados;
    }

    public int getDetalhes_id() {
        return detalhes_id;
    }

    public void setDetalhes_id(int detalhes_id) {
        this.detalhes_id = detalhes_id;
    }

    public int getFuncionario_id() {
        return funcionario_id;
    }

    public void setFuncionario_id(int funcionario_id) {
        this.funcionario_id = funcionario_id;
    }

    public int getConsumidor_id() {
        return consumidor_id;
    }

    public void setConsumidor_id(int consumidor_id) {
        this.consumidor_id = consumidor_id;
    }
    
    
    
}
