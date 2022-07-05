package com.github.lucasdevrj.bancolima.cliente;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public class ClienteJuridico extends Cliente {
	
	private String cnpj;
	private String empresa;
	private String ramo;

	public ClienteJuridico(InformacoesPessoais informacoesPessoais, Endereco endereco, String cnpj, String empresa, String ramo) {
		super(informacoesPessoais, endereco);
		this.cnpj = cnpj;
		this.empresa = empresa;
		this.ramo = ramo;
	}
	
	public String getCnpj() {
		return cnpj;
	}
	
	public String getEmpresa() {
		return empresa;
	}
	
	public String getRamo() {
		return ramo;
	}

}
