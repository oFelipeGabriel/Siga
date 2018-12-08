<%-- 
    Document   : cadastrarAluno
    Created on : 30/11/2018, 17:15:01
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Professor" %>
<%@page import="java.util.List" %>
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
        <% List<Professor> professores = (List<Professor>)request.getAttribute("professores"); %>
        <div class="corpo">
            <a href="cadastrarProfessor">Novo Professor</a>
            <div class="listaProfessor">
                <table>
                <%for(Professor p:professores){ %>            
                <tr>
                    <td>Nome: <%= p.getNome() %></td>
                    <td><a href="editarProfessor?id=<%= p.getId() %>">Editar</a></td>
                    <td><a href="apagarProfessor?id=<%= p.getId() %>">Apagar</a></td>
                </tr>
                 <% } %>
                </table>
            </div>
           
        
        </div>
            
        
    </body>
</html>
