<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Professor" %>
<%@page import="modelo.Materia" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Cadastrar Materia</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        <% Materia m = (Materia)request.getAttribute("materia"); %>
        <div class="corpo">
            <h1>Cadastrado <%= m.getNome() %></h1>
            <h1>Professor: <%= m.getProfessor().getNome() %></h1>
        </div>
        
    </body>
</html>
