package com.github.lucasdevrj.bancolima.banco;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;

public class BancoLima {

	private String nome;
	private Endereco endereco;
	private ArrayList<Conta> contas = new ArrayList<>();
	
	public void exibeContas() throws IOException {
		
		OutputStream fos = new FileOutputStream("arquivo.txt");
		Writer wt = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(wt);
		
		for (int i = 0; i < contas.size(); i++) {
			bw.write("");
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
