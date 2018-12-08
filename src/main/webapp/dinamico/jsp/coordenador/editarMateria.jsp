
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Professor"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Editar Materia</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        <div class="corpo">
        <% Materia m = (Materia)request.getAttribute("materia"); 
        List<Professor> professores = (List<Professor>)request.getAttribute("professores");%>
        <form action="materiaEditada" method="POST">
            Nome: <input name="nome" value="<%= m.getNome() %>"><br/>
            Codigo: <input name="codigo" value="<%= m.getCodigo() %>"><br/>
            Professor: 
            <select name="professor">
                <% for(Professor p:professores){
                    if(p.getNome().equals(m.getProfessor().getNome())){ %>
                    <option value="<%= p.getId() %>" selected><%= p.getNome() %></option>
                    <%} else{ %>
                    <option value="<%= p.getId() %>"><%= p.getNome() %></option>
                     <% }
                } %>
            </select><br/>
            Semestre (Curso): <input name="semestreCurso" value="<%= m.getSemestreCurso() %>"><br/>
            Semestre (Ano): <input type="text" name="semestreAno" value="<%= m.getSemestreAno() %>"><br/>
            Turma: <input name="turma" value="<%= m.getTurma() %>"><br/>
            Quantidade de aulas por semana: <input name="aulasSemana" type="text" value="<%= m.getAulasSemana() %>"><br/>
            <input name="id" value="<%= m.getId() %>" type="hidden">
            <input type="submit" value="Confirmar">
        </form>
        </div>
    </body>
</html>
