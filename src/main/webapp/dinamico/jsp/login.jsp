<%-- 
    Document   : login
    Created on : 25/09/2018, 11:47:16
    Author     : Aluno
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/estatico/css/estilos.css">
        
        <title>Siga</title>
    </head>
    <body>
        <div class="conteudoLogin">
            <div class="imagemLogin" id="sigaLogo">SIGA</div>
            <div class="campoLogin">
            <form action="/Siga/Inicio" method="post">
                usuario:<br><input class="campoEntrada" type="text" name="usuario"></br>
                senha:<br><input class="campoEntrada" type="password" name="senha"></br>
            <input type="submit" value="->">
                    </form>

            </div>
            
        </div>
        
        <c:choose>
            <c:when test="${requestScope.FalhouLogin=='sim'}">
                <h3 id="falhouLogin">Falha no login</h3>
            </c:when>
        </c:choose>
                <script src="estatico/js/javascript.js">
                    </script>
    </body>
</html>
