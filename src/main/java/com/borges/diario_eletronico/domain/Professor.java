package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.borges.diario_eletronico.domain.enums.Perfil;

@Entity
public class Professor extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProfessorTurma> professorTurma;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<ProfessorTurmaDisciplina> professorTurmaDisciplina;

	public Professor() {
		super();
	}

	public Professor(Integer id, String nome, Date nascimento, String sexo, String cpf, String rg, String telefone,
			String endereco, String zona, String email, String senha) {
		super(id, nome, nascimento, sexo, cpf, rg, telefone, endereco, zona, email, senha);
		addPerfil(Perfil.PROFESSOR);

	}

	public List<ProfessorTurma> getProfessorTurma() {
		return professorTurma;
	}

	public void setProfessorTurma(List<ProfessorTurma> professorTurma) {
		this.professorTurma = professorTurma;
	}

	public List<ProfessorTurmaDisciplina> getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(List<ProfessorTurmaDisciplina> professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}
		
}
