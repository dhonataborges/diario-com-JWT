package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.borges.diario_eletronico.domain.ProfessorTurma;

public class ProfessorTurmaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer turma;
	private Integer anoTurma;
	private Integer professor;
	private String nomeProfessor;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataAtribuicao;
	private Boolean status;
	
	public ProfessorTurmaDTO() {
		super();
	}

	public ProfessorTurmaDTO(ProfessorTurma obj) {
		super();
		this.id = obj.getId();
		this.turma = obj.getTurma().getId();
		this.anoTurma = obj.getTurma().getAnoLetivo();
		this.professor = obj.getProfessor().getId();
		this.nomeProfessor = obj.getProfessor().getNome();
		this.dataAtribuicao = obj.getData_atribuicao();
		this.status = obj.getStatus();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurma() {
		return turma;
	}

	public void setTurma(Integer turma) {
		this.turma = turma;
	}

	public Integer getAnoTurma() {
		return anoTurma;
	}

	public void setAnoTurma(Integer anoTurma) {
		this.anoTurma = anoTurma;
	}

	public Integer getProfessor() {
		return professor;
	}

	public void setProfessor(Integer professor) {
		this.professor = professor;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public Date getDataAtribuicao() {
		return dataAtribuicao;
	}

	public void setDataAtribuicao(Date dataAtribuicao) {
		this.dataAtribuicao = dataAtribuicao;
	}

	public Boolean getStatus() {
		return status;
	}

	public void setStatus(Boolean status) {
		this.status = status;
	}
		
}
