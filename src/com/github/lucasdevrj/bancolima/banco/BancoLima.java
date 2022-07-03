package com.github.lucasdevrj.bancolima.banco;

import java.io.IOException;
import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;

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
	
	public void adicionaConta(Conta conta) {
		this.contas.add(conta);
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
