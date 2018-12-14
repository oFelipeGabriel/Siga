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

@Entity(name="MATRICULA")
public class Matricula {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name="id_aluno")
    private Aluno aluno;
    @ManyToOne
    @JoinColumn(name="id_materia")
    private Materia materia;
    @Column(name="semestre")
    private String semestre;
    @Column(name="nota_p1")
    private Float notaP1;
    @Column(name="nota_p2")
    private Float notaP2;
    @Column(name="media")
    private Float media;
    @Column(name="situacao")
    private String situacao;
    
    public Matricula() {  }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }
    
    public String getSemestre() {
        return semestre;
    }

    public void setSemestre(String semestre) {
        this.semestre = semestre;
    }

    public Float getNotaP1() {
        return notaP1;
    }

    public void setNotaP1(Float notaP1) {
        this.notaP1 = notaP1;
    }

    public Float getNotaP2() {
        return notaP2;
    }

    public void setNotaP2(Float notaP2) {
        this.notaP2 = notaP2;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
    
}
