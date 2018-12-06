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
            <div class="listaProfessor">
                <ul>
                <%for(Professor p:professores){ %>            
                    <li class="nomeProfessor">Nome: <%= p.getNome() %></li>
                 <% } %>
                </ul>
            </div>
           
        
        </div>
            
        
    </body>
</html>
