<%-- 
    Document   : inicio
    Created on : 28/09/2018, 07:22:04
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Aluno" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Siga - Inicio</title>
        
    </head>
    <body>
        <%@include file= "menu.jsp" %>
        <% Aluno a = new Aluno();
        a = (Aluno)session.getAttribute("usuario"); 
        String[] dataNasc = a.getData_nasc().split("-");%>
        <div class="corpo">
        <span class="titulo">INÍCIO</span>
        <table class="tabela">
            <tr>
                <td>NOME:</td>
                <td><%= a.getNome() %></td>
            </tr>
            <tr>
                <td>EMAIL:</td>
                <td><%= a.getEmail() %></td>
            </tr>
            <tr>
                <td>CPF:</td>
                <td><%= a.getCpf() %></td>
            </tr>
            <tr>
                <td>Data de Nascimento:</td>
                <td><%= dataNasc[2]%>/<%= dataNasc[1] %>/<%= dataNasc[0]%></td>
            </tr>
            <tr>
                <td>RA:</td>
                <td><%= a.getId() %></td>
            </tr>
            <tr>
                <td>PP:</td>
            </tr>
            <tr>
                <td>PR:</td>
            </tr>
            
        </table>  
        </div>
    </body>
</html>
