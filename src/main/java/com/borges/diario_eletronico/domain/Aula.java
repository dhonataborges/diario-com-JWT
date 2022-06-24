package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "aula")
public class Aula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date data;
	
	@Column(name = "hora_inicio")
	private Date horaInicio;
	
	@Column(name = "hora_fim")
	private Date horaFim;
	
	private String conteudo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_turma_disciplina_id")
	private ProfessorTurmaDisciplina professorTurmaDisciplina;
	
	@OneToMany(mappedBy = "aula", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AlunoAula> alunoAula;
		
	public Aula() {
		super();
	}

	public Aula(Integer id, Date data, Date horaInicio, Date horaFim, String conteudo,
			ProfessorTurmaDisciplina professorTurmaDisciplina) {
		super();
		this.id = id;
		this.data = data;
		this.horaInicio = horaInicio;
		this.horaFim = horaFim;
		this.conteudo = conteudo;
		this.professorTurmaDisciplina = professorTurmaDisciplina;
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
