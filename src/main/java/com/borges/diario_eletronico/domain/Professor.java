package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

import com.borges.diario_eletronico.domain.dtos.ProfessorDTO;

@Entity
public class Professor extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@OneToMany(mappedBy = "professor", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<ProfessorTurma> professorTurma;
	
	public Professor() {
		super();
	}

	public Professor(Integer id, String nome, Date nascimento, String sexo, String cpf, String rg, String telefone,
			String endereco, String zona, String email, String senha) {
		super(id, nome, nascimento, sexo, cpf, rg, telefone, endereco, zona, email, senha);

	}
	
	public Professor(ProfessorDTO obj) {
		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.nascimento = obj.getNascimento();
		this.sexo = obj.getSexo();
		this.cpf = obj.getCpf();
		this.rg = obj.getRg();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();		
		this.zona = obj.getZona();
		this.email = obj.getEmail();
		this.senha = obj.getSenha();
		this.perfis = obj.getPerfis().stream().map(x -> x.getCodigo()).collect(Collectors.toSet());
	}
	public List<ProfessorTurma> getProfessorTurma() {
		return professorTurma;
	}

	public void setProfessorTurma(List<ProfessorTurma> professorTurma) {
		this.professorTurma = professorTurma;
	}

}
