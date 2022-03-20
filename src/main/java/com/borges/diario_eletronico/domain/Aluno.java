package com.borges.diario_eletronico.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.OneToMany;

import com.borges.diario_eletronico.domain.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Aluno extends Pessoa {
	private static final long serialVersionUID = 1L;

	@JsonIgnore
	@OneToMany(mappedBy = "aluno")
	//@JoinColumn(name = "aluno")
	private List<Turma> turma = new ArrayList<>();
	
	private String disciplinas;

	public Aluno() {
		super();
		addPerfil(Perfil.ALUNO);
	}

	public Aluno(Integer id, String nome, Date nascimento, String sexo, String cpf, String rg, String telefone,
			String endereco, Integer numero, String bairro, String cep, String cidade, String estado, String zona, String email, String senha) {
		super( id, nome, nascimento, sexo, cpf, rg, telefone, endereco, numero, bairro, cep, cidade,
				estado, zona, email, senha);
				addPerfil(Perfil.ALUNO);
	}
	
	
	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	public String getDisciplinas() {
		return disciplinas;
	}

	public void setDisciplinas(String disciplinas) {
		this.disciplinas = disciplinas;
	}

}
