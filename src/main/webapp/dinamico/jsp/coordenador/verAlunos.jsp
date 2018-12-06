<%-- 
    Document   : cadastrarAluno
    Created on : 30/11/2018, 17:15:01
    Author     : felipe
--%>

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
        <% List<Aluno> alunos = (List<Aluno>)request.getAttribute("alunos"); %>
        <div class="corpo">
            <div class="listaAluno">
                <table>
                <%for(Aluno a:alunos){ %>            
                <tr class="nomeAluno">
                    <td><%= a.getNome() %></td>
                    <td><a href="/Siga/coordenador/editarAluno?id=<%= a.getId() %>">Editar</a></td>
                    <td><a href="/Siga/coordenador/apagarAluno?id=<%= a.getId() %>">Apagar</a></td>                    
                </tr>
                 <% } %>
                </table>
            </div>
           
        
        </div>
            
        
    </body>
</html>
