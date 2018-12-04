package modelo;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="ALUNO")
public class Aluno {    
    @Id   
    private  int id;
    @Column(name="nome")
    private  String nome;
    @Column(name="email")
    private String email;
    @Column(name="cpf")
    private long cpf;
    @Column(name="data_nasc")
    private String data_nasc;
    @Column(name="data_matricula")
    private String data_matricula;
    @Column(name="data_formatura")
    private String data_formatura;
    @Column(name="matriculado")
    private int matriculado;
    @Column(name="login")
    private String login;
    @Column(name="senha")
    private String senha;
    
    public Aluno(){}
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public long getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }  

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public long getCpf() {
        return cpf;
    }

    public void setCpf(long cpf) {
        this.cpf = cpf;
    }

    public String getData_nasc() {
        return data_nasc;
    }

    public void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc;
    }

    public String getData_matricula() {
        return data_matricula;
    }

    public void setData_matricula(String data_matricula) {
        this.data_matricula = data_matricula;
    }

    public String getData_formatura() {
        return data_formatura;
    }

    public void setData_formatura(String data_formatura) {
        this.data_formatura = data_formatura;
    }

    public int getMatriculado() {
        return matriculado;
    }

    public void setMatriculado(int matriculado) {
        this.matriculado = matriculado;
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
    
}