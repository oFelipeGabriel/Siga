/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador.aluno;

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
import modelo.Aluno;


public class AlunoCadastrado extends HttpServlet {
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    DateTimeFormatter dataAtualForm = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDateTime agora = LocalDateTime.now(); 
 
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        Aluno aluno = new Aluno();
        String nome = (String) req.getParameter("nome");
        String email = (String) req.getParameter("email");
        long cpf = (long) Long.valueOf(req.getParameter("cpf"));
        String data_nasc = (String) req.getParameter("data_nasc");
        String data_matricula = dataAtualForm.format(agora);
        String login = (String) req.getParameter("login");
        String senha = (String) req.getParameter("senha");
        
        aluno.setNome(nome);
        aluno.setCpf(cpf);
        aluno.setEmail(email);
        aluno.setData_nasc(data_nasc);
        aluno.setData_matricula(data_matricula);
        aluno.setMatriculado(1);
        aluno.setLogin(login);
        aluno.setSenha(senha);
        
        em.getTransaction().begin();
        em.persist(aluno);
        em.getTransaction().commit();
        
        em.close();
        emf.close();
     
        ServletContext sc = req.getServletContext();
        req.setAttribute("nome", nome);
        req.setAttribute("email", email);
        req.setAttribute("cpf", cpf);
        req.setAttribute("data_nasc", data_nasc);
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/alunoCadastrado.jsp").forward(req, res);
        
        
    }


}
