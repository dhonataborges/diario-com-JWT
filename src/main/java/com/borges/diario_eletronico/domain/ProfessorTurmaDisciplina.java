package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "professor_turma_disciplina")
public class ProfessorTurmaDisciplina implements Serializable{
    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_turma_id")
	private ProfessorTurma professorTurma;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
	
	private Integer bimestre;
	
	@Column(name = "ano_letivo")
	private Integer anoLetivo;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professorTurmaDisciplina", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Aula> aula;
	
	@JsonIgnore
	@OneToMany(mappedBy = "professorTurmaDisciplina", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Atividade> atividade;
	
	public ProfessorTurmaDisciplina() {
		super();
	}

	public ProfessorTurmaDisciplina(Integer id, ProfessorTurma professorTurma, Disciplina disciplina, Integer bimestre,
			Integer anoLetivo) {
		super();
		this.id = id;
		this.professorTurma = professorTurma;
		this.disciplina = disciplina;
		this.bimestre = bimestre;
		this.anoLetivo = anoLetivo;
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
		ProfessorTurmaDisciplina other = (ProfessorTurmaDisciplina) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public ProfessorTurma getProfessorTurma() {
		return professorTurma;
	}

	public void setProfessorTurma(ProfessorTurma professorTurma) {
		this.professorTurma = professorTurma;
	}

	public Disciplina getDisciplina() {
		return disciplina;
	}

	public void setDisciplina(Disciplina disciplina) {
		this.disciplina = disciplina;
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

	public List<Aula> getAula() {
		return aula;
	}

	public void setAula(List<Aula> aula) {
		this.aula = aula;
	}

	public List<Atividade> getAtividade() {
		return atividade;
	}

	public void setAtividade(List<Atividade> atividade) {
		this.atividade = atividade;
	}
			
}
