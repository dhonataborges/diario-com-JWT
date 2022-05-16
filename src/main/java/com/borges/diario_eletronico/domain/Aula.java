package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "aula")
public class Aula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data;
	private Time hora_inicio;
	private Time hora_fim;
	private String conteudo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_turma_disciplina_id")
	private ProfessorTurmaDisciplina professorTurmaDisciplina;
	
	@OneToMany(mappedBy = "aula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AlunoAula> alunoAula;
		
	public Aula() {
		super();
	}

	public Aula(Integer id, Date data, Time hora_inicio, Time hora_fim, String conteudo,
			ProfessorTurmaDisciplina professorTurmaDisciplina, List<AlunoAula> alunoAula) {
		super();
		this.id = id;
		this.data = data;
		this.hora_inicio = hora_inicio;
		this.hora_fim = hora_fim;
		this.conteudo = conteudo;
		this.professorTurmaDisciplina = professorTurmaDisciplina;
		this.alunoAula = alunoAula;
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

	public Time getHora_inicio() {
		return hora_inicio;
	}

	public void setHora_inicio(Time hora_inicio) {
		this.hora_inicio = hora_inicio;
	}

	public Time getHora_fim() {
		return hora_fim;
	}

	public void setHora_fim(Time hora_fim) {
		this.hora_fim = hora_fim;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public ProfessorTurmaDisciplina getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(ProfessorTurmaDisciplina professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}

	public List<AlunoAula> getAlunoAula() {
		return alunoAula;
	}

	public void setAlunoAula(List<AlunoAula> alunoAula) {
		this.alunoAula = alunoAula;
	}
	
}
