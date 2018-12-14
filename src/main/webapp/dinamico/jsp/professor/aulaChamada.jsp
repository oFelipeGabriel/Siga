<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Aluno" %>
<%@page import="java.util.ArrayList" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Aula - Chamada</title>
    </head>
    <body>
        <%@include file= "menuProfessor.jsp" %>
        <% Materia m = (Materia)request.getAttribute("materia"); 
        ArrayList<Aluno> alunos = (ArrayList<Aluno>)request.getAttribute("alunos");%>
        <div class="corpo">
            <span class="titulo">Chamada</span>
            <h4><%= m.getNome() %></h4>
            <form action="chamadaOnline" method="POST">
                Data: <input name="data" type="date"><br/>
                Titulo: <input type="text" name="titulo"><br/>
                <input name="idMateria" type="hidden" value="<%= m.getId() %>" >
                <input type="submit" value="Confirmar">
            </form>
            <div class="nomeAlunos">
                <% for(Aluno a:alunos){%>
                <p><%= a.getId() %> - <%= a.getNome() %></p>
                <% } %>
            </div>
        </div>
    </body>
</html>
