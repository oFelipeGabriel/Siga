<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Professor" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Siga/estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Cadastrar Materia</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        <div class="corpo">
            <% List<Professor> professores = (List<Professor>)request.getAttribute("professores"); %>
            <form action="professorCadastrado" method="POST">
                <span>Nome: </span>
                <input type="text" name="nome"><br/>
                <span>Professor: </span>
                <select name="idProfessor">
                    <% for(Professor p:professores){ %>
                    <option value="<%= p.getId()%>"><%= p.getNome()%></option>
                    <% } %>
                </select>
                <span>Semestre (Curso): </span>
                <input type="text" name="semestreCurso"><br/>
                <span>Semestre Ano: </span>
                <input type="text" name="semestreAno"><br/>
                <span>Turma: </span>
                 <select name="turma">
                    <option value="A">A</option>
                    <option value="B">B</option>
                </select> 
                <input type="submit" value="enviar">
            </form>
        </div>
    </body>
</html>
