/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador.aluno;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;

public class EditarAluno extends HttpServlet {
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        String id = req.getParameter("id");
        Aluno aluno = em.find(Aluno.class, Integer.valueOf(id));
        req.setAttribute("aluno", aluno);
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/editarAluno.jsp").forward(req, res);
    }

}
