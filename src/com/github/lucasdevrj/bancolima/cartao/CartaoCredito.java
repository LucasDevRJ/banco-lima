package com.github.lucasdevrj.bancolima.cartao;

public class CartaoCredito extends Cartao {
	
	private float credito;

	public CartaoCredito(String numero, String validade, int codigo, int senha, float credito) {
		super(numero, validade, codigo, senha);
		this.credito = credito;
	}
	
	public float getCredito() {
		return credito;
	}

}
