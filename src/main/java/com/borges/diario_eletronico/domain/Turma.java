package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeTurma;

	@ManyToOne()
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Professor_Turma", joinColumns = { @JoinColumn(name = "professor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "turma_id") })
	private List<Profissional> professor = new ArrayList<>();

	public Turma() {
		super();
	}

	public Turma(Integer id, String nomeTurma, Aluno aluno, List<Profissional> professor) {
		super();
		this.id = id;
		this.nomeTurma = nomeTurma;
		this.aluno = aluno;
		this.professor = professor;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public List<Profissional> getProfessor() {
		return professor;
	}

	public void setProfessor(List<Profissional> professor) {
		this.professor = professor;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}

}
