/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

public class Professor extends Usuario{
    private int RE;

    public Professor(int RE, String nome, String email, String login, String senha, String dataDeNascimento, Long cpf) {
        super(nome, email, login, senha, dataDeNascimento, cpf);
        this.RE = RE;
    }

    public Professor(int RE) {
        this.RE = RE;
    }

    public int getRE() {
        return RE;
    }

    public void setRE(int RE) {
        this.RE = RE;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
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
    
    
}
