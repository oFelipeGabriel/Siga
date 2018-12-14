/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.professor;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import modelo.Materia;
import modelo.Professor;
import servlet.aluno.Notas;

/**
 *
 * @author Aluno
 */
public class Chamada extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;

        @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        sc = req.getServletContext();
        HttpSession sessao = req.getSession();
        Professor professor = (Professor)sessao.getAttribute("usuario");
        query = em.createQuery("SELECT m FROM MATERIA m WHERE id_professor='"+String.valueOf(professor.getId())+"'",Materia.class);
        List<Materia> m = query.getResultList();
        
        req.setAttribute("materias", m);
        try {
            sc.getRequestDispatcher("/dinamico/jsp/professor/chamadaProfessor.jsp").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Notas.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
