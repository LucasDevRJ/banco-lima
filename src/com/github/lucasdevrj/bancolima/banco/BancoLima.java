package com.github.lucasdevrj.bancolima.banco;

import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;

public class BancoLima {

	private String nome;
	private Endereco endereco;
	private ArrayList<Conta> contas = new ArrayList<>();
	
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
