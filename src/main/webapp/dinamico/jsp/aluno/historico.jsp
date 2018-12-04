<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="estatico/css/estilos.css">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
        <title>Siga - Histórico</title>
    </head>
    <body>
        <%@include file= "menu.jsp" %>
        <div class="corpo">
            <div class="conteudo">
        <span class="titulo">HISTÓRICO</span>
        <div class='divLegendaHist'>
        <span id="legendaHistorico">NF: nota final FR: frequência (%) PE: períoso (ano/semestre)</span>
        <ul id="coresLegendaHistorico">
            <li id="aprovado">Aprovado</li>
            <li id="naoCursado">Não Cursada</li>
            <li id="emCurso">Em Curso</li>
            <li id="dispensado">Dispensado</li>
        </ul>
        </div>
        </div><!-- div conteudo -->
        <div class='materiasHistorico'>
        <div class="divSemestre">
            <span class="tituloSemestre">Semestre 1</span>
            <div class="materia aprovado">
                <p class="nomeMateria">Administração Geral</p>
                <p>Aprovado<br>NF: 8.4<br>FR: 100%<br>PE: 201601</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Arquitetura e Organização de Computadores</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201601</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Matemática Discreta</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201601</p>
            </div>
            <div class="materia dispensado">
                <p class="nomeMateria">Inglês I</p>
                <p>Dispensado<br>NF: 8.0<br>FR: 100%<br>PE: 201601</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Programação em Microinformática</p>
                <p>Dispensado<br>NF: 8.0<br>FR: 100%<br>PE: 201601</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Laboratório de Hardware</p>
                <p>Dispensado<br>NF: 8.0<br>FR: 100%<br>PE: 201601</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Algoritmos e Lógica de Programação</p>
                <p>Dispensado<br>NF: 8.0<br>FR: 100%<br>PE: 201601</p>
            </div>
            
        </div>
        <div class="divSemestre">
            <span class="tituloSemestre">Semestre 2</span>
            <div class="materia aprovado">
                <p class="nomeMateria">Comunicação e Expressão </p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201602</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Linguagem de Programação</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201602</p>
            </div>
            <div class="materia dispensado">
                <p class="nomeMateria">Inglês II</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201602</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Sistemas de Informação</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201602</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Cálculo</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201602</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Engenharia de Software I</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201602</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Contabilidade</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 100%<br>PE: 201602</p>
            </div>
        </div><!-- div semestre -->
        <div class="divSemestre">
            <span class="tituloSemestre">Semestre 3</span>
            <div class="materia  aprovado">
                <p class="nomeMateria">Sistemas Operacionais I</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Sociedade e Tecnologia</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
            <div class="materia  aprovado">
                <p class="nomeMateria">Estruturas de Dados</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Engenharia de Software II</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
            <div class="materia  aprovado">
                <p class="nomeMateria">Programação Orientada a Objetos</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Economia e Finanças</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
            <div class="materia dispensado">
                <p class="nomeMateria">Inglês III</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Interação Humano Computador</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201702</p>
            </div>
        </div>
            <div class="divSemestre">
            <span class="tituloSemestre">Semestre 4</span>
            <div class="materia  aprovado">
                <p class="nomeMateria">Testes de Software</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201801</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Engenharia de Software III</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201801</p>
            </div>
            <div class="materia  aprovado">
                <p class="nomeMateria">Estatística Aplicada</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201801</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Sistemas Operacionais II</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201801</p>
            </div>
            <div class="materia  dispensado">
                <p class="nomeMateria">Inglês IV</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201801</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Banco de Dados</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201801</p>
            </div>
            <div class="materia aprovado">
                <p class="nomeMateria">Metod. da Pesq. Científico-Tecnológica</p>
                <p>Aprovado<br>NF: 8.0<br>FR: 0%<br>PE: 201801</p>
            </div>
        </div>
        <div class="divSemestre">
            <span class="tituloSemestre">Semestre 5</span>
            <div class="materia emCurso">
                <p class="nomeMateria">Programação para Dispositivos Móveis</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
            <div class="materia emCurso">
                <p class="nomeMateria">Laboratório de Banco de Dados</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
            <div class="materia emCurso">
                <p class="nomeMateria">Laboratório de Engenharia de Software</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
            <div class="materia emCurso">
                <p class="nomeMateria">Redes de Computadores</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
            <div class="materia emCurso">
                <p class="nomeMateria">Programação Linear e Aplicações</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
            <div class="materia emCurso">
                <p class="nomeMateria">Segurança da Informação</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
            <div class="materia emCurso">
                <p class="nomeMateria">Inglês V</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
            <div class="materia emCurso">
                <p class="nomeMateria">Trabalho de Graduação I</p>
                <p>Em Curso<br>NF: 0.0<br>FR: 00%<br>PE: 201802</p>
            </div>
        </div><!-- div semestre -->
        <div class="divSemestre">
            <span class="tituloSemestre">Semestre 6</span>
            <div class="materia naoCursado">
                <p class="nomeMateria">Gestão e Governança de Tec. da Informação</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Tópicos Especiais em Informática</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Trabalho de Graduação II</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Inteligência Artificial</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Empreendedorismo</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Gestão de Projetos</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Ética e Responsabilidade Profissional</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Gestão de Equipes</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
            <div class="materia naoCursado">
                <p class="nomeMateria">Inglês VI</p>
                <p><br>NF: <br>FR: <br>PE: </p>
            </div>
        </div><!-- div semestre -->
        
        </div><!-- div semestre -->
        </div><!-- div materias semestre -->
        
        </div><!-- div corpo -->
    </body>
</html>
