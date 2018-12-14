/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.professor;

import java.io.IOException;
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
import modelo.Aula;
import modelo.Materia;
import modelo.Matricula;


public class ChamadaOnline extends HttpServlet {

    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    ArrayList<Aluno> alunos = new ArrayList<>();
    Query query;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        String data = (String)req.getParameter("data");
        String titulo = (String)req.getParameter("titulo");
        String idMateria = (String)req.getParameter("idMateria");
        
        Aula aula = new Aula();
        aula.setData(data);
        aula.setTitulo(titulo);
        Materia materia = em.find(Materia.class, Integer.valueOf(idMateria));
        aula.setMateria(materia);
        
        em.getTransaction().begin();
        em.persist(aula);
        em.getTransaction().commit();
        int id = aula.getId();
        
        
        query = em.createQuery("SELECT m FROM MATRICULA m WHERE id_materia='"+idMateria+"'",Matricula.class);
        List<Matricula> matriculados = query.getResultList();
        for(Matricula m:matriculados){
            alunos.add(m.getAluno());
        }
        req.setAttribute("idAula", id);
        req.setAttribute("data", data);
        req.setAttribute("titulo", titulo);
        req.setAttribute("materia", materia);
        req.setAttribute("alunos", alunos);
        
        em.close();
        emf.close();
        
        sc.getRequestDispatcher("/dinamico/jsp/professor/chamadaOnline.jsp").forward(req, res);
    }

}
