/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.professor;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;
import modelo.Materia;
import modelo.Matricula;


public class AulaChamada extends HttpServlet {
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;
    ArrayList<Aluno> alunos = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        String idMateria = (String)req.getParameter("m");
        Materia materia = em.find(Materia.class, Integer.valueOf(idMateria));
        query = em.createQuery("SELECT m FROM MATRICULA m WHERE id_materia='"+idMateria+"'",Matricula.class);
        List<Matricula> matriculados = query.getResultList();
        for(Matricula m:matriculados){
            alunos.add(m.getAluno());
        }
        
        req.setAttribute("materia", materia);
        req.setAttribute("alunos", alunos);
        sc.getRequestDispatcher("/dinamico/jsp/professor/aulaChamada.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }


}
