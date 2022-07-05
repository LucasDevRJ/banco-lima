package com.github.lucasdevrj.bancolima.cliente;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cartao.Cartao;
import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.excecao.ContaInativa;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public abstract class Cliente {

	private InformacoesPessoais informacoesPessoais;
	private Endereco endereco;
	private boolean possuiCartaoCredito;
	private Conta titular;
	private Cartao proprietario;
	
	public Cliente(InformacoesPessoais informacoesPessoais, Endereco endereco, Conta titular, Cartao proprietario) {
		this.informacoesPessoais = informacoesPessoais;
		this.endereco = endereco;
		this.titular = titular;
		this.proprietario = proprietario;
	}
	
	public void comprarComCartaoCredito(String produto, float valor) throws ContaInativa, IOException {
		if (titular.isEstaAtiva() == true) {
			if (isPossuiCartaoCredito() == true) {
				
				OutputStream fos = new FileOutputStream("arquivo.txt");
				Writer wt = new OutputStreamWriter(fos);
				BufferedWriter bw = new BufferedWriter(wt);
				
				bw.write("Compra realizada com sucesso!");
				bw.newLine();
				bw.write("Produto: " + produto);
				bw.newLine();
				bw.write("Valor da Compra: R$ " + valor);
			}
		} else {
			throw new ContaInativa("A conta está inativa!\nAtive a conta para comprar com cartão de crédito.");
		}
	}
	
	public InformacoesPessoais getInformacoesPessoais() {
		return informacoesPessoais;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public boolean isPossuiCartaoCredito() {
		return possuiCartaoCredito;
	}
	
	public Cartao getProprietario() {
		return proprietario;
	}
}
