package com.github.lucasdevrj.bancolima.cartao;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class CartaoDebito extends Cartao {


	public CartaoDebito(String numero, String validade, int codigo, int senha, Conta titular) {
		super(numero, validade, codigo, senha, titular);
	}

	@Override
	public void comprarComCartao(String produto, float valor) throws Exception, IOException {
		super.getTitular().setSaldo(super.getTitular().getSaldo() - valor);
		super.getProdutos().add(produto);
		super.getValores().add(valor);
		
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
	}

}
