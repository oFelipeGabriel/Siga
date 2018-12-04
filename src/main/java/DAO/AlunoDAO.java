
package DAO;

import java.sql.Connection;
import java.util.logging.Level;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;
import modelo.Aluno;

public class AlunoDAO {
    private Connection conexao;
    private boolean ok = false;
    public AlunoDAO (){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost/siga","root","");
        } catch (Exception ex) {
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        
    }
    public Aluno buscaPorUsuario(String usuario){
        Aluno aluno = null;
        int RA;
        String email;
        String login; 
        String s; 
        String dataDeNascimento; 
        String nome = null;
        Long cpf;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select ra, nome, login, senha, data_nasc, email, cpf from ALUNO where login = ?");
            comandoSQL.setString (1,usuario);
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            RA = rs.getInt(1); 
            nome = rs.getString(2);  
            login = rs.getString(3); 
            s = rs.getString(4); 
            dataDeNascimento = rs.getString(5);
            email = rs.getString(6);
            cpf = rs.getLong(7);
            //aluno = new Aluno(RA,nome,email,login,s,dataDeNascimento,cpf);
        }catch (SQLException ex){
            Logger.getLogger(AlunoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return aluno;
    }
    
}
