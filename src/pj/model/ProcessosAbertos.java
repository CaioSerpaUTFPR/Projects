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
public class ProcessosAbertos {
    private int clienteID;
    private int funcionarioID;
    private int processoID;
    private String nomeCliente;
    private String nomeFuncionario;
    private String rgCliente;
    private String processoStatus;

    public ProcessosAbertos(int clienteID, int funcionarioID, int processoID, String nomeCliente, String nomeFuncionario, String rgCliente, String processoStatus) {
        this.clienteID = clienteID;
        this.funcionarioID = funcionarioID;
        this.processoID = processoID;
        this.nomeCliente = nomeCliente;
        this.nomeFuncionario = nomeFuncionario;
        this.rgCliente = rgCliente;
        this.processoStatus = processoStatus;
    }

    public int getClienteID() {
        return clienteID;
    }

    public void setClienteID(int clienteID) {
        this.clienteID = clienteID;
    }

    public int getFuncionarioID() {
        return funcionarioID;
    }

    public void setFuncionarioID(int funcionarioID) {
        this.funcionarioID = funcionarioID;
    }

    public int getProcessoID() {
        return processoID;
    }

    public void setProcessoID(int processoID) {
        this.processoID = processoID;
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public void setNomeCliente(String nomeCliente) {
        this.nomeCliente = nomeCliente;
    }

    public String getNomeFuncionario() {
        return nomeFuncionario;
    }

    public void setNomeFuncionario(String nomeFuncionario) {
        this.nomeFuncionario = nomeFuncionario;
    }

    public String getRgCliente() {
        return rgCliente;
    }

    public void setRgCliente(String rgCliente) {
        this.rgCliente = rgCliente;
    }

    public String getProcessoStatus() {
        return processoStatus;
    }

    public void setProcessoStatus(String processoStatus) {
        this.processoStatus = processoStatus;
    }
    
    
    
}
