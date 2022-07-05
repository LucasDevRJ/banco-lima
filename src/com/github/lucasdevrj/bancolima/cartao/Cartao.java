package com.github.lucasdevrj.bancolima.cartao;

public abstract class Cartao {

	private String numero;
	private String validade;
	private int codigo;
	private int senha;
	
	public Cartao(String numero, String validade, int codigo, int senha) {
		this.numero = numero;
		this.validade = validade;
		this.codigo = codigo;
		this.senha = senha;
	}
	
	public String getNumero() {
		return numero;
	}
	
	public String getValidade() {
		return validade;
	}
	
	public int getCodigo() {
		return codigo;
	}
	
	public int getSenha() {
		return senha;
	}
}
