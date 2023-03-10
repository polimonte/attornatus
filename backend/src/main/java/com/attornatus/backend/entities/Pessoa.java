package com.attornatus.backend.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tb_pessoas")
public class Pessoa {
	
	@Id
	@Column(name = "id_pessoa")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id_pessoa;
	@Column(name = "nome")
	private String nome;
	@Column(name = "datadeaniversario")
	private String dataDeAniversario;
	@Column(name = "logradouro")
	private String logradouro;
	@Column(name = "cep")
	private String cep;
	@Column(name = "numero")
	private String numero;
	@Column(name = "cidade")
	private String cidade;
	
	public Pessoa() {
	}

	public Pessoa(String nome, String dataDeAniversario, String logradouro, String cep, String numero, String cidade) {
		this.nome = nome;
		this.dataDeAniversario = dataDeAniversario;
		this.logradouro = logradouro;
		this.cep = cep;
		this.numero = numero;
		this.cidade = cidade;
	}

	
	public Long getId_pessoa() {
		return id_pessoa;
	}

	public void setId_pessoa(Long id_pessoa) {
		this.id_pessoa = id_pessoa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDataDeAniversario() {
		return dataDeAniversario;
	}

	public void setDataDeAniversario(String dataDeAniversario) {
		this.dataDeAniversario = dataDeAniversario;
	}

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	
}