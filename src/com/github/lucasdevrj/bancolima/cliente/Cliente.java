package com.github.lucasdevrj.bancolima.cliente;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public abstract class Cliente {

	private InformacoesPessoais informacoesPessoais;
	private Endereco endereco;
	
	public Cliente(InformacoesPessoais informacoesPessoais, Endereco endereco) {
		this.informacoesPessoais = informacoesPessoais;
		this.endereco = endereco;
	}
	
	public InformacoesPessoais getInformacoesPessoais() {
		return informacoesPessoais;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
}
