package modelo;

import java.sql.Connection;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Usuario {
    String nome, email, login, senha;
    String dataDeNascimento;
    Long cpf;
    

    private Connection conexao;

    public Usuario(String nome, String email, String login, String senha, String dataDeNascimento, Long cpf) {
        this.nome = nome;
        this.email = email;
        this.login = login;
        this.senha = senha;
        this.dataDeNascimento = dataDeNascimento;
        this.cpf = cpf;
    }
    
    public Usuario(){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Usuario.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }  
    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public Long getCpf() {
        return cpf;
    }

    public void setCpf(Long cpf) {
        this.cpf = cpf;
    }
    
}
