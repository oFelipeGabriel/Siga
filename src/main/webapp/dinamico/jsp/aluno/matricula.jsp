<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Professor" %>
<%@page import="modelo.Horario" %>
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
        int semestre = 0; 
        int dia = 1;%>
        <div class="corpo">
            <% for(Horario h:horarios){
                if(semestre==0){ 
                    semestre = 1; %>                    
                    <div class="divSemestre">
                     <h4>Semestre <%= h.getMateria().getSemestreCurso() %></h4><% }
                if(h.getMateria().getSemestreCurso()!=semestre){ %>
                    </div>
                    <div class="divSemestre">
                    <h4>Semestre <%= h.getMateria().getSemestreCurso() %></h4>
                    
                <% }
                 else{  
                        if(dia<2){ 
                            dia = h.getDiaSemana();
                            %>
                        <div class="divDiaSemana">
                        <%}
                        if(dia!=h.getDiaSemana()){
                            dia = h.getDiaSemana();%>
                            </div>
                            <div class="divDiaSemana">
                        <% } else { %>
                            <div class="materiaHorario">
                            <h5><%= h.getMateria().getNome() %></h5>
                            <h5><%= h.getMateria().getProfessor().getNome() %></h5>
                            </div>
                            <% } %> 
                            <% } } %>
                    </div>
                    </div></div>
    </body>
</html>