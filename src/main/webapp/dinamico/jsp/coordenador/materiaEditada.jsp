<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Professor" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Cadastrar Aluno</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        <% Materia m = (Materia)request.getAttribute("materia"); %>
        <div class="corpo">            
            <h1><%= m.getNome() %></h1>
            <h1><%= m.getProfessor().getNome() %></h1>
            <h1><%= m.getCodigo() %></h1>
        </div>
        
    </body>
</html>
