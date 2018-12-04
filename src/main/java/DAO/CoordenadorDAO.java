
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Coordenador;

public class CoordenadorDAO {
    
    private Connection conexao;    
    AcessoBD aBD = new AcessoBD();
    private boolean ok = false;
    private Coordenador c;
    public CoordenadorDAO (){
        try{
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost/siga",aBD.getUsuario(),aBD.getSenha());
        } catch (Exception ex) {
            Logger.getLogger(CoordenadorDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
    public Coordenador validarCoordenador (String usuario, String senha){
    int RE; 
    String login; 
    String s;
    String nome = null;
    c = null;
        try {
            PreparedStatement comandoSQL = conexao.prepareStatement("select id, nome, login, senha from COORDENADOR where login = ?");
            comandoSQL.setString (1,usuario);
            ResultSet rs = comandoSQL.executeQuery();
            rs.next();
            RE = rs.getInt(1); 
            nome = rs.getString(2);  
            login = rs.getString(3); 
            s = rs.getString(4);             
            if (s.equals(senha)){
                c = new Coordenador(RE, nome, login, senha); 
                ok = true;
            }      
        }catch (SQLException ex){
            Logger.getLogger(Coordenador.class.getName()).log(Level.SEVERE, null, ex);
        }
        return c;
    }
    
    public boolean ok (){
        return ok;
    }
    
}
