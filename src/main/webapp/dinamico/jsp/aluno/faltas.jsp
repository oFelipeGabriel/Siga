
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Siga - Faltas</title>
    </head>
    <body>
        <%@include file= "menu.jsp" %>
        <div class="corpo">
        <div class="conteudo">
        <span class="titulo">FALTAS PARCIAIS</span>
        <table class="tabelaFaltas">
            <tr>
                <th id="thDisciplina">Disciplina</th>
                <th>Presenças</th>
                <th>Ausências</th>
            </tr>
            <tr>
                <td class="disciplinaFaltas">Nome 1</td>
                <td>0</td>
                <td>0</td>
            </tr>
            <tr>
                <td class="disciplinaFaltas">Nome 2</td>
                <td>0</td>
                <td>0</td>
            </tr>
            <tr>
                <td class="disciplinaFaltas">Nome 3</td>
                <td>0</td>
                <td>0</td>
            </tr>
            <tr>
                <td class="disciplinaFaltas">Nome 4</td>
                <td>0</td>
                <td>0</td>
            </tr>
        </table>
        <!-- div conteudo -->
        </div>
        <!-- div corpo -->
        </div>
    </body>
</html>
