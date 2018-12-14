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
import modelo.Materia;

public class ConfirmarMatricula extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em = emf.createEntityManager();
    Query query;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        HttpSession sessao = req.getSession();
        String mats = (String) req.getParameter("materiasEscolhidas");
        System.out.println(mats);
        String[] mts = mats.split(",");
        ArrayList<Materia> materiasEscolhidas = new ArrayList<Materia>();
        Aluno a = (Aluno)sessao.getAttribute("usuario");
        sc = req.getServletContext();
        query = em.createQuery("SELECT m FROM MATERIA m",Materia.class);
        List<Materia> materias = query.getResultList();
        for(String m:mts){
            System.out.println(m);
            if(m.length()>1){
                for(Materia materia:materias){
                    if(materia.getCodigo().equals(m)){
                        materiasEscolhidas.add(materia);
                    }
                }
            }
        }
        sessao.setAttribute("materiasEscolhidas", materiasEscolhidas);
        req.setAttribute("materiasEscolhidas", materiasEscolhidas);
        sc.getRequestDispatcher("/dinamico/jsp/aluno/confirmarMatricula.jsp").forward(req, res);
    }


}
