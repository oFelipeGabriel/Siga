/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.aluno;

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
import javax.servlet.http.HttpSession;
import modelo.Aluno;
import modelo.Horario;
import modelo.Materia;
import modelo.Matricula;


public class MatriculaConfirmada extends HttpServlet {

    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    ServletContext sc;
    Query query;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession sessao = req.getSession();
        sc = req.getServletContext();
        
        Aluno aluno = (Aluno)sessao.getAttribute("usuario");
        ArrayList<Materia> materiasEscolhidas = (ArrayList<Materia>)sessao.getAttribute("materiasEscolhidas");
        ArrayList<Horario> horarios = new ArrayList<>();
        
        em.getTransaction().begin();
        for(Materia m:materiasEscolhidas){
            
            Matricula matricula = new Matricula();
            query = em.createQuery("SELECT h FROM HORARIO h WHERE id_materia='"+String.valueOf(m.getId())+"' ORDER BY h.diaSemana ASC, h.horario ASC");
            List<Horario> horario = query.getResultList();
            for(Horario h:horario){
                horarios.add(h);
            }
            matricula.setAluno(aluno);
            matricula.setMateria(m);
            matricula.setSemestre("201802");
            
            em.persist(matricula);
            em.getTransaction().commit();
            em.clear();          
            em.getTransaction().begin();
            
        }
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        req.setAttribute("horarios", horarios);
        sc.getRequestDispatcher("/dinamico/jsp/aluno/matriculaConfirmada.jsp").forward(req, res);
    }
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }


}
