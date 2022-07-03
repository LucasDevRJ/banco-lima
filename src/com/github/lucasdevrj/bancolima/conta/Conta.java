package com.github.lucasdevrj.bancolima.conta;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.excecao.ContaInvalida;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public abstract class Conta {

	private Cliente titular;
	protected float saldo;
	private String agencia;
	private String numero;
	
	public Conta(Cliente titular, String agencia, String numero, float saldo) throws Exception {
		if (agencia.length() == 2 && numero.length() == 5 && saldo >= 0) {
			this.titular = titular;
			this.agencia = agencia;
			this.numero = numero;
			this.saldo = saldo;
		} else {
			throw new ContaInvalida("Agência, número ou saldo informados são inválidos!\nAgência tem que ter apenas dois digitos, número apenas cinco digitos e saldo tem que ser maior ou igual a zero.");
		}
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
	
	public String getAgencia() {
		return agencia;
	}
	
	public String getNumero() {
		return numero;
	}
}
