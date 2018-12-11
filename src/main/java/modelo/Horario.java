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

@Entity(name="HORARIO")
public class Horario {
    @Id
    private int id;
    @ManyToOne(fetch=FetchType.LAZY, cascade={CascadeType.ALL})
    @JoinColumn(name="id_materia")
    private Materia materia;
    @Column(name="dia_semana")
    private int diaSemana;
    @Column(name="horario")
    private String horario;
    @Column(name="semestre")
    private int semestre;
    @Column(name="semestre_ano")
    private int semestreAno;
    
    public Horario() {  }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Materia getMateria() {
        return materia;
    }

    public void setMateria(Materia materia) {
        this.materia = materia;
    }

    public int getDiaSemana() {
        return diaSemana;
    }

    public void setDiaSemana(int diaSemana) {
        this.diaSemana = diaSemana;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    public int getSemestreAno() {
        return semestreAno;
    }

    public void setSemestreAno(int semestreAno) {
        this.semestreAno = semestreAno;
    }
    
    
}
