/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.io.*;
import java.sql.SQLException;
import java.util.Arrays;

/**
 *
 * @author Caio
 */
public class configuraBD {
   
    
    public static void main( String args[] ) throws SQLException, ClassNotFoundException {
        Banco banco = new Banco();
        String[] sql;
        
        String filename = "C:\\Users\\Caio\\Documents\\NetBeansProjects\\PJ\\src\\banco\\Tabelas_Banco.txt";
        try {
            FileReader fr = new FileReader(filename);
            BufferedReader in = new BufferedReader (fr);
            String aux;
            String lido="";
        while( (aux=in.readLine())!= null )
            lido += aux;
        in.close ();  
        sql = lido.split("#");
   
        //PERCORRE SQL[] E EXECUTA AS SQL NA CLASSE BANCO
        for (String sql1 : sql) {
            banco.executarSQL(sql1);
        }
        }catch( IOException e ) {
            System.out.println ("Erro na leitura");
        }
    } 
}
