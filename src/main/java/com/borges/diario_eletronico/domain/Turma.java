package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String codTurma;
	private String nomeTurma;
	private String turno;
	private Date anoCriacao;
	
	@ManyToOne
	@JoinColumn(name = "professsor_id")
	private Professor professor;

	/*@ManyToOne()
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;*/
	
	/*@JsonManagedReference 
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "Professor_Turma", joinColumns = { @JoinColumn(name = "professor_id") }, inverseJoinColumns = {
			@JoinColumn(name = "turma_id") })
	private List<Profissional> professor = new ArrayList<>();*/

	public Turma() {
		super();
	}
	
	public Turma(Integer id, String codTurma, String nomeTurma, String turno, Date anoCriacao,
			Professor professor) {
		super();
		this.id = id;
		this.codTurma = codTurma;
		this.nomeTurma = nomeTurma;
		this.turno = turno;
		this.anoCriacao = anoCriacao;
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

	public String getCodTurma() {
		return codTurma;
	}

	public void setCodTurma(String codTurma) {
		this.codTurma = codTurma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}

	public String getTurno() {
		return turno;
	}

	public void setTurno(String turno) {
		this.turno = turno;
	}

	public Date getAnoCriacao() {
		return anoCriacao;
	}

	public void setAnoCriacao(Date anoCriacao) {
		this.anoCriacao = anoCriacao;
	}

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
	}
	
}
