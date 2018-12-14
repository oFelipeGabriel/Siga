/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.aluno;

import java.io.IOException;
import java.util.ArrayList;
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
import modelo.Materia;
import modelo.Matricula;

public class HistoricoAluno extends HttpServlet {
    Query query,queryM;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    ArrayList<Materia> materiasF = new ArrayList<>();
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
       
       ServletContext sc = req.getServletContext();
       HttpSession sessao = req.getSession();
       Aluno a = (Aluno)sessao.getAttribute("usuario");
       
       query = em.createQuery("SELECT m FROM MATRICULA m WHERE id_aluno='"+a.getId()+"' ORDER BY m.semestre ASC", Matricula.class);
       List<Matricula> materiasMatriculadas = query.getResultList();
       
       query = em.createQuery("SELECT m FROM MATERIA m", Materia.class);
       List<Materia> materias = query.getResultList();
       for(Materia m:materias){
           boolean f = false;
           for(Materia mt:materiasF){
               if(mt.getNome().equals(m.getNome())){
                   f = true;
               }
           }
           if(!f){
               materiasF.add(m);
           }
       }
       req.setAttribute("materias", materiasF);
       req.setAttribute("matriculas", materiasMatriculadas);
       req.setAttribute("aluno", a);
       
        try {
            sc.getRequestDispatcher("/dinamico/jsp/aluno/historico.jsp").forward(req, res);
        } catch (ServletException ex) {
            Logger.getLogger(HistoricoAluno.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(HistoricoAluno.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
