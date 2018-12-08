
package servlet.coordenador;

import java.io.IOException;
import java.util.ArrayList;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Horario;
import modelo.Materia;


public class HorarioCadastrado extends HttpServlet {
    
    ServletContext sc;
    EntityManagerFactory emf = Persistence.createEntityManagerFactory("persistencia_simples");        
    EntityManager em;
    Integer semCurso;
    String ano;
    String semAno;
    String[] horarios = {"07:10-08:00","08:00-08:50","09:15-10:05","10:05-10:55","10:55-11:45","11:45-12:35"};

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res)
            throws ServletException, IOException {
        sc = req.getServletContext();
        ano = req.getParameter("ano");
        semAno = req.getParameter("sem");
        semCurso = Integer.valueOf(req.getParameter("semCurso"));
        ArrayList<String> materias = new ArrayList<String>();
        
        String seg1 = req.getParameter("seg-1");
        salvarHorario(seg1, 2, horarios[0]);
        String seg2 = req.getParameter("seg-2");
        salvarHorario(seg2, 2, horarios[1]);
        String seg3 = req.getParameter("seg-3");
        salvarHorario(seg3, 2, horarios[2]);
        String seg4 = req.getParameter("seg-4");
        salvarHorario(seg4, 2, horarios[3]);
        String seg5 = req.getParameter("seg-5");
        salvarHorario(seg5, 2, horarios[4]);
        String seg6 = req.getParameter("seg-6");
        salvarHorario(seg6, 2, horarios[5]);
        
        String ter1 = req.getParameter("ter-1");
        salvarHorario(ter1, 3, horarios[0]);
        String ter2 = req.getParameter("ter-2");
        salvarHorario(ter2, 3, horarios[1]);
        String ter3 = req.getParameter("ter-3");
        salvarHorario(ter3, 3, horarios[2]);
        String ter4 = req.getParameter("ter-4");
        salvarHorario(ter4, 3, horarios[3]);
        String ter5 = req.getParameter("ter-5");
        salvarHorario(ter5, 3, horarios[4]);
        String ter6 = req.getParameter("ter-6");
        salvarHorario(ter6, 3, horarios[5]);
        
        String qua1 = req.getParameter("qua-1");
        salvarHorario(qua1, 4, horarios[0]);
        String qua2 = req.getParameter("qua-2");
        salvarHorario(qua2, 4, horarios[1]);
        String qua3 = req.getParameter("qua-3");
        salvarHorario(qua3, 4, horarios[2]);
        String qua4 = req.getParameter("qua-4");
        salvarHorario(qua4, 4, horarios[3]);
        String qua5 = req.getParameter("qua-5");
        salvarHorario(qua5, 4, horarios[4]);
        String qua6 = req.getParameter("qua-6");
        salvarHorario(qua6, 4, horarios[5]);
        
        String qui1 = req.getParameter("qui-1");
        salvarHorario(qui1, 5, horarios[0]);
        String qui2 = req.getParameter("qui-2");
        salvarHorario(qui2, 5, horarios[1]);
        String qui3 = req.getParameter("qui-3");
        salvarHorario(qui3, 5, horarios[2]);
        String qui4 = req.getParameter("qui-4");
        salvarHorario(qui4, 5, horarios[3]);
        String qui5 = req.getParameter("qui-5");
        salvarHorario(qui5, 5, horarios[4]);
        String qui6 = req.getParameter("qui-6");
        salvarHorario(qui6, 5, horarios[5]);
        /*
        String sex1 = req.getParameter("sex-1");
        salvarHorario(em, sex1, 6, horarios[0]);
        String sex2 = req.getParameter("sex-2");
        salvarHorario(em, sex2, 6, horarios[1]);
        String sex3 = req.getParameter("sex-3");
        salvarHorario(em, sex3, 6, horarios[2]);
        String sex4 = req.getParameter("sex-4");
        salvarHorario(em, sex4, 6, horarios[3]);
        String sex5 = req.getParameter("sex-5");
        salvarHorario(em, sex5, 6, horarios[4]);
        String sex6 = req.getParameter("sex-6");
        salvarHorario(em, sex6, 6, horarios[5]);
        */
        em.close();
        emf.close();
        sc.getRequestDispatcher("/dinamico/jsp/coordenador/horarioCadastrado.jsp").forward(req, res);
    }
    public void salvarHorario(String idMateria,int dia,String horario){
        Integer id = Integer.parseInt(idMateria);
        
        if(id>0){
            this.em = emf.createEntityManager();
            Materia m = this.em.find(Materia.class, id);
            Horario h = new Horario();
            h.setDiaSemana(dia);
            h.setHorario(horario);
            h.setMateria(m);
            h.setSemestre(semCurso);
            h.setSemestreAno(Integer.valueOf(ano+semAno));
            
            this.em.getTransaction().begin();
            this.em.persist(h);
            this.em.getTransaction().commit();            
            this.em.close();
        }
    }

}
