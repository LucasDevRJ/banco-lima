package com.github.lucasdevrj.bancolima.conta;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cliente.Cliente;

public abstract class Conta {

	private Cliente titular;
	private float saldo;
	
	public void deposita(float valor) throws IOException {
		this.saldo += valor;
		OutputStream fos = new FileOutputStream("arquivo.txt");
		Writer wt = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(wt);
		
		bw.write("Deposito concluido com sucesso!");
		bw.newLine();
		bw.write("Valor do deposito: R$ " + valor);
		bw.newLine();
		
		bw.close();
		
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public float getSaldo() {
		return saldo;
	}
}
