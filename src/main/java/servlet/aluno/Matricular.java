/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.aluno;

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
import modelo.Aluno;
import modelo.Horario;
import modelo.Matricula;

public class Matricular extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;
    
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession sessao = req.getSession();
        Aluno a = (Aluno)sessao.getAttribute("usuario");
        sc = req.getServletContext();
        query = em.createQuery("SELECT h FROM HORARIO h ORDER BY h.semestre ASC, h.diaSemana ASC, h.horario ASC", Horario.class);
        List<Horario> horarios = query.getResultList();
        query = em.createQuery("SELECT m FROM MATRICULA m WHERE id_aluno='"+String.valueOf(a.getId())+"'",Matricula.class);
        List<Matricular> m = query.getResultList();
        
        req.setAttribute("horarios", horarios);
        req.setAttribute("aluno", a);
        req.setAttribute("matricula", m);
        
        try {
            sc.getRequestDispatcher("/dinamico/jsp/aluno/matricula.jsp").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(Matricular.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Matricular.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }

}
