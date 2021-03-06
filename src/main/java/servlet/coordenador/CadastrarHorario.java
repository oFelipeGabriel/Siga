/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador;

import java.io.IOException;
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
import modelo.Materia;


public class CadastrarHorario extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
         sc = req.getServletContext();
         String semestre = req.getParameter("s");
         query = em.createQuery("SELECT m FROM MATERIA m WHERE m.semestreCurso='"+semestre+"'", Materia.class);
         List<Materia> materias = query.getResultList();
         req.setAttribute("materias", materias);
         req.setAttribute("semestre", semestre);
         sc.getRequestDispatcher("/dinamico/jsp/coordenador/cadastrarHorario.jsp").forward(req, res);
    }

    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }


}
