package com.github.lucasdevrj.bancolima.cartao;

import java.io.IOException;

import com.github.lucasdevrj.bancolima.excecao.ContaInativa;
import com.github.lucasdevrj.bancolima.excecao.LimiteUltrapassado;

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
	
	public abstract void comprarComCartao(String produto, float valor) throws Exception, IOException;
	
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
