package com.github.lucasdevrj.bancolima.cliente;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public class ClienteFisico extends Cliente {
	
	private String classificacao;

	public ClienteFisico(InformacoesPessoais informacoesPessoais, Endereco endereco, String classificacao) {
		super(informacoesPessoais, endereco);
		this.classificacao = classificacao;
	}
	
	public String getClassificacao() {
		return classificacao;
	}

}
