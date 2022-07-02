package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;

import com.borges.diario_eletronico.domain.ProfessorTurmaDisciplina;

public class ProfessorTurmaDisciplinaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;

	private Integer professorTurma;
	private String nomeProfessorTurma;
	private Integer disciplina;
	private String nomeDisciplina;
	private Integer bimestre;
	private Integer anoLetivo;
		
	public ProfessorTurmaDisciplinaDTO() {
		super();
	}

	public ProfessorTurmaDisciplinaDTO(ProfessorTurmaDisciplina obj) {
		super();
		this.id = obj.getId();
		this.professorTurma = obj.getProfessorTurma().getTurma().getId();
		this.nomeProfessorTurma = obj.getProfessorTurma().getTurma().getSerieNivelSubnivel().getDescricao();
		this.disciplina = obj.getDisciplina().getId();
		this.nomeDisciplina = obj.getDisciplina().getNome();
		this.bimestre = obj.getBimestre();
		this.anoLetivo = obj.getProfessorTurma().getTurma().getAnoLetivo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getProfessorTurma() {
		return professorTurma;
	}

	public void setProfessorTurma(Integer professorTurma) {
		this.professorTurma = professorTurma;
	}
	
	public String getNomeProfessorTurma() {
		return nomeProfessorTurma;
	}

	public void setNomeProfessorTurma(String nomeProfessorTurma) {
		this.nomeProfessorTurma = nomeProfessorTurma;
	}

	public Integer getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Integer disciplina) {
		this.disciplina = disciplina;
	}
	
	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Integer getBimestre() {
		return bimestre;
	}

	public void setBimestre(Integer bimestre) {
		this.bimestre = bimestre;
	}

	public Integer getAnoLetivo() {
		return anoLetivo;
	}

	public void setAnoLetivo(Integer anoLetivo) {
		this.anoLetivo = anoLetivo;
	}
		
}
