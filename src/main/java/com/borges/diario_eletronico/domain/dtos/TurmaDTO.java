package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.util.stream.Collectors;

import com.borges.diario_eletronico.domain.Turma;

public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String nomeTurma;

	private Integer professores;
	private Integer aluno;

	private String nomeProfessor;
	private String nomeAluno;

	public TurmaDTO() {
		super();
	}

	public TurmaDTO(Turma obj) {
		super();
		this.id = obj.getId();
		this.nomeTurma = obj.getNomeTurma();
		this.aluno = obj.getAluno().getId();
		this.professores = obj.getProfessor().stream().map(i -> i.getId()).collect(Collectors.toList()).hashCode();
		this.nomeAluno = obj.getAluno().getNome();
		this.nomeProfessor = obj.getProfessor().stream().map(i -> i.getNome()).collect(Collectors.toList()).toString();

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

	public Integer getProfessores() {
		return professores;
	}

	public void setProfessores(Integer professores) {
		this.professores = professores;
	}

	public Integer getAluno() {
		return aluno;
	}

	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessore(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public String getNomeAluno() {
		return nomeAluno;
	}

	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}

}
