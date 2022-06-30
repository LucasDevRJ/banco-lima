package com.github.lucasdevrj.bancolima.cliente;

import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public class ClienteFisico extends Cliente {

	public ClienteFisico(InformacoesPessoais informacoesPessoais, Endereco endereco) {
		super(informacoesPessoais, endereco);
	}

}
