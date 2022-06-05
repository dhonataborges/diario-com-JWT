package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Date;
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

@Entity
@Table(name = "atividade")
public class Atividade implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private Date data_criacao;
	private Date data_entrega;
	private Integer nota_maxima;
	private String descricao;
	private String tipo;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "professor_turma_disciplina_id")
	private ProfessorTurmaDisciplina professorTurmaDisciplina;
	
	@OneToMany(mappedBy = "atividade", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<AlunoAtividade> alunoAtividade;
	
	public Atividade() {
		super();
	}

	public Atividade(Integer id, Date data_criacao, Date data_entrega, Integer nota_maxima, String descricao,
			Integer bimestre, String tipo, ProfessorTurmaDisciplina professorTurmaDisciplina) {
		super();
		this.id = id;
		this.data_criacao = data_criacao;
		this.data_entrega = data_entrega;
		this.nota_maxima = nota_maxima;
		this.descricao = descricao;
		this.tipo = tipo;
		this.professorTurmaDisciplina = professorTurmaDisciplina;
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
		Atividade other = (Atividade) obj;
		return Objects.equals(id, other.id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getData_criacao() {
		return data_criacao;
	}

	public void setData_criacao(Date data_criacao) {
		this.data_criacao = data_criacao;
	}

	public Date getData_entrega() {
		return data_entrega;
	}

	public void setData_entrega(Date data_entrega) {
		this.data_entrega = data_entrega;
	}

	public Integer getNota_maxima() {
		return nota_maxima;
	}

	public void setNota_maxima(Integer nota_maxima) {
		this.nota_maxima = nota_maxima;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
		
	public ProfessorTurmaDisciplina getProfessorTurmaDisciplina() {
		return professorTurmaDisciplina;
	}

	public void setProfessorTurmaDisciplina(ProfessorTurmaDisciplina professorTurmaDisciplina) {
		this.professorTurmaDisciplina = professorTurmaDisciplina;
	}

	public List<AlunoAtividade> getAlunoAtividade() {
		return alunoAtividade;
	}
	public void setAlunoAtividade(List<AlunoAtividade> alunoAtividade) {
		this.alunoAtividade = alunoAtividade;
	}
		
}
