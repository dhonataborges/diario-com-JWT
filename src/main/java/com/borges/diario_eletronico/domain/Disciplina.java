package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Disciplina implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(unique = true)
	private String nomeDisciplina;

	private String professores;

	//@ManyToMany(mappedBy = "disciplinas", cascade = CascadeType.ALL)
	private String alunos;

	public Disciplina() {
		super();
	}

	public Disciplina(Integer id, String nomeDisciplina, String professores, String alunos) {
		super();
		this.id = id;
		this.nomeDisciplina = nomeDisciplina;
		this.professores = professores;
		this.alunos = alunos;
	}

	public Disciplina(Disciplina obj) {
		super();
		this.id = obj.getId();
		this.nomeDisciplina = obj.getNomeDisciplina();
		this.professores = obj.getProfessores();
		this.alunos = obj.getAlunos();
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
		Disciplina other = (Disciplina) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public String getProfessores() {
		return professores;
	}

	public void setProfessores(String professores) {
		this.professores = professores;
	}

	public String getAlunos() {
		return alunos;
	}

	public void setAlunos(String alunos) {
		this.alunos = alunos;
	}

}
