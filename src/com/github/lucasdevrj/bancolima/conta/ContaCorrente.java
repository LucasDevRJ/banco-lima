package com.github.lucasdevrj.bancolima.conta;

import com.github.lucasdevrj.bancolima.cliente.Cliente;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente titular, float saldo) {
		super(titular, saldo);
	}
}
