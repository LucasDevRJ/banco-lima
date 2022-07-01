package com.github.lucasdevrj.bancolima.conta;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.excecao.SaldoInsuficiente;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente titular, float saldo) {
		super(titular, saldo);
	}
	
	public void transfere(ContaCorrente contaRecebedora, float valorTransferencia) throws IOException, Exception {
		if (super.getSaldo() >= valorTransferencia) {
			super.saldo -= valorTransferencia;
			contaRecebedora.saldo += valorTransferencia;
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("Valor transferido com sucesso!");
			bw.newLine();
			bw.write("Valor transferido: R$ " + valorTransferencia);
			bw.newLine();
			bw.write("Recebedor: " + contaRecebedora.getTitular().getInformacoesPessoais().getNome() + " " + contaRecebedora.getTitular().getInformacoesPessoais().getSobrenome());
			bw.newLine();
			bw.write("CPF do Recebedor: " + contaRecebedora.getTitular().getInformacoesPessoais().getCpf());
			bw.newLine();
			bw.newLine();
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new SaldoInsuficiente("Saldo insuficiente para fazer a transferência!");
		}
	}
}
