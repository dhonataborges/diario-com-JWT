package com.borges.diario_eletronico.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;

import com.borges.diario_eletronico.domain.enums.Perfil;

@Entity
public class Profissional extends Pessoa implements Serializable {
	private static final long serialVersionUID = 1L;

	@ManyToMany(mappedBy="professor", cascade = CascadeType.ALL)
	private List<Turma> turma = new ArrayList<>();

	public Profissional() {
		super();
	}

	public Profissional(Integer id, String nome, Date nascimento, String sexo, String cpf, String rg, String telefone,
			String endereco, Integer numero, String bairro, String cep, String cidade, String estado, String zona, String email, String senha) {
		super(id, nome, nascimento, sexo, cpf, rg, telefone, endereco, numero, bairro, cep, cidade,
				estado, zona, email, senha);
		addPerfil(Perfil.PROFESSOR);

	}

	public List<Turma> getTurma() {
		return turma;
	}

	public void setTurma(List<Turma> turma) {
		this.turma = turma;
	}

	
}
