package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.BitSet;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "aluno_aula")
public class AlunoAula implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private BitSet frequencia;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aula_id")
	private Aula aula;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "aluno_id")
	private Aluno aluno;
	
	public AlunoAula() {
		super();
	}

	public AlunoAula(Integer id, BitSet frequencia, Aula aula, Aluno aluno) {
		super();
		this.id = id;
		this.frequencia = frequencia;
		this.aula = aula;
		this.aluno = aluno;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public BitSet getFrequencia() {
		return frequencia;
	}

	public void setFrequencia(BitSet frequencia) {
		this.frequencia = frequencia;
	}

	public Aula getAula() {
		return aula;
	}

	public void setAula(Aula aula) {
		this.aula = aula;
	}

	public Aluno getAluno() {
		return aluno;
	}

	public void setAluno(Aluno aluno) {
		this.aluno = aluno;
	}
		
}
