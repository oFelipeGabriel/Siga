/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlet.base;

import DAO.AlunoServicoDAO;
import DAO.CoordenadorDAO;
import DAO.ProfessorDAO;
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
    Aluno a = null;
    AlunoServicoDAO adao = new AlunoServicoDAO();
    Professor p = null;
    Coordenador c = null;
    ProfessorDAO pdao = new ProfessorDAO();
    CoordenadorDAO cdao = new CoordenadorDAO();
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    
    
    
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res){
        String usuario = req.getParameter("usuario");
        String senha = req.getParameter("senha");
        HttpSession sessao = req.getSession();
        //p = pdao.validarProfessor(usuario, senha);
        //a = adao.validarAluno(usuario, senha);
         /*
        Query query = em.createQuery("SELECT u FROM usuario u "); // WHERE u.nome='João' ");
        List<Usuario> usuarios = query.getResultList();
        System.out.println("Resultados: ");
        for(Usuario ui: usuarios){
            System.out.println("Nome: " + ui.getNome() + " Id: " + ui.getId() );
        } 
        */
        c = cdao.validarCoordenador(usuario, senha);
        sc = req.getServletContext();
        //id,nome,email,cpf,data_nasc,data_matricula,data_formatura,matriculado,login,senha
        Query query = em.createQuery("SELECT a FROM ALUNO a WHERE a.login='"+usuario+"' and a.senha='"+senha+"'", Aluno.class);
        List<Aluno> alunos = query.getResultList();
        for(Aluno a:alunos){
                req.setAttribute("usuario", a);
                try{
                   sc.getRequestDispatcher("/dinamico/jsp/aluno/inicio.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            
        }
        
        // Verifica Aluno DAO
        /*if((a!=null)){
            if (adao.ok()!=false){
                HttpSession sessao = req.getSession();
                sessao.setAttribute("usuario", a.getNome());
                req.setAttribute("usuario", a);

                try{
                   sc.getRequestDispatcher("/dinamico/jsp/aluno/inicio.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            else{            
                try {
                    sc.getRequestDispatcher("/dinamico/jsp/login.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        } */
        // Verifica Professor DAO
        /*if(p!=null){
            if(p.getNome()!=null){
            if (pdao.ok()!=false){
                req.setAttribute("usuario", p.getNome());
                req.setAttribute("RE", p.getRE());
                req.setAttribute("dataDeNascimento", p.getDataDeNascimento());

                try{
                   sc.getRequestDispatcher("/dinamico/jsp/professor/inicioProfessor.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            else{            
                try {
                    sc.getRequestDispatcher("/dinamico/jsp/login.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
        } 
        }*/
        /*
        if(c!=null || sessao.getAttribute("usuario")==null){
            if(c.getNome()!=null){
            if (cdao.ok()!=false){
                sessao.setAttribute("usuario", c.getNome());
                req.setAttribute("usuario", c.getNome());
                req.setAttribute("id", c.getRe());

                try{
                   sc.getRequestDispatcher("/dinamico/jsp/coordenador/inicioCoordenador.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } 
            }
            else{            
                try {
                    sc.getRequestDispatcher("/dinamico/jsp/login.jsp").forward(req, res);
                } catch (ServletException ex) {
                    Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IOException ex) {
                    Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        
        
        } 
        
        }
        
            else{
            req.setAttribute("FalhouLogin", "sim");
            try {
                sc.getRequestDispatcher("/dinamico/jsp/login.jsp").forward(req, res);
            } catch (ServletException ex) {
                Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
        }*/
    }
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res){
        sc = req.getServletContext();
        try {
                sc.getRequestDispatcher("/dinamico/jsp/login.jsp").forward(req, res);
            } catch (ServletException ex) {
                Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(servlet.base.Inicio.class.getName()).log(Level.SEVERE, null, ex);
            }
    }
}
