package com.github.lucasdevrj.bancolima.cartao;

import java.io.IOException;
import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;

public abstract class Cartao {

	private String numero;
	private String validade;
	private int codigo;
	private int senha;
	private Conta titular;
	private ArrayList<String> produtos = new ArrayList<String>();
	private ArrayList<Float> valores = new ArrayList<Float>();
	
	public Cartao(String numero, String validade, int codigo, int senha, Conta titular) {
		this.numero = numero;
		this.validade = validade;
		this.codigo = codigo;
		this.senha = senha;
		this.titular = titular;
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
	
	public Conta getTitular() {
		return titular;
	}
	
	public ArrayList<String> getProdutos() {
		return produtos;
	}
	
	public ArrayList<Float> getValores() {
		return valores;
	}
}
