
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="modelo.Materia" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Confirmar Matricula</title>
    </head>
    <body>
        <div class="corpo">
            <%@include file= "menu.jsp" %>
        <% ArrayList<Materia> materias = (ArrayList<Materia>)request.getAttribute("materiasEscolhidas"); %>
        <h2>Materias</h2>
        <% for(Materia m:materias){ %>
        <h4><%= m.getId() %> - <%= m.getCodigo() %> - <%= m.getNome() %></h4>
        <% } %>
        <a href="Matricula">Voltar  </a><a href="matriculaConfirmada">   Confirmar</a>
        </div>
    </body>
</html>
