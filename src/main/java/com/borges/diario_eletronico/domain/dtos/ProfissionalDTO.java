package com.borges.diario_eletronico.domain.dtos;

import java.io.Serializable;
import java.util.Date;
import java.util.stream.Collectors;

import javax.persistence.Column;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import com.borges.diario_eletronico.domain.Profissional;

public class ProfissionalDTO implements Serializable{
	private static final long serialVersionUID = 1L;

	private Integer id;
	
	//@NotBlank(message = "Campo NOME não pode ser vasio!")
	private String nome;

	//@NotNull(message = "Campo NASCIMENTO não pode ser vasio!")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Temporal(TemporalType.DATE)
	@Column(name = "nascimento")
	private Date nascimento;

	//@NotBlank(message = "Campo SEXO não pode ser vasio!")
	private String sexo;

	
	//@NotBlank(message = "Campo CPF não pode ser vasio!")
	private String cpf;

	//@NotBlank(message = "Campo RG não pode ser vasio!")
	@Length(max = 12, message = "O RG não pode ser maior que {max} caracteres!")
	@Column(name = "rg", length = 12, nullable = false)
	private String rg;

	//@NotBlank(message = "Campo TELEFONE não pode ser vasio!")
	private String telefone;

	//@NotBlank(message = "Campo ENDEREÇO não pode ser vasio!")
	private String endereco;

	//@NotNull(message = "Campo NÚMERO não pode ser vasio!")
	private Integer numero;

	//@NotBlank(message = "Campo BAIRRO não pode ser vasio!")
	private String bairro;

	//@NotBlank(message = "Campo CEP não pode ser vasio!")
	private String cep;

	//@NotBlank(message = "Campo CIDADE não pode ser vasio!")
	private String cidade;

	//@NotBlank(message = "Campo ESTADO não pode ser vasio!")
	private String estado;

	//@NotBlank(message = "Campo ZONA não pode ser vasio!")
	private String zona;
	
	private Integer turma;
	private String nomeTurma;

	public ProfissionalDTO() {
		super();
	}
	
	public ProfissionalDTO(Profissional obj) {

		super();
		this.id = obj.getId();
		this.nome = obj.getNome();
		this.nascimento = obj.getNascimento();
		this.sexo = obj.getSexo();
		this.cpf = obj.getCpf();
		this.rg = obj.getRg();
		this.telefone = obj.getTelefone();
		this.endereco = obj.getEndereco();
		this.numero = obj.getNumero();
		this.bairro = obj.getBairro();
		this.cep = obj.getCep();
		this.cidade = obj.getCidade();
		this.estado = obj.getEstado();
		this.zona = obj.getZona();
		this.turma = obj.getTurma().stream().map(x -> x.getId()).collect(Collectors.toList()).hashCode();
		this.nomeTurma = obj.getTurma().stream().map(i -> i.getNomeTurma()).collect(Collectors.toList()).toString();
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Date getNascimento() {
		return nascimento;
	}

	public void setNascimento(Date nascimento) {
		this.nascimento = nascimento;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public String getZona() {
		return zona;
	}

	public void setZona(String zona) {
		this.zona = zona;
	}

	public Integer getTurma() {
		return turma;
	}

	public void setTurma(Integer turma) {
		this.turma = turma;
	}

	public String getNomeTurma() {
		return nomeTurma;
	}

	public void setNomeTurma(String nomeTurma) {
		this.nomeTurma = nomeTurma;
	}
		
	
}
