/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Aluno;
import modelo.Professor;

/**
 *
 * @author Aluno
 */
public class ProfessorDAO {
    private Connection conexao;
    private boolean ok = false;
    private Professor p;
    public ProfessorDAO (){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost/siga","root","");
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public Professor validarProfessor (String usuario, String senha){
    int RE; 
    String login; 
    String s; 
    String dataDeNascimento; 
    String nome = null;
    String email;
    Long cpf;
    p = null;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select RE, nome, login, senha, email, cpf  from professor where login = ?");
            comandoSQL.setString (1,usuario);
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            RE = rs.getInt(1); 
            nome = rs.getString(2);  
            login = rs.getString(3); 
            s = rs.getString(4); 
            dataDeNascimento = "000";
            email = rs.getString(5);
            cpf = rs.getLong(6);
            if (s.equals(senha)){
                p = new Professor(RE, nome, email, login, senha, dataDeNascimento, cpf); 
                ok = true;
            }      
        }catch (SQLException ex){
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return p;
    }
    
    public boolean ok (){
        return ok;
    }
}
