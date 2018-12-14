<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Professor" %>
<%@page import="modelo.Horario" %>
<%@page import="modelo.Aluno" %>
<%@page import="modelo.Matricula" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Siga - Matricula</title>
    </head>
    <body>
        <%@include file= "menu.jsp" %>
        <% List<Horario> horarios = (List<Horario>)request.getAttribute("horarios");
        List<Matricula> matriculas = (List<Matricula>)request.getAttribute("matricula");
        Aluno a = (Aluno)request.getAttribute("aluno");
        int semestre = 0;
        String classeApro = "materiaHorarioMat";
        String[] dias = {"Seguda-feira","Terça-feira","Quarta-feira","Quinta-feira","Sexta-feira"};
        int sem = 1;%>
        <div class="corpo">
                <form action="confirmarMatricula" method="POST">
                        <input type="text" id="materiasEscolhidas" name="materiasEscolhidas">
                        <input type="submit" value="Matricular">
                     </form>
            <div class="divSemestre">
                <h4>Semestre 1</h4>
                <% for(Horario h:horarios){
                    if(h.getMateria().getSemestreCurso()>sem){
                        sem = h.getMateria().getSemestreCurso();
                        %></div><div class="divSemestre">
                            <h4>Semestre <%= sem %></h4>
                         <%}
                    for(Matricula m:matriculas){
                        if(m.getMateria().getCodigo().equals(h.getMateria().getCodigo())){
                %><div class="materiaHorarioMat materiaAprovado">
                <%
                        }else{
                    %><div class="materiaHorarioMat <%= h.getMateria().getCodigo() %> <%= h.getDiaSemana() %><%= h.getHorario() %>" 
                    onclick="mostrarClasse('<%= h.getMateria().getCodigo() %>','<%= h.getMateria().getId() %>')"><%
                        }%>
                        <a>Materia: <%= h.getMateria().getNome() %></a><br>
                        <a>Professor: <%= h.getMateria().getProfessor().getNome() %></a><br>
                        <a><%= dias[h.getDiaSemana()-2] %></a><br>
                        <a><%= h.getHorario() %></a></div>
                    <% }
                }%>
                    </div>
                        </div>
                    
                    <script src="estatico/js/javascript.js">
                    </script>
                    
    </body>
    
</html>