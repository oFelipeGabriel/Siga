
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Aula" %>
<%@page import="modelo.Materia" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Chamada Concluida</title>
    </head>
    <body>
        <%@include file= "menuProfessor.jsp" %>
        <div class="corpo">
            <% Aula aula = (Aula)request.getAttribute("aula"); %>
            <span class="titulo">Chamada</span>
            <h2><%= aula.getMateria().getNome() %></h2>
            <h2>Chamada de <%= aula.getData() %> salva com sucesso</h2>
        </div>
    </body>
</html>
