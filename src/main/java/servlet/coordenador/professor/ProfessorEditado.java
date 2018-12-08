/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador.professor;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Professor;

public class ProfessorEditado extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
       
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        String nome = req.getParameter("nome");
        String dataInicio = req.getParameter("dataInicio");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        Integer id = Integer.valueOf(req.getParameter("id"));
        
        Professor p = em.find(Professor.class, id);
        em.getTransaction().begin();
        p.setNome(nome);
        p.setData_inicio(dataInicio);
        p.setLogin(login);
        p.setSenha(senha);
        req.setAttribute("professor", p);
        em.getTransaction().commit();
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/professorEditado.jsp").forward(req, res);
    }

}
