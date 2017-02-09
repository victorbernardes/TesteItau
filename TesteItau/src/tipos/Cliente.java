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
public class Cliente {
    
    //nessa classe estao todos os atributos, como um espelho do banco de dados
    //alem disso, possui todos os Gets and Sets 
    private int codigo;
      private String nome;
      private String rua;
      private int num;
      private String cidade;
      private String estado;
      private int cpf;
      private int rg;
      private String email;
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
      
      public String getRua(){
          return this.rua;
      }
      
      public void SetRua (String rua){
          this.rua = rua;
      }
      
      public int getNum(){
          return this.num;
      }
      
      public void SetNum (int num){
          this.num = num;
      }
      
      public String getCidade(){
          return this.cidade;
      }
      
      public void SetCidade (String cidade){
          this.cidade = cidade;
      }
      
       public String getEstado(){
          return this.estado;
      }
      
      public void SetEstado (String estado){
          this.estado = estado;
      }
      
      public int getCpf(){
          return this.cpf;
      }
      
      public void SetCpf (int cpf){
          this.cpf = cpf;
      }
      
      public int getRg(){
          return this.rg;
      }
      
      public void SetRg (int rg){
          this.rg = rg;
      }
      
      public String getEmail(){
          return this.email;
      }
      
      public void SetEmail (String email){
          this.email = email;
      }
      
      public String getSenha(){
          return this.senha;
      }
      
      public void SetSenha (String senha){
          this.senha = senha;
      }
}
