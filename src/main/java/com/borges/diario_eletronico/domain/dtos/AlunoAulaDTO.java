package com.borges.diario_eletronico.domain.dtos;

import java.time.LocalDate;
import java.util.BitSet;

import com.borges.diario_eletronico.domain.AlunoAula;

public class AlunoAulaDTO {
	
	private Integer id;
    private BitSet frequencia;
    private Integer aula;
    private LocalDate aulaData;
    private Integer aluno;
    private String nomeAluno;
    
    
	public AlunoAulaDTO() {
		super();
	}
	
	public AlunoAulaDTO(AlunoAula obj) {
		super();
		this.id = obj.getId();
		this.frequencia = obj.getFrequencia();
		this.aula = obj.getAula().getId();
		this.aulaData = obj.getAula().getData();
		this.aluno = obj.getAluno().getId();
		this.nomeAluno = obj.getAluno().getNome();
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
	public Integer getAula() {
		return aula;
	}
	public void setAula(Integer aula) {
		this.aula = aula;
	}
	public LocalDate getAulaData() {
		return aulaData;
	}
	public void setAulaData(LocalDate aulaData) {
		this.aulaData = aulaData;
	}
	public Integer getAluno() {
		return aluno;
	}
	public void setAluno(Integer aluno) {
		this.aluno = aluno;
	}
	public String getNomeAluno() {
		return nomeAluno;
	}
	public void setNomeAluno(String nomeAluno) {
		this.nomeAluno = nomeAluno;
	}
    
}
