/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao_bd;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import tipos.*;
/**
 *
 * @author Bernardes
 */
public class BD_Gerente {
    Gerente gerente = new Gerente();
    Conexao conecta = new Conexao();
    
    //metodo para verificar usuario (cod_gerente), na qual seria a matricula quando
    //um funcionario eh contratado, juntamente com a sua senha previamente cadastrados no banco de dados
    public boolean verificaGerente(Gerente ge){
        conecta.conecta();
        String codigo = Integer.toString(ge.getCodigo());
        conecta.executarSql("select cod_gerente, senha_gerente FROM gerente_conta WHERE cod_gerente ="+codigo);
        try {
            conecta.rs.first();
            int compara1 = conecta.rs.getInt("cod_gerente");
            String compara2 = conecta.rs.getString("senha_gerente");
            
            if ((compara1==ge.getCodigo()) && (compara2.equals(ge.getSenha()))) return true;
            else return false;
            
            
        } catch (SQLException ex) {
            Logger.getLogger(BD_Gerente.class.getName()).log(Level.SEVERE, null, ex);
            
        }
 
        return false;
    }
    
}
