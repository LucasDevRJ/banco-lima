package com.github.lucasdevrj.bancolima.cartao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.excecao.SaldoInsuficiente;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class CartaoDebito extends Cartao {
	
	private float valorExtrato;

	public CartaoDebito(String numero, String validade, int codigo, int senha, Conta titular) {
		super(numero, validade, codigo, senha, titular);
	}

	@Override
	public void comprarComCartao(String produto, float valor) throws Exception, IOException {
		if (super.getTitular().getSaldo() > valor) {
			super.getTitular().setSaldo(super.getTitular().getSaldo() - valor);
			super.getProdutos().add(produto);
			super.getValores().add(valor);
			this.valorExtrato += valor;
			
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Compra realizada com sucesso!");
			bw.newLine();
			bw.write("Produto: " + produto);
			bw.newLine();
			bw.write("Valor: R$ " + valor);
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new SaldoInsuficiente("Saldo insuficiente para comprar com cart�o de d�bito!");
		}
	}
	
	public void exibirExtrato() throws IOException {
		if (super.getProdutos().size() > -1) {
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Extrato do cart�o de d�bito");
			bw.newLine();
			
			for (int i = 0; i < super.getProdutos().size(); i++) {
				bw.write("Produto: " + super.getProdutos().get(i));
				bw.newLine();
				bw.write("Valor: R$ " + super.getValores().get(i));
				bw.newLine();
			}
			
			bw.write("Valor total do extrato: " + this.valorExtrato);
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		}
	}
	
	public void exibirDebito() throws Exception {
		OutputStream fos = new FileOutputStream("arquivo.txt");
		Writer wt = new OutputStreamWriter(fos);
		BufferedWriter bw = new BufferedWriter(wt);
		
		bw.write("Valor total do saldo: R$ " + super.getTitular().getSaldo());
		
		bw.close();
		
		LeituraArquivo.leArquivo();
	}

}
