package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;

import com.borges.diario_eletronico.domain.Aula;
import com.fasterxml.jackson.annotation.JsonFormat;

public class AulaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private LocalDate data;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horaInicio;
	
	@JsonFormat(pattern = "HH:mm")
	private LocalTime horaFim;
	
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

	public LocalDate getData() {
		return data;
	}

	public void setData(LocalDate data) {
		this.data = data;
	}

	public LocalTime getHoraInicio() {
		return horaInicio;
	}

	public void setHoraInicio(LocalTime horaInicio) {
		this.horaInicio = horaInicio;
	}

	public LocalTime getHoraFim() {
		return horaFim;
	}

	public void setHoraFim(LocalTime horaFim) {
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
