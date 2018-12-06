
package servlet.coordenador.aluno;

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
import modelo.Aluno;

public class VerAlunos extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        query = em.createQuery("SELECT a FROM ALUNO a", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        req.setAttribute("alunos", alunos);
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/verAlunos.jsp").forward(req, res);
        
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

}
