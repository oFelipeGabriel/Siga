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
import modelo.Horario;


public class Horarios extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        String semestreAno;
        if(req.getParameterMap().containsKey("sAno")){
            semestreAno = req.getParameter("sAno");
        }else{
            semestreAno = "201802";
        }
        query = em.createQuery("SELECT h FROM HORARIO h WHERE h.semestreAno='"+semestreAno+"' ORDER BY h.semestre, h.diaSemana, h.horario", Horario.class);
        List<Horario> horarios = query.getResultList();
        
        req.setAttribute("horarios", horarios);
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/horarios.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }

}
