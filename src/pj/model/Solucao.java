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
public class Solucao {
    private int id;
    private String descricao;
    private int tempoMedia;

    public Solucao(int id, String descricao, int tempoMedia) {
        this.id = id;
        this.descricao = descricao;
        this.tempoMedia = tempoMedia;
    }

    public Solucao(String descricao, int tempoMedia) {
        this.descricao = descricao;
        this.tempoMedia = tempoMedia;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getTempoMedia() {
        return tempoMedia;
    }

    public void setTempoMedia(int tempoMedia) {
        this.tempoMedia = tempoMedia;
    }   
}
