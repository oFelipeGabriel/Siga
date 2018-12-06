/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador.aluno;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.base.Login;

/**
 *
 * @author felipe
 */
public class CadastrarAluno extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
       ServletContext sc = req.getServletContext();
        try {
            sc.getRequestDispatcher("/dinamico/jsp/coordenador/cadastrarAluno.jsp").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(CadastrarAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
