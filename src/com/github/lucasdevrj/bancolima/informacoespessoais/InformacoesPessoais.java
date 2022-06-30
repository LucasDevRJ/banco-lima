package com.github.lucasdevrj.bancolima.informacoespessoais;

public class InformacoesPessoais {

	private String nome;
	private String sobrenome;
	private String dataNascimento;
	private String cpf;
	private String rg;
	private String nacionalidade;
	
	public InformacoesPessoais(String nome, String sobrenome, String dataNascimento, String cpf, String rg, String nacionalidade) {
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.dataNascimento = dataNascimento;
		this.cpf = cpf;
		this.rg = rg;
		this.nacionalidade = nacionalidade;
	}
	
	public String getNome() {
		return nome;
	}
	
	public String getSobrenome() {
		return sobrenome;
	}
	
	public String getDataNascimento() {
		return dataNascimento;
	}
	
	public String getCpf() {
		return cpf;
	}
	
	public String getRg() {
		return rg;
	}
	
	public String getNacionalidade() {
		return nacionalidade;
	}
}
