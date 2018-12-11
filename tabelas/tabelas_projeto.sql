CREATE TABLE ALUNO(id int(10) primary key AUTO_INCREMENT, nome varchar(50) not null, email varchar(50), cpf int(11), data_nasc date, data_matricula date not null, data_formatura date, matriculado int(1) not null, login varchar(50),senha varchar(50));

CREATE TABLE `PROFESSOR` ( `id` INT(10) PRIMARY KEY AUTO_INCREMENT, `nome` VARCHAR(50) NOT NULL , `data_inicio` DATE NOT NULL , `data_saida` DATE NULL , `login` VARCHAR(50) NOT NULL , `senha` VARCHAR(50) NOT NULL);
ALTER TABLE PROFESSOR ADD COLUMN contratado int(1);
ALTER TABLE PROFESSOR AUTO_INCREMENT=15;

CREATE TABLE `MATERIA` ( `id` INT(10) PRIMARY KEY AUTO_INCREMENT, `codigo` VARCHAR(10) NOT NULL , `nome` VARCHAR(50) NOT NULL , `id_professor` INT(10) NOT NULL , `semestre_curso` INT(1) NOT NULL, `semestre_ano` INT(6) NOT NULL,turma varchar(1));
alter TABLE MATERIA add column aulas_semana int(1);

CREATE TABLE `MATRICULA` ( `id` INT(10) PRIMARY KEY AUTO_INCREMENT,`id_aluno` INT(10) NOT NULL , `id_materia` INT(10) NOT NULL , `semestre` INT(6) NOT NULL, nota_p1 float(4,2), nota_p2 float(4,2),media float(4,2),situacao VARCHAR(10) );
ALTER TABLE MATRICULA ADD FOREIGN KEY (id_aluno) REFERENCES ALUNO(id);
ALTER TABLE MATRICULA ADD FOREIGN KEY (id_materia) REFERENCES MATERIA(id);

CREATE TABLE `COORDENADOR` ( `id` INT PRIMARY KEY AUTO_INCREMENT , `nome` VARCHAR(50) NOT NULL , `login` VARCHAR(50) NOT NULL , `senha` INT(12) NOT NULL );

CREATE TABLE `HORARIO` ( `id` INT(20) PRIMARY KEY AUTO_INCREMENT,`id_materia` INT(10) NOT NULL , `dia_semana` int(1) NOT NULL , `horario` VARCHAR(11) NOT NULL , `semestre` INT(1) NOT NULL, FOREIGN KEY (id_materia) REFERENCES MATERIA(id));
ALTER TABLE HORARIO ADD COLUMN `semestre_ano` int(6);

CREATE TABLE `AULA` ( `id` INT NOT NULL PRIMARY KEY AUTO_INCREMENT, `data` DATE NOT NULL , `titulo` VARCHAR(50) NOT NULL , `id_materia` INT NOT NULL, FOREIGN KEY (`id_materia`) REFERENCES MATERIA(id));
