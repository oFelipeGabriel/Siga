<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Horario" %>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Professor" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Matriculado</title>
    </head>
    <body>
        <%@include file= "menu.jsp" %>
        <% ArrayList<Horario> horarios = (ArrayList<Horario>)request.getAttribute("horarios"); %>
        <div class="corpo">
            <% for(Horario h:horarios){ %>
            <h4><%= h.getMateria().getNome() %> - Professor: <%= h.getMateria().getProfessor().getNome() %></h4>
            <h3><%= h.getDiaSemana() %> - <%= h.getHorario() %></h3>
            <% } %>
        </div>
    </body>
</html>
