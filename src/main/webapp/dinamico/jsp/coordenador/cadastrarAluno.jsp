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
            <form action="alunoCadastrado" method="POST">
                <span>Nome: </span>
                <input type="text" name="nome"><br/>
                <span>E-Mail </span>
                <input type="text" name="email"><br/>
                <span>CPF: </span>
                <input type="number" name="cpf"><br/>
                <span>Data de nascimento: </span>
                <input type="date" name="data_nasc"><br/>
                <span>Login: </span>
                <input type="text" name="login"><br/>
                <span>Senha: </span>
                <input type="password" name="senha"><br/>
                <input type="submit" value="enviar">
            </form>
        </div>
        
    </body>
</html>
