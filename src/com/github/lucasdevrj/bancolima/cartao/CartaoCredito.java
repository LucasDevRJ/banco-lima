package com.github.lucasdevrj.bancolima.cartao;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.excecao.ContaInativa;
import com.github.lucasdevrj.bancolima.excecao.LimiteUltrapassado;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class CartaoCredito extends Cartao {
	
	private float credito = 0.0f;
	private float limite;
	private Conta titular;
	private ArrayList<String> produtos = new ArrayList<String>();
	private ArrayList<Float> valores = new ArrayList<Float>();
	private float valorFatura;

	public CartaoCredito(String numero, String validade, int codigo, int senha, float limite, Conta titular) {
		super(numero, validade, codigo, senha);
		this.limite = limite;
		this.titular = titular;
	}
	
	public void comprarComCartaoCredito(String produto, float valor) throws ContaInativa, IOException, LimiteUltrapassado {
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
	
	public void pagarFatura() throws IOException {
		if (this.titular.getSaldo() >= this.valorFatura) {
			this.titular.setSaldo(this.titular.getSaldo() - this.valorFatura);
			
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Fatura paga com sucesso!");
			bw.newLine();
			bw.write("Valor total da fatura: R$ " + this.valorFatura);
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		}
	}
	
	public float getCredito() {
		return credito;
	}
	
	public float getLimite() {
		return limite;
	}
	
	public Conta getTitular() {
		return titular;
	}
}
