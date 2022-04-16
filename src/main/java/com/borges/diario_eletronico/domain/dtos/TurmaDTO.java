package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.borges.diario_eletronico.domain.Turma;

public class TurmaDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;
	private String codTurma;
	private String nomeTurma;
	private String turno;
	
	@NotNull(message = "Campo ANO CRIAÇÃO não pode ser vasio!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "anoCriacao")
	private Date anoCriacao;
	
	private Integer professore;
	private String nomeProfessor;

	public TurmaDTO() {
		super();
	}

	public TurmaDTO(Turma obj) {
		super();
		this.id = obj.getId();
		this.codTurma = obj.getCodTurma();
		this.nomeTurma = obj.getNomeTurma();
		this.turno = obj.getTurno();
		this.anoCriacao = obj.getAnoCriacao();
		this.professore = obj.getProfessor().getId();
		this.nomeProfessor = obj.getProfessor().getNome();
		//this.nomeProfessor = obj.getProfessor().stream().map(i -> i.getNome()).collect(Collectors.toList()).toString();

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

	public void setNomeProfessor(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}

	public Integer getProfessore() {
		return professore;
	}

	public void setProfessore(Integer professore) {
		this.professore = professore;
	}

	public String getNomeProfessor() {
		return nomeProfessor;
	}

	public void setNomeProfessore(String nomeProfessor) {
		this.nomeProfessor = nomeProfessor;
	}
}
