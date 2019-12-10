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
public class DadosCompletos {
    private String nomeCliente;
    private String RG;
    private String CPF;
    private String endereco;
    private String nomeAtendente;
    private String DataReclamacao;
    private String tipoReclamacao;
    private String naturezaProblema;
    private int prazoSolucao;
    private String procedimentosAdotados;
    private String DataCompra;
    private int garantia;
    private String problemaEncontrado;
    private String situacaoProblema;
    private String circunstancias;
    private String efeitosColaterais;
    private String descricaoSolucao;
    private int tempoSolucao;
    private String status;
    private int processoID;
    private static DadosCompletos dados = new DadosCompletos();
    
    
    private DadosCompletos() {
    }
    
    
    public static DadosCompletos getInstance() {
        return dados;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getRG() {
        return RG;
    }

    public void setRG(String RG) {
        this.RG = RG;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getNomeAtendente() {
        return nomeAtendente;
    }

    public void setNomeAtendente(String nomeAtendente) {
        this.nomeAtendente = nomeAtendente;
    }

    public String getDataReclamacao() {
        return DataReclamacao;
    }

    public void setDataReclamacao(String DataReclamacao) {
        this.DataReclamacao = DataReclamacao;
    }

    public String getTipoReclamacao() {
        return tipoReclamacao;
    }

    public void setTipoReclamacao(String tipoReclamacao) {
        this.tipoReclamacao = tipoReclamacao;
    }

    public String getNaturezaProblema() {
        return naturezaProblema;
    }

    public void setNaturezaProblema(String naturezaProblema) {
        this.naturezaProblema = naturezaProblema;
    }

    public int getPrazoSolucao() {
        return prazoSolucao;
    }

    public void setPrazoSolucao(int prazoSolucao) {
        this.prazoSolucao = prazoSolucao;
    }

    public String getProcedimentosAdotados() {
        return procedimentosAdotados;
    }

    public void setProcedimentosAdotados(String procedimentosAdotados) {
        this.procedimentosAdotados = procedimentosAdotados;
    }

    public String getDataCompra() {
        return DataCompra;
    }

    public void setDataCompra(String DataCompra) {
        this.DataCompra = DataCompra;
    }

    public int getGarantia() {
        return garantia;
    }

    public void setGarantia(int garantia) {
        this.garantia = garantia;
    }

    public String getProblemaEncontrado() {
        return problemaEncontrado;
    }

    public void setProblemaEncontrado(String problemaEncontrado) {
        this.problemaEncontrado = problemaEncontrado;
    }

    public String getSituacaoProblema() {
        return situacaoProblema;
    }

    public void setSituacaoProblema(String situacaoProblema) {
        this.situacaoProblema = situacaoProblema;
    }

    public String getCircunstancias() {
        return circunstancias;
    }

    public void setCircunstancias(String circunstancias) {
        this.circunstancias = circunstancias;
    }

    public String getEfeitosColaterais() {
        return efeitosColaterais;
    }

    public void setEfeitosColaterais(String efeitosColaterais) {
        this.efeitosColaterais = efeitosColaterais;
    }

    public String getDescricaoSolucao() {
        return descricaoSolucao;
    }

    public void setDescricaoSolucao(String descricaoSolucao) {
        this.descricaoSolucao = descricaoSolucao;
    }

    public int getTempoSolucao() {
        return tempoSolucao;
    }

    public void setTempoSolucao(int tempoSolucao) {
        this.tempoSolucao = tempoSolucao;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    } 

    public int getProcessoID() {
        return processoID;
    }

    public void setProcessoID(int processoID) {
        this.processoID = processoID;
    }
    
}
