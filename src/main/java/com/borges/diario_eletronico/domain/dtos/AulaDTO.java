package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.borges.diario_eletronico.domain.Aula;

public class AulaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date horaInicio;
	
	@DateTimeFormat(pattern = "HH:mm")
	@Temporal(TemporalType.TIME)
	private Date horaFim;
	
	private String conteudo;
	private Integer professor;
	private String nomeProfessor;
	
	public AulaDTO() {
		super();
	}

	public AulaDTO(Aula obj) {
		super();
		this.id = obj.getId();
		this.data = obj.getData();
		this.horaInicio = obj.getHoraInicio();
		this.horaFim = obj.getHoraFim();
		this.conteudo = obj.getConteudo();
		this.professor = obj.getProfessorTurmaDisciplina().getProfessorTurma().getProfessor().getId();
		this.nomeProfessor = obj.getProfessorTurmaDisciplina().getProfessorTurma().getProfessor().getNome();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public Date getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(Date horaInicio) {
		this.horaInicio = horaInicio;
	}

	public Date getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(Date horaFim) {
		this.horaFim = horaFim;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
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
	
}
