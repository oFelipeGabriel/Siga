<%-- 
    Document   : inicioCoordenador
    Created on : 01/12/2018, 18:10:44
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <table class="tabela">
            <tr>
                <td>Nome:</td>
                <td><%= request.getAttribute("usuario")%></td>
            </tr>
            <tr>
                <td>RE:</td>
                <td><%= request.getAttribute("RE")%></td>
            </tr>
        </table>  
        </div>
    </body>
</html>
