package com.borges.diario_eletronico.domain;

import java.io.Serializable;
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
@Table(name = "turma")
public class Turma implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Integer ano_letivo;
	private Integer sala;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "serie_nivel_subnivel_id")
	private SerieNivelSubnivel serieNivelSubnivel;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProfessorTurma> professorTurma;
	
	@OneToMany(mappedBy = "turma", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Aluno> aluno;
			
	public Turma() {
		super();
	}

	public Turma(Integer id, Integer ano_letivo, Integer sala, SerieNivelSubnivel serieNivelSubnivel) {
		super();
		this.id = id;
		this.ano_letivo = ano_letivo;
		this.sala = sala;
		this.serieNivelSubnivel = serieNivelSubnivel;
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
		Turma other = (Turma) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getAno_letivo() {
		return ano_letivo;
	}

	public void setAno_letivo(Integer ano_letivo) {
		this.ano_letivo = ano_letivo;
	}

	public Integer getSala() {
		return sala;
	}

	public void setSala(Integer sala) {
		this.sala = sala;
	}

	public SerieNivelSubnivel getSerieNivelSubnivel() {
		return serieNivelSubnivel;
	}

	public void setSerieNivelSubnivel(SerieNivelSubnivel serieNivelSubnivel) {
		this.serieNivelSubnivel = serieNivelSubnivel;
	}

	public List<ProfessorTurma> getProfessorTurma() {
		return professorTurma;
	}

	public void setProfessorTurma(List<ProfessorTurma> professorTurma) {
		this.professorTurma = professorTurma;
	}

	public List<Aluno> getAluno() {
		return aluno;
	}

	public void setAluno(List<Aluno> aluno) {
		this.aluno = aluno;
	}
			
}
