/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.coordenador.aluno;

import java.io.IOException;
import java.io.PrintWriter;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Aluno;

public class AlunoEditado extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    
    protected void processRequest(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {}

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        String id = req.getParameter("id");
        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String cpf = req.getParameter("cpf");
        String data_nasc = req.getParameter("data_nasc");
        String data_form = req.getParameter("data_farm");
        String login = req.getParameter("login");
        String senha = req.getParameter("senha");
        
        Aluno aluno = em.find(Aluno.class, Integer.valueOf(id));
        em.getTransaction().begin();
        aluno.setNome(nome);
        aluno.setEmail(email);
        aluno.setCpf(Long.valueOf(cpf));
        aluno.setData_nasc(data_nasc);
        aluno.setData_formatura(data_form);
        aluno.setLogin(login);
        aluno.setSenha(senha);
        req.setAttribute("aluno", aluno);
        em.getTransaction().commit();        
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/alunoEditado.jsp").forward(req, res);
    }

}
