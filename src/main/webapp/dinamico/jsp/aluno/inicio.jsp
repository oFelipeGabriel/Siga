<%-- 
    Document   : inicio
    Created on : 28/09/2018, 07:22:04
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
         <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Siga - Inicio</title>
        
    </head>
    <body>
        <%@include file= "menu.jsp" %>
        <div class="corpo">
        <span class="titulo">INÍCIO</span>
        <table class="tabela">
            <tr>
                <td>NOME:</td>
                <td><%= request.getAttribute("usuario")%></td>
            </tr>
            <tr>
                <td>EMAIL:</td>
                <td><%= request.getAttribute("email")%></td>
            </tr>
            <tr>
                <td>CPF:</td>
                <td><%= request.getAttribute("cpf")%></td>
            </tr>
            <tr>
                <td>Data de Nascimento:</td>
                <td><%= request.getAttribute("dataDeNascimento")%></td>
            </tr>
            <tr>
                <td>RA:</td>
                <td><%= request.getAttribute("RA")%></td>
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
