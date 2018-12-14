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
import modelo.Matricula;
import modelo.Presenca;


public class ChamadaConcluida extends HttpServlet {

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
        String idAula = (String)req.getParameter("idAula");
        String idMateria = (String)req.getParameter("idMateria");
        query = em.createQuery("SELECT m FROM MATRICULA m WHERE id_materia='"+idMateria+"'",Matricula.class);
        List<Matricula> matriculados = query.getResultList();
        for(Matricula m:matriculados){
            alunos.add(m.getAluno());
        }
        Aula aula = em.find(Aula.class, Integer.valueOf(idAula));
        em.getTransaction().begin();
        for(Aluno a:alunos){
            String idAluno = (String)req.getParameter(String.valueOf(a.getId()));
            
            Aluno aluno = em.find(Aluno.class, Integer.valueOf(idAluno));
            String pres = "";
            if(idAluno.equals("1")){
                pres = "presente";
            }else{
                pres = "ausente";
            }
            Presenca presenca = new Presenca();
            presenca.setAula(aula);
            presenca.setAluno(aluno);
            presenca.setPresenca(pres);
            
            em.persist(presenca);
            em.getTransaction().commit();
            em.clear();          
            em.getTransaction().begin();
            
            
        }
        req.setAttribute("aula", aula);
        em.getTransaction().commit();
        em.close();
        emf.close();
        sc.getRequestDispatcher("/dinamico/jsp/professor/chamadaConcluida.jsp").forward(req, res);
    }
    
}
