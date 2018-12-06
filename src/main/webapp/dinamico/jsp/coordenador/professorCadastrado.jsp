<%-- 
    Document   : cadastrarAluno
    Created on : 30/11/2018, 17:15:01
    Author     : felipe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <div class="corpo">
            <h1>Cadastrado <%= request.getAttribute("nome")%></h1>
            <h1>Login: <%= request.getAttribute("login")%></h1>
        </div>
        
    </body>
</html>
