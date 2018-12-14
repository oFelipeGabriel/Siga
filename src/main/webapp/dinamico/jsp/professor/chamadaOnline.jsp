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
        <title>Chamada Online</title>
    </head>
    <body>
        <%@include file= "menuProfessor.jsp" %>
        <% Materia m = (Materia)request.getAttribute("materia"); 
        ArrayList<Aluno> alunos = (ArrayList<Aluno>)request.getAttribute("alunos");
        String data = (String)request.getAttribute("data");
        String titulo = (String)request.getAttribute("titulo");
        Integer id = (Integer)request.getAttribute("idAula");%>
        <div class="corpo">
            <span class="titulo">Chamada</span>
            <h3><%= titulo %></h3>
            <h4><%= data %> - <%= m.getNome() %></h4><br/>
            <form action="chamadaConcluida" method="POST">
            <% for(Aluno a:alunos){ %>
            <input type="checkbox" name="<%= a.getId() %>" value="1" checked><%= a.getNome() %><br>
            <% } %>
            <input name="idAula" type="hidden" value="<%= id %>">
            <input name="idMateria" type="hidden" value="<%= m.getId() %>">
            <input type="submit" value="Enviar">
            </form>
        </div>
    </body>
</html>
