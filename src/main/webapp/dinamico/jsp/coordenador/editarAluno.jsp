
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Aluno" %>
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
        <div class="corpo">
        <% Aluno a = (Aluno)request.getAttribute("aluno"); %>
        <form action="alunoEditado" method="POST">
            Nome: <input name="nome" value="<%= a.getNome() %>"><br/>
            EMail: <input name="email" value="<%= a.getEmail() %>"><br/>
            CPF: <input name="cpf" value="<%= a.getCpf() %>"><br/>
            Data de nascimento: <input name="data_nasc" value="<%= a.getData_nasc() %>"><br/>
            Data de Formatura: <input type="date" name="data_form"><br/>
            Login: <input name="login" value="<%= a.getLogin() %>"><br/>
            Senha: <input name="senha" type="password" value="<%= a.getSenha() %>"><br>
            <input name="id" value="<%= a.getId() %>" type="hidden">
            <input type="submit" value="Confirmar">
        </form>
        </div>
    </body>
</html>
