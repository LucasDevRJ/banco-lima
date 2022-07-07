package com.github.lucasdevrj.bancolima.conta;

import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.excecao.ContaInativa;
import com.github.lucasdevrj.bancolima.excecao.SaldoInsuficiente;
import com.github.lucasdevrj.bancolima.leituraarquivo.LeituraArquivo;

public class ContaCorrente extends Conta {
	
	public ContaCorrente(Cliente titular, String agencia, String numero, float saldo) throws Exception {
		super(titular, agencia, numero, saldo);
	}

	public void transfere(ContaCorrente contaRecebedora, float valorTransferencia) throws IOException, Exception {
		if (super.getSaldo() >= valorTransferencia) {
			super.saldo -= valorTransferencia;
			contaRecebedora.saldo += valorTransferencia;
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("----------|Transferência bancária|----------");
			bw.newLine();
			bw.write("Valor transferido com sucesso!");
			bw.newLine();
			bw.write("Titular da transferência: " + this.getTitular().getInformacoesPessoais().getNome() + " " + this.getTitular().getInformacoesPessoais().getSobrenome());
			bw.newLine();
			bw.write("Valor transferido: R$ " + valorTransferencia);
			bw.newLine();
			bw.write("Recebedor: " + contaRecebedora.getTitular().getInformacoesPessoais().getNome() + " " + contaRecebedora.getTitular().getInformacoesPessoais().getSobrenome());
			bw.newLine();
			bw.write("CPF do Recebedor: " + contaRecebedora.getTitular().getInformacoesPessoais().getCpf());
			bw.newLine();
			bw.write("--------------------------------------------");
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new SaldoInsuficiente("Saldo insuficiente para fazer a transferência!");
		}
	}
	
	@Override
	public void exibirConta() throws IOException, ContaInativa {
		if (this.isEstaAtiva() == true) {
			OutputStream fos = new FileOutputStream("arquivo.txt");
			Writer wt = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(wt);
			
			bw.write("-----------|Informações da conta|----------");
			bw.newLine();
			bw.write("Nome do titular: " + this.getTitular().getInformacoesPessoais().getNome() + " " + this.getTitular().getInformacoesPessoais().getSobrenome());
			bw.newLine();
			bw.write("CPF do titular: " + this.getTitular().getInformacoesPessoais().getCpf());
			bw.newLine();
			bw.write("Saldo: " + this.getSaldo());
			bw.newLine();
			bw.write("Tipo de conta: Corrente");
			bw.newLine();
			bw.write("-------------------------------------------");
			
			bw.close();
			
			LeituraArquivo.leArquivo();
		} else {
			throw new ContaInativa("A conta esta inativa!\nAtive a conta para poder visualizar informações sobre ela.");
		}
	}
	
	@Override
	public String toString() {
		return super.toString() + "\nTipo de Conta: Corrente";
	}
}
