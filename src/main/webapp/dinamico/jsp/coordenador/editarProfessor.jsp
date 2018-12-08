
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Professor" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Alterar Professor</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        
        <div class="corpo">
        <% Professor p = (Professor)request.getAttribute("professor"); %>
        <form action="professorEditado" method="POST">
            Nome: <input name="nome" value="<%= p.getNome() %>"><br/>
            Data de inicio: <input id="dataInicio" type="date" name="dataInicio"><br/>
            Login: <input name="login" value="<%= p.getLogin() %>"><br/>
            Senha: <input name="senha" type="password" value="<%= p.getSenha() %>"><br/>
            <input name="id" value="<%= p.getId() %>" type="hidden">
            <input type="submit" value="Confirmar">
        </form>
            <script>
            var data = document.getElementById("dataInicio");
            data.value = "<%= p.getData_inicio() %>";
            </script>
        </div>
    </body>
</html>
