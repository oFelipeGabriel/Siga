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


public class MateriaEditada extends HttpServlet {

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
        Integer idProfessor = Integer.valueOf(req.getParameter("professor"));
        String semestreCurso = req.getParameter("semestreCurso");
        String semestreAno = req.getParameter("semestreAno");
        String turma = req.getParameter("turma");
        String aulasSemana = req.getParameter("aulasSemana");
        Integer id = Integer.valueOf(req.getParameter("id"));
        
        Professor professor = em.find(Professor.class, idProfessor);
        Materia materia = em.find(Materia.class, id);
        em.getTransaction().begin();
        materia.setNome(nome);
        materia.setCodigo(codigo);
        materia.setProfessor(professor);
        materia.setSemestreCurso(Integer.valueOf(semestreCurso));
        materia.setSemestreAno(Integer.valueOf(semestreAno));
        materia.setTurma(turma);
        materia.setAulasSemana(Integer.valueOf(aulasSemana));
        req.setAttribute("materia", materia);
        em.getTransaction().commit();        
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/materiaEditada.jsp").forward(req, res);
    }


}
