/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Professor;

/**
 *
 * @author felipe
 */
public class ProfessorCadastrado extends HttpServlet {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    DateTimeFormatter dataAtualForm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime agora = LocalDateTime.now(); 
 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Professor professor = new Professor();
        String nome = (String) req.getParameter("nome");
        String email = (String) req.getParameter("email");
        String data_inicio = dataAtualForm.format(agora);
        String login = (String) req.getParameter("login");
        String senha = (String) req.getParameter("senha");
        
        professor.setNome(nome);
        professor.setData_inicio(data_inicio);
        professor.setLogin(login);
        professor.setSenha(senha);
        professor.setContratado(1);
        
        em.getTransaction().begin();
        em.persist(professor);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
     
        ServletContext sc = req.getServletContext();
        req.setAttribute("nome", nome);
        req.setAttribute("login", login);
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/alunoCadastrado.jsp").forward(req, res);
        
        
    }


}
