<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Materia"%>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Cadastrar Horario</title>
    </head>
    <body>
        <%@include file= "menuCoordenador.jsp" %>
        <% List<Materia> materias = (List<Materia>)request.getAttribute("materias");
        String semCurso = (String)request.getAttribute("semestre");%>
        <div class="corpo">
            <form action="horarioCadastrado" method="POST">
                Ano:<input type="number" value="2018" name="ano">
                Semestre:<select name="sem">
                    <option value="01">1</option>
                    <option value="02">2</option></select><br/>
            <table>
                <tr>
                <th></th>
                <th>Segunda-Feira</th>
                <th>Terça-Feira</th>
                <th>Quarta-Feira</th>
                <th>Quinta-Feira</th>
                <th>Sexta-Feira</th> 
                </tr>
                <tr>
                    <td>07:10-08:00</td>
                    <td><select name="seg-1">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="ter-1">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qua-1">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qui-1">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="sex-1">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>08:00-08:50</td>
                    <td><select name="seg-2">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="ter-2">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qua-2">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qui-2">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="sex-2">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>09:15-10:05</td>
                    <td><select name="seg-3">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="ter-3">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qua-3">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qui-3">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="sex-3">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>10:05-10:55</td>
                    <td><select name="seg-4">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="ter-4">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qua-4">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qui-4">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="sex-4">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>10:55-11:45</td>
                    <td><select name="seg-5">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="ter-5">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qua-5">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qui-5">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="sex-5">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>11:45-12:35</td>
                    <td><select name="seg-6">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="ter-6">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qua-6">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="qui-6">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                    <td><select name="sex-6">
                            <option value="0">Escolha a matéria</option>
                        <% for(Materia m:materias){ %>
                        <option value="<%= m.getId() %>"><%= m.getNome() %></option>
                        <% } %>
                        </select>
                    </td>
                </tr>
            </table>
                        <input name="semCurso" value="<%= semCurso %>" type="hidden">
                        <input type="submit" value="Cadastrar">
            </form>
        </div>
    </body>
</html>
