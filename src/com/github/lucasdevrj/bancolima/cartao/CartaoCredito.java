package com.github.lucasdevrj.bancolima.cartao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.excecao.LimiteUltrapassado;
import com.github.lucasdevrj.bancolima.excecao.SaldoInsuficiente;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class CartaoCredito extends Cartao {
	
	private float credito = 0.0f;
	private float limite;
	private float valorFatura;

	public CartaoCredito(String numero, String validade, int codigo, int senha, float limite, Conta titular) {
		super(numero, validade, codigo, senha, titular);
		this.limite = limite;
	}
	
	public void comprarComCartao(String produto, float valor) throws Exception, IOException{
		if (this.credito < limite) {
			this.credito += valor;
			this.limite -= valor;
			this.produtos.add(produto);
			this.valores.add(valor);
			
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Compra realizada com sucesso!");
			bw.newLine();
			bw.write("Produto: " + produto);
			bw.newLine();
			bw.write("Valor da Compra: R$ " + valor);
			
			bw.close();
			
			LeituraArquivo.leArquivo();
				
		} else {
			throw new LimiteUltrapassado("Limite do cart�o ultrapassado!\nN�o compre mais do que o limite de cr�ditos dispon�veis.");
		}
	}
	
	public void exibirFatura() throws IOException {
		if (this.produtos.size() > -1) {
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Fatura do cart�o de cr�dito");
			bw.newLine();
			
			for (int i = 0; i < this.produtos.size(); i++) {
				this.valorFatura += this.valores.get(i);
				bw.write("Produto: " + this.produtos.get(i));
				bw.newLine();
				bw.write("Valor: R$ " + this.valores.get(i));
				bw.newLine();
			}
			
			bw.write("Valor total: R$ " + this.valorFatura);
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new ArrayIndexOutOfBoundsException("N�o foi comprado nada no cart�o de cr�dito!");
		}
	}
	
	public void pagarFatura() throws IOException, SaldoInsuficiente {
		if (this.getTitular().getSaldo() >= this.valorFatura) {
			super.getTitular().setSaldo(super.getTitular().getSaldo() - this.valorFatura);
			
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Fatura paga com sucesso!");
			bw.newLine();
			bw.write("Valor total da fatura: R$ " + this.valorFatura);
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new SaldoInsuficiente("Saldo insuficiente para pagar a fatura!");
		}
	}
	
	public float getCredito() {
		return credito;
	}
	
	public float getLimite() {
		return limite;
	}
}
