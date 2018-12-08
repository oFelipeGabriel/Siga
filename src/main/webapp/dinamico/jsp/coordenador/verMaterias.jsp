
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Professor" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Materias</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        <% List<Materia> materias = (List<Materia>)request.getAttribute("materias"); %>
        <div class="corpo">
            <a href="/Siga/coordenador/cadastrarMateria">Nova Materia</a>
            <table>
                <%for(Materia m:materias){ %>            
                <tr class="nomeAluno">
                    <td><%= m.getNome() %><br/>
                    <%= m.getProfessor().getNome() %></td>
                    <td><a href="/Siga/coordenador/editarMateria?id=<%= m.getId() %>">Editar</a></td>
                    <td><a href="/Siga/coordenador/apagarMateria?id=<%= m.getId() %>">Apagar</a></td>                    
                </tr>
                 <% } %>
                </table>
        </div>
    </body>
</html>
