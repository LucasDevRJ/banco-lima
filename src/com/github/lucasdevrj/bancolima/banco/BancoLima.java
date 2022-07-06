package com.github.lucasdevrj.bancolima.banco;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.util.ArrayList;

import com.github.lucasdevrj.bancolima.conta.Conta;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.excecao.ContasIguais;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class BancoLima {

	private String nome;
	private Endereco endereco;
	private ArrayList<Conta> contas = new ArrayList<Conta>();
	
	public void adicionaConta(Conta conta) throws ContasIguais {
		if (!this.contas.contains(conta)) {
			this.contas.add(conta);
		} else {
			throw new ContasIguais("Existem contas iguais!\nNão pode adicionar mais de uma conta com o mesmo número de agência e número da conta.");
		}
	}
	
	public void exibeContas() throws IOException {
		
		if (this.getContas().size() > -1) {
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			for (int i = 0; i < this.getContas().size(); i++) {
				bw.write(this.contas.toString());
				bw.newLine();
			}
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		}
	}
	
	public String getNome() {
		return nome;
	}
	
	public Endereco getEndereco() {
		return endereco;
	}
	
	public ArrayList<Conta> getContas() {
		return contas;
	}
}
