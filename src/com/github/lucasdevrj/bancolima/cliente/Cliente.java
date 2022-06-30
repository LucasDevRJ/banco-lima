package com.github.lucasdevrj.bancolima.cliente;

import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public abstract class Cliente {

	private InformacoesPessoais informacoesPessoais;
	private Endereco endereco;
	private float saldo;
	
	public Cliente(InformacoesPessoais informacoesPessoais, Endereco endereco, float saldo) {
		this.informacoesPessoais = informacoesPessoais;
		this.endereco = endereco;
		this.saldo = saldo;
	}
	
	public InformacoesPessoais getInformacoesPessoais() {
		return informacoesPessoais;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public float getSaldo() {
		return saldo;
	}
}
