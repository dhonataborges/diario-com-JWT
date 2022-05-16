package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.time.Year;
import java.util.List;
import java.util.Objects;

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

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name = "professor_turma_disciplina")
public class ProfessorTurmaDisciplina implements Serializable{
    private static final long serialVersionUID = 1L;
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_turma_id")
	private Professor professor;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "disciplina_id")
	private Disciplina disciplina;
	
	private Integer bimestre;
	private Year ano_letivo;
	
	@OneToMany(mappedBy = "professorTurmaDisciplina", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Aula> aula;
	
	@OneToMany(mappedBy = "professorTurmaDisciplina", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Atividade> atividade;
	
	public ProfessorTurmaDisciplina() {
		super();
	}

	public ProfessorTurmaDisciplina(Integer id, Professor professor, Disciplina disciplina, Integer bimestre,
			Year ano_letivo, List<Aula> aula, List<Atividade> atividade) {
		super();
		this.id = id;
		this.professor = professor;
		this.disciplina = disciplina;
		this.bimestre = bimestre;
		this.ano_letivo = ano_letivo;
		this.aula = aula;
		this.atividade = atividade;
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

	public Professor getProfessor() {
		return professor;
	}

	public void setProfessor(Professor professor) {
		this.professor = professor;
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

	public Year getAno_letivo() {
		return ano_letivo;
	}

	public void setAno_letivo(Year ano_letivo) {
		this.ano_letivo = ano_letivo;
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
