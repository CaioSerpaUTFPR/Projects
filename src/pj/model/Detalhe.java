/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pj.model;

import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Caio
 */
public class Detalhe {
    private int id;
    private String problema_encontrado;
    private LocalDate data_compra;
    private LocalDate data_reclamacao;
    private int garantia;
    private String situacao_problema;
    private String circunstancias;
    private String efeitos_colaterais;

    public Detalhe() {
    }

    public Detalhe(String problema_encontrado, LocalDate data_compra, LocalDate data_reclamacao, int garantia, String situacao_problema, String circunstancias, String efeitos_colaterais) {
        this.problema_encontrado = problema_encontrado;
        this.data_compra = data_compra;
        this.data_reclamacao = data_reclamacao;
        this.garantia = garantia;
        this.situacao_problema = situacao_problema;
        this.circunstancias = circunstancias;
        this.efeitos_colaterais = efeitos_colaterais;
    }

    
    public Detalhe(int id, String problema_encontrado, LocalDate data_compra, LocalDate data_reclamacao, int garantia, String situacao_problema, String circunstancias, String efeitos_colaterais) {
        this.id = id;
        this.problema_encontrado = problema_encontrado;
        this.data_compra = data_compra;
        this.data_reclamacao = data_reclamacao;
        this.garantia = garantia;
        this.situacao_problema = situacao_problema;
        this.circunstancias = circunstancias;
        this.efeitos_colaterais = efeitos_colaterais;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getProblema_encontrado() {
        return problema_encontrado;
    }

    public void setProblema_encontrado(String problema_encontrado) {
        this.problema_encontrado = problema_encontrado;
    }

    public LocalDate getData_compra() {
        return data_compra;
    }

    public void setData_compra(LocalDate data_compra) {
        this.data_compra = data_compra;
    }

    public LocalDate getData_reclamacao() {
        return data_reclamacao;
    }

    public void setData_reclamacao(LocalDate data_reclamacao) {
        this.data_reclamacao = data_reclamacao;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getSituacao_problema() {
        return situacao_problema;
    }

    public void setSituacao_problema(String situacao_problema) {
        this.situacao_problema = situacao_problema;
    }

    public String getCircunstancias() {
        return circunstancias;
    }

    public void setCircunstancias(String circunstancias) {
        this.circunstancias = circunstancias;
    }

    public String getEfeitos_colaterais() {
        return efeitos_colaterais;
    }

    public void setEfeitos_colaterais(String efeitos_colaterais) {
        this.efeitos_colaterais = efeitos_colaterais;
    }
    
    
    
}
