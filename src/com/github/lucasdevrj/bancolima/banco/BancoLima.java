package com.github.lucasdevrj.bancolima.banco;

import java.io.IOException;
import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.excecao.ContasIguais;

public class BancoLima {

	private String nome;
	private Endereco endereco;
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public void exibeContas() throws IOException {
		
		for (int i = 0; i < contas.size(); i++) {
			System.out.println(contas.toString());
			System.out.println();
		}
	}
	
	public void adicionaConta(Conta conta) throws ContasIguais {
		if (this.contas.equals(conta)) {
			this.contas.add(conta);
		} else {
			throw new ContasIguais("Existem contas iguais!\nNão pode criar mais de uma conta com o mesmo número de agência e número da conta.");
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public ArrayList<Conta> getContas() {
		return contas;
	}
}
