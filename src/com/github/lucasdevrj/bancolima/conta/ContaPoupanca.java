package com.github.lucasdevrj.bancolima.conta;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.excecao.SaldoInsuficiente;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class ContaPoupanca extends Conta {

	private double taxa = 0.04;
	
	public ContaPoupanca(Cliente titular, String agencia, String numero, float saldo) throws Exception {
		super(titular, agencia, numero, saldo);
	}
	
	public void investir(float valor, int meses) throws Exception {
		if (super.saldo >= valor) {
			if (meses > 0) {
				float valorRetornado = (float) (valor * meses * this.taxa);
				super.saldo += valorRetornado;
				OutputStream fos = new FileOutputStream("arquivo.txt");
				Writer osw = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(osw);
				
				bw.write("Valor investido: R$ " + valor);
				bw.newLine();
				bw.write("Meses investidos: " + meses);
				bw.newLine();
				bw.write("Valor retornado: R$ " + valorRetornado);
				bw.newLine();
				
				bw.close();
				
				LeituraArquivo.leArquivo();
			} else {
				throw new IllegalArgumentException("Digite um mes maior que zero!");
			}
		} else {
			throw new SaldoInsuficiente("Saldo insuficiente para fazer investimento!");
		}
	}

}
