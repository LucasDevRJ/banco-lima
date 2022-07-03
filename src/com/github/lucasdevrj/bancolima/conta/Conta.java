package com.github.lucasdevrj.bancolima.conta;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public abstract class Conta {

	private Cliente titular;
	protected float saldo;
	private int agencia;
	private int numero;
	
	public Conta(Cliente titular, int agencia, int numero, float saldo) {
		this.titular = titular;
		this.saldo = saldo;
	}

	public void deposita(float valor) throws IOException {
		if (valor > 0) {
			this.saldo += valor;
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Deposito concluido com sucesso!");
			bw.newLine();
			bw.write("Valor do deposito: R$ " + valor);
			bw.newLine();
			bw.newLine();
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new IllegalArgumentException("Valor inválido para depósito!");
		}
		
	}
	
	public Cliente getTitular() {
		return titular;
	}
	
	public float getSaldo() {
		return saldo;
	}
	
	public int getAgencia() {
		return agencia;
	}
	
	public int getNumero() {
		return numero;
	}
	
	@Override
	public String toString() {
		return "Informações da Conta\nNome: " + titular.getInformacoesPessoais().getNome() + "\nSobrenome: " + titular.getInformacoesPessoais().getSobrenome() + "\nCPF: " + titular.getInformacoesPessoais().getCpf() + "\nSaldo: R$ " + this.saldo + "\n";
	}
}
