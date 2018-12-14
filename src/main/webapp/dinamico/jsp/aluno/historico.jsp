<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Horario" %>
<%@page import="modelo.Materia" %>
<%@page import="modelo.Matricula" %>
<%@page import="modelo.Professor" %>
<%@page import="java.util.ArrayList" %>
<%@page import="java.util.List" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" crossorigin="anonymous">
        <title>Siga - Histórico</title>
    </head>
    <body>
        <%@include file= "menu.jsp" %>
        <% List<Matricula> materiasMatriculadas = (List<Matricula>)request.getAttribute("matriculas"); 
        ArrayList<Materia> materias = (ArrayList<Materia>)request.getAttribute("materias");
        String classe = "materia naoCursado";
        String situacao = "Não Cursado";
        String nf = "";
        String fe = "";
        String pe = "201802";
        int semestre = 0;%>
        <div class="corpo">
            <div class="conteudo">
        <span class="titulo">HISTÓRICO</span>
        <div class='divLegendaHist'>
        <span id="legendaHistorico">NF: nota final FR: frequência (%) PE: período (ano/semestre)</span>
        <ul id="coresLegendaHistorico">
            <li id="aprovado">Aprovado</li>
            <li id="naoCursado">Não Cursada</li>
            <li id="emCurso">Em Curso</li>
            <li id="dispensado">Dispensado</li>
        </ul>
        </div>
        </div><!-- div conteudo --><br/>
        <div class='materiasHistorico'>
        
            
            <% for(Materia m:materias){
                if(m.getSemestreCurso()!=semestre){ 
                    if(m.getSemestreCurso()>1){%>
                        </div> <% } %>
                <div class="divSemestre">
                <span class="tituloSemestre">Semestre <%= m.getSemestreCurso() %></span>
                <% semestre = m.getSemestreCurso();}
                pe = String.valueOf(m.getSemestreCurso());
                if(m.getSemestreCurso()==semestre){
                        for(Matricula mt:materiasMatriculadas){ 
                            if(mt.getMateria().getNome().equals(m.getNome())){
                                switch(mt.getSituacao()){
                                    case "Aprovado":classe="materia aprovado";break;
                                    case "Em Curso":classe="materia emCurso";break;
                                    case "Reprovado":classe="materia reprovado";break;
                                    case "Dispensado":classe="materia dispensado";break;
                                }
                                situacao = mt.getSituacao();
                                pe = mt.getSemestre();
                            }
                        }
                     %>
                
                <div class="<%= classe %>">
                    <p class="nomeMateria"><%= m.getNome() %></p>
                    <p><%= situacao %><br>NF: <%= nf %><br>FR:  <br>PE: <%= String.valueOf(pe) %></p>
                </div>
            <% } classe = "materia naoCursado"; situacao = "Não Cursado"; nf = "";  } %>          
            
        </div>
        
        
        </div><!-- div materias semestre -->
        
        </div><!-- div corpo -->
    </body>
</html>
