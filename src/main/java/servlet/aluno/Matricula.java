/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.aluno;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Matricula extends HttpServlet {
    private Connection conexao;
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        res.setContentType("text/html;charset=UTF-8");
        try{
            
            Class.forName("org.mariadb.jdbc.Driver");
            conexao = DriverManager.getConnection("jdbc:mariadb://localhost/siga","felipe","felipe");
        } catch (Exception ex) {
            Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
            }
        try {
            PrintWriter saida;
            saida = res.getWriter();
            String dia = null;
            int numDia = 0;
            PreparedStatement comandoSQL = conexao.prepareStatement("SELECT h.dia_semana,h.horario, m.nome, p.nome FROM HORARIO h, MATERIA m, PROFESSOR p WHERE h.id_materia=m.id and p.re=m.re_professor and m.turma='A';");
            ResultSet rs = comandoSQL.executeQuery();
            req.getRequestDispatcher("/dinamico/jsp/aluno/matricula.jsp").include(req, res);
            req.getRequestDispatcher("/dinamico/jsp/aluno/menu.jsp").include(req, res);
            saida.println("<div class='corpo'>");
            while(rs.next()){
                if(rs.getInt(1)!=numDia){
                    if(numDia>2){saida.println("</div>");}
                if(rs.getInt(1)==2){dia = "Segunda-Feira";}
                if(rs.getInt(1)==3){dia = "Terça-Feira";}
                if(rs.getInt(1)==4){dia = "Quarta-Feira";}
                if(rs.getInt(1)==5){dia = "Quinta-Feira";}
                if(rs.getInt(1)==6){dia = "Sexta-Feira";}
                saida.println("<div class='divDiaHorarios'><h4>"+dia+"</h4><br>");
                }
                saida.println("<div class='materiaHorario'>");
                saida.println(rs.getString(2)+"<br>");
                saida.println(rs.getString(3)+"<br>");
                saida.println(rs.getString(4)+"<br>");
                saida.println("</div>");
                numDia = rs.getInt(1);
            }
            saida.println("</div><!-- div DiaHorarios --></div></body>");
            saida.println("</html>");
        } catch (SQLException ex) {
            Logger.getLogger(Matricula.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
