
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Professor" %>
<%@page import="modelo.Materia" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="../estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Siga - Inicio</title>
        
    </head>
    <body>
        <%@include file= "menuProfessor.jsp" %>
        <% List<Materia> materias = (List<Materia>)request.getAttribute("materias"); %>
        <div class="corpo">
        <span class="titulo">Chamada</span>
        <% for(Materia m:materias){ %>
            <a href="aulaChamada?m=<%= m.getId() %>"><%= m.getNome() %></a><br/>
         <%}%>
        
        </div>
    </body>
</html>
