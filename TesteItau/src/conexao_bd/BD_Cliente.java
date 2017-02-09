/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 */
package conexao_bd;

import tipos.*;
import java.sql.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 *
 * @author Victor Bernardes
 */
public class BD_Cliente {

    Conexao conecta = new Conexao();
    Cliente cliente = new Cliente();

    //metodo para realizar o cadastro de clientes, atraves o do Insert por sql
    public void Cadastrar(Cliente cli) {
        conecta.conecta();
        try {
            PreparedStatement st = conecta.con.prepareStatement("INSERT INTO cliente(cod_cliente, nome_cliente, end_rua, end_numero, end_cidade, end_estado, cpf_cliente, rg_cliente, email_cliente, senha_cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            st.setInt(1, cli.getCodigo());
            st.setString(2, cli.getNome());
            st.setString(3, cli.getRua());
            st.setInt(4, cli.getNum());
            st.setString(5, cli.getCidade());
            st.setString(6, cli.getEstado());
            st.setInt(7, cli.getCpf());
            st.setInt(8, cli.getRg());
            st.setString(9, cli.getEmail());
            st.setString(10, cli.getSenha());

            st.execute();

            JOptionPane.showMessageDialog(null, "Cadastro de cliente com sucesso!");
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao cadastrar cliente /n Erro: " + ex);
        }

        conecta.desconecta();
    }
    
    //metodo para buscar qual eh o ultimo codigo, para deixar o cod_cliente incremental
    public int buscaLastCodigo() {
        conecta.conecta();
        conecta.executarSql("select cod_cliente from cliente");
        try {
            conecta.rs.last();
            int resultado = conecta.rs.getInt("cod_cliente");
            return resultado;
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return 0;
    }

    //select através do nome
    public Cliente pesquisarPorNome(Cliente cli) {
        conecta.conecta();
        conecta.executarSql("select * from cliente WHERE nome_cliente = '" + cli.getNome() + "'");
        try {
            conecta.rs.first();
            cliente.SetCodigo(conecta.rs.getInt("cod_cliente"));
            cliente.SetNome(conecta.rs.getString("nome_cliente"));
            cliente.SetRua(conecta.rs.getString("end_rua"));
            cliente.SetNum(conecta.rs.getInt("end_numero"));
            cliente.SetCidade(conecta.rs.getString("end_cidade"));
            cliente.SetEstado(conecta.rs.getString("end_estado"));
            cliente.SetCpf(conecta.rs.getInt("cpf_cliente"));
            cliente.SetRg(conecta.rs.getInt("rg_cliente"));
            cliente.SetEmail(conecta.rs.getString("email_cliente"));
            cliente.SetSenha(conecta.rs.getString("senha_cliente"));

            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    //select atraves do cpf
    public Cliente pesquisarPorCpf(Cliente cli) {
        conecta.conecta();
        String cpf = String.valueOf(cli.getCpf());
        conecta.executarSql("select * from cliente WHERE cpf_cliente =" + cpf + "");
        try {
            conecta.rs.first();
            cliente.SetCodigo(conecta.rs.getInt("cod_cliente"));
            cliente.SetNome(conecta.rs.getString("nome_cliente"));
            cliente.SetRua(conecta.rs.getString("end_rua"));
            cliente.SetNum(conecta.rs.getInt("end_numero"));
            cliente.SetCidade(conecta.rs.getString("end_cidade"));
            cliente.SetEstado(conecta.rs.getString("end_estado"));
            cliente.SetCpf(conecta.rs.getInt("cpf_cliente"));
            cliente.SetRg(conecta.rs.getInt("rg_cliente"));
            cliente.SetEmail(conecta.rs.getString("email_cliente"));
            cliente.SetSenha(conecta.rs.getString("senha_cliente"));

            return cliente;
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
        }

        return null;
    }
    
    //metodo que faz a edicao de cadastro de cliente
    public void editar(Cliente cli) {
        conecta.conecta();
        String cpf = String.valueOf(cli.getCpf());
       
        try {           
        
            PreparedStatement st = conecta.con.prepareStatement("UPDATE cliente set nome_cliente='" + cli.getNome() + "',end_rua= '" + cli.getRua() + "', end_numero =" + String.valueOf(cli.getNum()) + ", end_cidade = '"+cli.getCidade()+"', end_estado ='"+cli.getEstado()+ "', rg_cliente ="+String.valueOf(cli.getRg())+" , email_cliente ='"+cli.getEmail()+"' , senha_cliente = '"+cli.getSenha()+"' WHERE cpf_cliente = "+cpf+"");
            st.execute();

            JOptionPane.showMessageDialog(null, "Cadastro Editado com Sucesso"); 
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao editar cliente /n Erro: " + ex);
        }

        conecta.desconecta();
   
    }
    
    //metodo para excluir determinado cadastro a partir da busca pelo cpf
    public void excluir(Cliente cli) {
        conecta.conecta();
        String cpf = String.valueOf(cli.getCpf());
       conecta.conecta();
        try {           
        
            PreparedStatement st = conecta.con.prepareStatement("DELETE FROM cliente where cpf_cliente ="+cpf+"");
            st.execute();

            JOptionPane.showMessageDialog(null, "Cadastro Excluido com Sucesso"); 
        } catch (SQLException ex) {
            Logger.getLogger(BD_Cliente.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(null, "Erro ao excluir cliente /n Erro: " + ex);
        }

        conecta.desconecta();
              
    }
        
}
