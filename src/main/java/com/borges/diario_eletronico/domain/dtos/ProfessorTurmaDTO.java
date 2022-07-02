package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import com.borges.diario_eletronico.domain.ProfessorTurma;

public class ProfessorTurmaDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	private Integer turma;
	private String descricaoTurma;
	private Integer displina;
	private String nomeDisciplina;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	private Date dataAtribuicao;
	private Integer status;
	
	public ProfessorTurmaDTO() {
		super();
	}

	public ProfessorTurmaDTO(ProfessorTurma obj) {
		super();
		this.id = obj.getId();
		this.turma = obj.getTurma().getId();
		this.descricaoTurma = obj.getTurma().getSerieNivelSubnivel().getDescricao().toString();
		this.displina = obj.getProfessor().getId();
		this.nomeDisciplina = obj.getProfessor().getNome();
		this.dataAtribuicao = obj.getData_atribuicao();
		this.status = obj.getStatus().getCodigo();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getTurma() {
		return turma;
	}

	public void setTurma(Integer turma) {
		this.turma = turma;
	}

	public String getDescricaoTurma() {
		return descricaoTurma;
	}

	public void setDescricaoTurma(String descricaoTurma) {
		this.descricaoTurma = descricaoTurma;
	}

	public Integer getDisplina() {
		return displina;
	}

	public void setDisplina(Integer displina) {
		this.displina = displina;
	}

	public String getNomeDisciplina() {
		return nomeDisciplina;
	}

	public void setNomeDisciplina(String nomeDisciplina) {
		this.nomeDisciplina = nomeDisciplina;
	}

	public Date getDataAtribuicao() {
		return dataAtribuicao;
	}

	public void setDataAtribuicao(Date dataAtribuicao) {
		this.dataAtribuicao = dataAtribuicao;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
		
}
