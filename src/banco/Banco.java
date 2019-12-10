/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import pj.model.Cliente;
import pj.model.DadosCompletos;
import pj.model.Detalhe;
import pj.model.Funcionario;
import pj.model.Processo;
import pj.model.ProcessosAbertos;
import pj.model.Reclamacao;
import pj.model.Solucao;

/**
 *
 * @author Caio
 */
public class Banco {
    
    private Connection conexao;
    private String driver;
    private String url;
    private String user;
    private String senha;
    
    public Banco(String driver, String url, String user, String senha){
        this.driver = driver;
        this.url = url;
        this.user = user;
        this.senha = senha;
    }

    public Banco() {
        this.driver = "com.mysql.jdbc.Driver";
        this.url = "jdbc:mysql://localhost:3306/sac";
        this.user = "root";
        this.senha = "root";
    }
    
    public void conectar() throws SQLException, ClassNotFoundException{
        Class.forName(getDriver());
        setConexao(DriverManager.getConnection(getUrl(), getUser(), getSenha()));
    }
    public void fecharConexao() throws SQLException{
        getConexao().close();
    }
    public boolean executarSQL(String sql) throws SQLException, ClassNotFoundException {
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        sessao.executeUpdate(sql);
        return true;
    }
    
    public int getLastIDReclamacao() throws SQLException, ClassNotFoundException{
        String sql = "SELECT MAX(id) AS id FROM reclamacao";
        int lastIDReclamacao = 0;
        ResultSet response;
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        if(response.next()) {
            lastIDReclamacao = response.getInt("id");
        }
        return lastIDReclamacao;
    }
    public int getLastID(String sql) throws SQLException, ClassNotFoundException{
        int lastID = 0;
        ResultSet response;
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        if(response.next()) {
            lastID = response.getInt("id");
        }
        return lastID;
    }
    public ResultSet getSQL(String sql) throws SQLException, ClassNotFoundException {
        ResultSet response = null;
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        return response;
    }   
    public List<Cliente> getAllClientes() throws SQLException, ClassNotFoundException {
        ResultSet response = null;
        String sql = "SELECT * FROM consumidor;";
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        List<Cliente> clientes = new ArrayList<>();
        while(response.next()){
            Cliente cliente = new Cliente(response.getString("nome"),response.getString("rg"),
            response.getString("cpf"), response.getString("endereco"));
            cliente.setId(response.getInt("id"));
            clientes.add(cliente);
        }
        return clientes;
    } 
    public List<Funcionario> getAllFuncionarios() throws SQLException, ClassNotFoundException {
        ResultSet response = null;
        String sql = "SELECT * FROM funcionario;";
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        List<Funcionario> funcionarios = new ArrayList<>();
        while(response.next()){
            Funcionario funcionario = new Funcionario(response.getInt("id"),
            response.getString("nome"),response.getString("rg"));
            funcionarios.add(funcionario);
        }
        return funcionarios;
    }
    public List<ProcessosAbertos> getAllProcessos() throws SQLException, ClassNotFoundException{
        ResultSet response = null;
        //String sql = "SELECT * FROM processo;";
        String sql = "SELECT c.nome, c.rg, f.nome, p.status, c.id, f.id, p.id\n" +
"\n" +
"FROM processo p, reclamacao r, consumidor c, funcionario f\n" +
"\n" +
"WHERE p.reclamacaoID = r.id AND r.consumidorID = c.id And r.funcionarioID = f.id;";
        if (getConexao()== null) {
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        List<ProcessosAbertos> processosAbertos = new ArrayList<>();
        while(response.next()){
            ProcessosAbertos processoAberto = new ProcessosAbertos(response.getInt("c.id"),response.getInt("f.id"), response.getInt("p.id"),
                    response.getString("c.nome"), response.getString("f.nome"), response.getString("c.rg"), response.getString("p.status"));
            processosAbertos.add(processoAberto);
        }
        return processosAbertos;
        
    }
    public void getDadosProcesso() throws SQLException, ClassNotFoundException{
        ResultSet response = null;
        int processoID = DadosCompletos.getInstance().getProcessoID();
        System.out.println(processoID);
        String sql = "SELECT p.id, c.nome, c.rg, c.cpf, c.endereco, f.nome, r.tipo, r.natureza_problema,"
                + " r.prazo_solucao, r.procedimentos_adotados, d.data_reclamacao, d.problema_encontrado,"
                + " d.situacao_problema, d.circunstancias, d.efeitos_colaterais, d.garantia, d.data_compra,"
                + " p.status, s.descricao, s.tempo_media"
                + " FROM processo p, reclamacao r, consumidor c, detalhes d, funcionario f, solucao s"
                + " WHERE p.id = "+processoID+""
                + " AND p.reclamacaoID = r.id AND r.consumidorID = c.id  AND r.funcionarioID = f.id;";
        DadosCompletos.getInstance();
        if (getConexao()== null) {
            conectar();
        }
        System.out.println(sql);
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        while(response.next()){
            DadosCompletos.getInstance().setCPF(response.getString("c.cpf"));
            DadosCompletos.getInstance().setRG(response.getString("c.rg"));
            DadosCompletos.getInstance().setNomeCliente(response.getString("c.nome"));
            DadosCompletos.getInstance().setEndereco(response.getString("c.endereco"));
            DadosCompletos.getInstance().setNomeAtendente(response.getString("f.nome"));
            DadosCompletos.getInstance().setTipoReclamacao(response.getString("r.tipo"));
            DadosCompletos.getInstance().setNaturezaProblema(response.getString("r.natureza_problema"));
            DadosCompletos.getInstance().setDataReclamacao(response.getString("d.data_reclamacao"));
            DadosCompletos.getInstance().setPrazoSolucao(response.getInt("r.prazo_solucao"));
            DadosCompletos.getInstance().setProcedimentosAdotados(response.getString("r.procedimentos_adotados"));
            DadosCompletos.getInstance().setProblemaEncontrado(response.getString("d.problema_encontrado"));
            DadosCompletos.getInstance().setDataCompra(response.getString("d.data_compra"));
            DadosCompletos.getInstance().setGarantia(response.getInt("d.garantia"));
            DadosCompletos.getInstance().setSituacaoProblema(response.getString("d.situacao_problema"));
            DadosCompletos.getInstance().setCircunstancias(response.getString("d.circunstancias"));
            DadosCompletos.getInstance().setEfeitosColaterais(response.getString("d.efeitos_colaterais"));
            DadosCompletos.getInstance().setDescricaoSolucao(response.getString("s.descricao"));
            DadosCompletos.getInstance().setTempoSolucao(response.getInt("s.tempo_media"));
            DadosCompletos.getInstance().setStatus(response.getString("p.status"));
        }
       
        
    }
    public int getAtendimentosFuncionario(int idFuncionario) throws SQLException, ClassNotFoundException{
        int x =0;
        ResultSet response;
        String sql = "SELECT * from reclamacao WHERE funcionarioID ="+idFuncionario+";";
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        while(response.next()) {
            x = x+1;
        }
        return x;
    }
    public List<Integer> getPrazosSolucao() throws SQLException, ClassNotFoundException{
        String sql = "SELECT r.prazo_solucao FROM reclamacao r LIMIT 100;";
        List<Integer> prazos = new ArrayList<>();
        ResultSet response;
        if (getConexao()== null) {
           
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        response = sessao.executeQuery(sql);
        while(response.next()){
            int x = response.getInt("r.prazo_solucao");
            prazos.add(x);
        }
        return prazos;
    }
    public boolean cadastroCliente(Cliente c) throws SQLException, ClassNotFoundException{
         String sql = "INSERT INTO consumidor (nome, rg, cpf, endereco)"
                + "VALUES ('"+c.getNome()+"','"+c.getRg()+"','"+c.getCpf()+"','"+c.getEndereco()+"');";
         return this.executarSQL(sql);
     }
    public int criaDetalhes(Detalhe d) throws SQLException{
        int lastID;
        String sql = "INSERT INTO detalhes "
                    + "(problema_encontrado,"
                    + " data_compra, "
                    + "data_reclamacao,"
                    + " garantia, "
                    + "situacao_problema,"
                    + " circunstancias, "
                    + "efeitos_colaterais)"
                + "VALUES ('"
                    +d.getProblema_encontrado()+"','"
                    +d.getData_compra()+"','"
                    +d.getData_reclamacao()+"','"
                    +d.getGarantia()+"','"
                    +d.getSituacao_problema()+"','"
                    +d.getCircunstancias()+"','"
                    +d.getEfeitos_colaterais()+"');";
        try {
            this.executarSQL(sql);
            sql = "SELECT MAX(id) AS id FROM detalhes";
            lastID = this.getLastID(sql);
            return lastID;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }  
    }
    public void criaReclamacao(Reclamacao r) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO reclamacao "
                    + "(tipo,"
                    + "natureza_problema, "
                    + "prazo_solucao,"
                    + "procedimentos_adotados, "
                    + "consumidorID,"
                    + "detalhesID, "
                    + "funcionarioID)"
                + "VALUES ('"
                    +r.getTipo()+"','"
                    +r.getNatureza_problema()+"','"
                    +r.getPrazo_solucao()+"','"
                    +r.getProcedimentos_adotados()+"','"
                    +(r.getConsumidor_id()+1)+"','"
                    +r.getDetalhes_id()+"','"
                    +(r.getFuncionario_id()+1)+"');";
        this.executarSQL(sql);
    } 
    public int criaSolucao(Solucao s) throws SQLException{
        int lastID;
        String sql = "INSERT INTO solucao "
                    + "(descricao,"
                    + "tempo_media)"
                + "VALUES ('"
                    +s.getDescricao()+"','"
                    +s.getTempoMedia()+"');";
        try {
            this.executarSQL(sql);
            sql = "SELECT MAX(id) AS id FROM solucao";
            lastID = this.getLastID(sql);
            return lastID;
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Banco.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
        
    }
    public void criaProcesso(Processo p) throws SQLException, ClassNotFoundException{
        String sql = "INSERT INTO processo "
                    + "(normas_empresa,"
                    + "status, "
                    + "reclamacaoID,"
                    + "solucaoID)"
                + "VALUES ('"
                    +p.getNormas()+"','"
                    +p.getStatus()+"','"
                    +p.getReclamacao_id()+"','"
                    +p.getSolucao_id()+"');";
        this.executarSQL(sql);
    } 
    
    public void attCliente(Cliente c) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE consumidor SET "
                +"nome ='"+c.getNome()+"',"
                +"rg = '"+c.getRg()+"',"
                +"cpf= '"+c.getCpf()+"',"
                +"endereco= '"+c.getEndereco()+"' WHERE id ="+c.getId()+";";
        if (getConexao()== null) {
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        sessao.executeUpdate(sql);        
    }
    public void attProcesso(Processo p) throws SQLException, ClassNotFoundException{
        String sql = "UPDATE processo SET "
                +" status = '"+p.getStatus()+"'"
                + " WHERE id ="+p.getId()+";";
        if (getConexao()== null) {
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        sessao.executeUpdate(sql);        
    }
    
    public boolean deleteCliente(int id) throws SQLException, ClassNotFoundException{
        String sql = "DELETE FROM consumidor WHERE id='"+id+"';";
        if (getConexao()== null) {
            conectar();
        }
        Statement sessao = getConexao().createStatement();
        sessao.executeUpdate(sql);
        return true;
    } 
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
     
    /**
     * @return the conexao
     */
    public Connection getConexao() {
        return conexao;
    }

    /**
     * @param conexao the conexao to set
     */
    public void setConexao(Connection conexao) {
        this.conexao = conexao;
    }

    /**
     * @return the driver
     */
    public String getDriver() {
        return driver;
    }

    /**
     * @param driver the driver to set
     */
    public void setDriver(String driver) {
        this.driver = driver;
    }

    /**
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url the url to set
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * @return the user
     */
    public String getUser() {
        return user;
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        this.user = user;
    }

    /**
     * @return the senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    
}
