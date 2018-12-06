<%-- 
    Document   : inicioCoordenador
    Created on : 01/12/2018, 18:10:44
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Coordenador" %>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Siga - Inicio</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        <div class="corpo">
        <span class="titulo">Dados pessoais</span>
        <% Coordenador c = new Coordenador();
        c = (Coordenador)session.getAttribute("usuario"); %>
        <table class="tabela">
            <tr>
                <td>Nome:</td>
                <td><%= c.getNome()%></td>
            </tr>
            <tr>
                <td>RE:</td>
                <td><%= c.getId()%></td>
            </tr>
        </table>  
        </div>
    </body>
</html>
