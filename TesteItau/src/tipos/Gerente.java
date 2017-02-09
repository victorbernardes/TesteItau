/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tipos;

/**
 *
 * @author Bernardes
 */
public class Gerente {
    
    //nessa classe estao todos os atributos, como um espelho do banco de dados
    //alem disso, possui todos os Gets and Sets 
      private int codigo;
      private String nome;
      private int cpf;
      private String senha;
      
      public int getCodigo(){
          return this.codigo;
      }
      
      public void SetCodigo (int codigo){
          this.codigo = codigo;
      }
      
      public String getNome(){
          return this.nome;
      }
      
      public void SetNome (String nome){
          this.nome = nome;
      }
      
        
      public int getCpf(){
          return this.cpf;
      }
      
      public void SetCpf (int cpf){
          this.cpf = cpf;
      }
      
            
      public String getSenha(){
          return this.senha;
      }
      
      public void SetSenha (String senha){
          this.senha = senha;
      }
      
}
