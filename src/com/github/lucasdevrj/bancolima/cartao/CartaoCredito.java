package com.github.lucasdevrj.bancolima.cartao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
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
			this.getProdutos().add(produto);
			this.getValores().add(valor);
			
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("----------|Compra realizada com cartão|----------");
			bw.newLine();
			bw.write("Compra realizada com sucesso!");
			bw.newLine();
			bw.write("Produto: " + produto);
			bw.newLine();
			bw.write("Valor da Compra: R$ " + valor);
			bw.newLine();
			bw.write("------------------------------------------------");
			
			bw.close();
			
			LeituraArquivo.leArquivo();
				
		} else {
			throw new LimiteUltrapassado("Limite do cartão ultrapassado!\nNão compre mais do que o limite de créditos disponíveis.");
		}
	}
	
	public void exibirFatura() throws IOException {
		if (this.getProdutos().size() > -1) {
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("----------|Fatura do cartão de crédito|----------");
			bw.newLine();
			
			for (int i = 0; i < this.getProdutos().size(); i++) {
				this.valorFatura += this.getValores().get(i);
				bw.write("Produto: " + this.getProdutos().get(i));
				bw.newLine();
				bw.write("Valor: R$ " + this.getValores().get(i));
				bw.newLine();
			}
			
			bw.write("Valor total: R$ " + this.valorFatura);
			bw.newLine();
			bw.write("------------------------------------------------");
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new ArrayIndexOutOfBoundsException("Não foi comprado nada no cartão de crédito!");
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
			
			this.valorFatura = 0.0f;
			this.getProdutos().clear();
			this.getValores().clear();
			
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
	
	public float getValorFatura() {
		return valorFatura;
	}
}
