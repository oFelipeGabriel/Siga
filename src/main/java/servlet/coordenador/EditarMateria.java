
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
import modelo.Professor;

public class EditarMateria extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
       sc = req.getServletContext();
       query = em.createQuery("SELECT p FROM PROFESSOR p", Professor.class);
       List<Professor> professores = query.getResultList();
       req.setAttribute("professores", professores);
       Integer id = Integer.valueOf(req.getParameter("id"));
       Materia m = em.find(Materia.class,id);
       req.setAttribute("materia", m);
       sc.getRequestDispatcher("/dinamico/jsp/coordenador/editarMateria.jsp").forward(req, res);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }


}
