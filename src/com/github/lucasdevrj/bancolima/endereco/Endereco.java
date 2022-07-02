package com.github.lucasdevrj.bancolima.endereco;

public class Endereco {

	private String cep;
	private String cidade;
	private String estado;
	private String bairro;
	private String rua;
	private int numero;
	private String referencia;
	private String complemento;

	public Endereco(String cep, String cidade, String estado, String bairro, String rua, int numero, String referencia, String complemento) {
		if (cep.length() > 0 && cidade.length() > 0 && estado.length() > 0 && bairro.length() > 0 && rua.length() > 0 && numero > 0 && referencia.length() > 0 && complemento.length() > 0) {
			this.cep = cep;
			this.cidade = cidade;
			this.estado = estado;
			this.bairro = bairro;
			this.rua = rua;
			this.numero = numero;
			this.referencia = referencia;
			this.complemento = complemento;
		} else {
			throw new NullPointerException("Insira todas as informações do endereço!");
		}
	}

	public String getCep() {
		return cep;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

	public String getBairro() {
		return bairro;
	}

	public String getRua() {
		return rua;
	}

	public int getNumero() {
		return numero;
	}

	public String getReferencia() {
		return referencia;
	}

	public String getComplemento() {
		return complemento;
	}
}
