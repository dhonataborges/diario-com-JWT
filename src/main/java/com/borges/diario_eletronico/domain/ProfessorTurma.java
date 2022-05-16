package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "professor_turma")
public class ProfessorTurma implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "turma_id")
	private Turma turma;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "professor_id")
	private Professor professor;

	private Date data_atribuicao;
	private Boolean status;
	
	public ProfessorTurma() {
		super();
	}

	public ProfessorTurma(Integer id, Turma turma, Professor professor, Date data_atribuicao, Boolean status) {
		super();
		this.id = id;
		this.turma = turma;
		this.professor = professor;
		this.data_atribuicao = data_atribuicao;
		this.status = status;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Turma getTurma() {
		return turma;
	}

	public void setTurma(Turma turma) {
		this.turma = turma;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}

	public Date getData_atribuicao() {
		return data_atribuicao;
	}

	public void setData_atribuicao(Date data_atribuicao) {
		this.data_atribuicao = data_atribuicao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
	
}
