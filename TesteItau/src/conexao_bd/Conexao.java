/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao_bd;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
/**
 *
 * @author Bernardes
 */
public class Conexao {
    
    //declarando variaveis que serao utilizados para conectar no banco
    public Statement stm;
    public ResultSet rs;
    private String driver = "org.postgresql.Driver";
    private String database = "jdbc:postgresql://localhost:5432/TesteItau";
    private String user = "postgres";
    private String senha = "postgres";
    public Connection con;
    
    public void conecta(){
        try{
            System.setProperty("jdbc.Drivers", driver);
            con = DriverManager.getConnection(database, user, senha);
            System.out.println("Conectado com sucesso!");
            
        }
        catch (SQLException exp){
            JOptionPane.showMessageDialog(null, "Erro ao conectar com o banco \n"+exp);
        }
    }
    
    //metodo para executar um script sql que é enviado como parametro
    public void executarSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao rodar SQL");
        }
    }
    
    public ResultSet executarSql2(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE, rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
        } catch (SQLException ex) {
            Logger.getLogger(Conexao.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao rodar SQL");
        }
        
        return rs;
    }
    
    public void adicionaArquivo(String sql){
        Conexao conectar = new Conexao();
        conectar.conecta();
        
        try {           
        
            PreparedStatement st = conectar.con.prepareStatement(sql);
            st.execute();

            JOptionPane.showMessageDialog(null, "Arquivo Gravado com Sucesso"); 
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao gravar arquivo /n Erro: " + ex);
        }

        conectar.desconecta();
    }
    
    public int buscaLastCodigo() {
        Conexao conecta = new Conexao();
                conecta.conecta();
        conecta.executarSql("select cod_arquivo from arquivos");
        try {
            conecta.rs.last();
            int resultado = conecta.rs.getInt("cod_arquivo");
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }
    
    //metedo para desconectar do banco de dados
    public void desconecta(){
        try{
            con.close();
            System.out.println("Desconectado do banco");
        }
        catch(SQLException ex){
            JOptionPane.showMessageDialog(null, "Falha na desconexao /n"+ex);
        }
    }
}
