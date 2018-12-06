/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.base;

import java.io.IOException;
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
import modelo.Coordenador;
import modelo.Professor;

/**
 *
 * @author Aluno
 */
//@WebServlet(name = "Inicio", urlPatterns = {"/Inicio"})
public class Inicio extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        HttpSession sessao = req.getSession();
        sc = req.getServletContext();
        
        if(sessao.getAttribute("usuario")==null){
        //Verifica Aluno
        query = em.createQuery("SELECT a FROM ALUNO a WHERE a.login='"+usuario+"' and a.senha='"+senha+"'", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        for(Aluno a:alunos){
                req.setAttribute("usuario", a);
                sessao.setAttribute("usuario", a);
                sessao.setAttribute("tipo", "1");
                inicioAluno(req,res);
            
        }
        
        // Verifica Professor 
        query = em.createQuery("SELECT p FROM PROFESSOR p WHERE p.login='"+usuario+"' and p.senha='"+senha+"'", Professor.class);
        List<Professor> professores = query.getResultList();
        if(professores.size()>0){
        for(Professor p:professores){
                req.setAttribute("usuario", p);
                sessao.setAttribute("usuario", p);
                sessao.setAttribute("tipo", "2");
               inicioProfessor(req,res);
            
        }
        }
        
        //Verifica Coordenador
        query = em.createQuery("SELECT c FROM COORDENADOR c WHERE c.login='"+usuario+"' and c.senha='"+senha+"'", Coordenador.class);
        List<Coordenador> coordenadores = query.getResultList();
        if(coordenadores.size()>0){
        for(Coordenador c:coordenadores){
                req.setAttribute("usuario", c);
                sessao.setAttribute("usuario", c);
                sessao.setAttribute("tipo", "3");
                inicioCoordenador(req,res);
            
        }
            }else{
                req.setAttribute("FalhouLogin", "sim");
                voltarLogin(req,res);
            }
        }else{
            Integer t = Integer.parseInt((String)sessao.getAttribute("tipo"));
        switch(t){
            case 1: inicioAluno(req,res);break;
            case 2: inicioProfessor(req,res);break;
            case 3: inicioCoordenador(req,res);
        }
            
    }
}
    public void voltarLogin(HttpServletRequest req, HttpServletResponse res){
        try {
                    sc.getRequestDispatcher("/dinamico/jsp/login.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
    }
    public void inicioAluno(HttpServletRequest req, HttpServletResponse res){
        try{
            sc.getRequestDispatcher("/dinamico/jsp/aluno/inicio.jsp").forward(req, res);
         } catch (ServletException ex) {
             Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void inicioProfessor(HttpServletRequest req, HttpServletResponse res){
         try{
            sc.getRequestDispatcher("/dinamico/jsp/professor/inicioProfessor.jsp").forward(req, res);
         } catch (ServletException ex) {
             Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    public void inicioCoordenador(HttpServletRequest req, HttpServletResponse res){
        try{
            sc.getRequestDispatcher("/dinamico/jsp/coordenador/inicioCoordenador.jsp").forward(req, res);
         } catch (ServletException ex) {
             Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IOException ex) {
             Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        ServletContext sc = req.getServletContext();
        HttpSession sessao = req.getSession();
        if(sessao.getAttribute("usuario")==null){
        try {
                sc.getRequestDispatcher("/dinamico/jsp/login.jsp").forward(req, res);
            } catch (ServletException ex) {
                Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else{
            Integer t = Integer.parseInt((String)sessao.getAttribute("tipo"));
            switch(t){
                case 1:inicioAluno(req,res);break;
                case 2:inicioProfessor(req,res);break;
                case 3:inicioCoordenador(req,res);break;
            }
            
        }
    }
    

}
