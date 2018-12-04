/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.professor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import servlet.aluno.Notas;

/**
 *
 * @author Aluno
 */
public class chamada extends HttpServlet {

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        ServletContext sc = req.getServletContext();
        try {
            sc.getRequestDispatcher("/dinamico/jsp/professor/chamadaProfessor.jsp").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
