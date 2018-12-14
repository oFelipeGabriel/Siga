
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Professor" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Siga - Inicio</title>
        
    </head>
    <body>
        <%@include file= "menuProfessor.jsp" %>
        <% Professor professor = (Professor)request.getAttribute("usuario"); %>
        <div class="corpo">
        <span class="titulo">Dados pessoais</span>
        <table class="tabela">
            <tr>
                <td>Nome:</td>
                <td><%= professor.getNome() %></td>
            </tr>
            <tr>
                <td>RE:</td>
                <td><%= professor.getId() %></td>
            </tr>
            <tr>
                <td>Login:</td>
                <td><%= professor.getLogin() %></td>
            </tr>
        </table>  
        </div>
    </body>
</html>
