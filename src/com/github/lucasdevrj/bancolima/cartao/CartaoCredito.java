package com.github.lucasdevrj.bancolima.cartao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.excecao.ContaInativa;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class CartaoCredito extends Cartao {
	
	private float credito = 0.0f;
	private float limite;
	private Cliente proprietario;

	public CartaoCredito(String numero, String validade, int codigo, int senha, float limite, Cliente proprietario) {
		super(numero, validade, codigo, senha);
		this.limite = limite;
		this.proprietario = proprietario;
	}
	
	public void comprarComCartaoCredito(String produto, float valor) throws ContaInativa, IOException {
		if (this.credito < limite) {
			this.credito += valor;
			this.limite -= valor;
			
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
			
		}
	}
	
	public float getCredito() {
		return credito;
	}
	
	public float getLimite() {
		return limite;
	}
	
	public Cliente getProprietario() {
		return proprietario;
	}

}
