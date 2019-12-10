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
public class Processo {
    private int id;
    private String normas;
    private String status;
    private int reclamacao_id;
    private int solucao_id;
    private int rg_cliente;
    private String nome_cliente;
    private String nome_atendente;

    
    public Processo(int id, String normas, int reclamacao_id, int solucao_id) {
        this.id = id;
        this.normas = normas;
        this.reclamacao_id = reclamacao_id;
        this.solucao_id = solucao_id;
    }

    public Processo(String normas, String status, int reclamacao_id, int solucao_id) {
        this.normas = normas;
        this.status = status;
        this.reclamacao_id = reclamacao_id;
        this.solucao_id = solucao_id;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNormas() {
        return normas;
    }

    public void setNormas(String normas) {
        this.normas = normas;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getReclamacao_id() {
        return reclamacao_id;
    }

    public void setReclamacao_id(int reclamacao_id) {
        this.reclamacao_id = reclamacao_id;
    }

    public int getSolucao_id() {
        return solucao_id;
    }

    public void setSolucao_id(int solucao_id) {
        this.solucao_id = solucao_id;
    }

    public int getRg_cliente() {
        return rg_cliente;
    }

    public void setRg_cliente(int rg_cliente) {
        this.rg_cliente = rg_cliente;
    }

    public String getNome_cliente() {
        return nome_cliente;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public String getNome_atendente() {
        return nome_atendente;
    }

    public void setNome_atendente(String nome_atendente) {
        this.nome_atendente = nome_atendente;
    }
}
