package com.borges.diario_eletronico.domain;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Cargo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String nomeCargo;

	private String profissionais;

	public Cargo() {
		super();
	}

	public Cargo(Integer id, String nomeCargo, String profissionais) {
		super();
		this.id = id;
		this.nomeCargo = nomeCargo;
		this.profissionais = profissionais;
	}

	public Cargo(Cargo obj) {
		super();
		this.id = obj.getId();
		this.nomeCargo = obj.getNomeCargo();
		this.profissionais = obj.getProfissionais();
	}

	@Override
	public String toString() {
		return "Cargo [id=" + id + ", nomeCargo=" + nomeCargo + ", profissionais=" + profissionais + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNomeCargo() {
		return nomeCargo;
	}

	public void setNomeCargo(String nomeCargo) {
		this.nomeCargo = nomeCargo;
	}

	public String getProfissionais() {
		return profissionais;
	}

	public void setProfissionais(String profissionais) {
		this.profissionais = profissionais;
	}

}
