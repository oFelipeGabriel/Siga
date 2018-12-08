/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Materia;
import modelo.Professor;

public class MateriaCadastrada extends HttpServlet {
    
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
        String codigo = req.getParameter("codigo");
        String idProfessor = req.getParameter("idProfessor");
        String semestreCurso = req.getParameter("semestreCurso");
        String semestreAno = req.getParameter("semestreAno");
        String turma = req.getParameter("turma;");
        String aulaSemana = req.getParameter("aulasSemana");
        
        Professor professor = em.find(Professor.class, Integer.valueOf(idProfessor));
        Materia m = new Materia(nome,codigo,professor,Integer.valueOf(semestreCurso),
                Integer.valueOf(semestreCurso),turma,Integer.valueOf(aulaSemana));
        req.setAttribute("materia", m);
        
        em.getTransaction().begin();
        em.persist(m);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/materiaCadastrada.jsp").forward(req, res);
    }

}
