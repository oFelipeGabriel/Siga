/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity(name="MATERIA")
public class Materia {
    @Id
    private int id;
    @Column(name="codigo")
    private String codigo;
    @Column(name="nome")
    private String nome;
    @ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="id_professor")
    private Professor professor;
    @Column(name="semestre_curso")
    private int semestreCurso;
    @Column(name="semestre_ano")
    private int semestreAno;
    @Column(name="turma")
    private String turma;
    @Column(name="aulas_semana")
    private int aulasSemana;

    public Materia() {   }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }
    

    public int getSemestreCurso() {
        return semestreCurso;
    }

    public void setSemestreCurso(int semestreCurso) {
        this.semestreCurso = semestreCurso;
    }

    public int getSemestreAno() {
        return semestreAno;
    }

    public void setSemestreAno(int semestreAno) {
        this.semestreAno = semestreAno;
    }

    public String getTurma() {
        return turma;
    }

    public void setTurma(String turma) {
        this.turma = turma;
    }

    public int getAulasSemana() {
        return aulasSemana;
    }

    public void setAulasSemana(int aulasSemana) {
        this.aulasSemana = aulasSemana;
    }
    
    
}
