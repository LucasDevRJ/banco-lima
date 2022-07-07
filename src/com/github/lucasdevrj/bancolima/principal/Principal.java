package com.github.lucasdevrj.bancolima.principal;

import com.github.lucasdevrj.bancolima.banco.BancoLima;
import com.github.lucasdevrj.bancolima.cartao.CartaoCredito;
import com.github.lucasdevrj.bancolima.cartao.CartaoDebito;
import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.cliente.ClienteFisico;
import com.github.lucasdevrj.bancolima.conta.ContaCorrente;
import com.github.lucasdevrj.bancolima.conta.ContaPoupanca;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public class Principal {

	public static void main(String[] args) throws Exception {
		InformacoesPessoais ip1 = new InformacoesPessoais("Lucas", "Pereira", "15/04/1999", "111.222.111-11", "22.111.444-1", "brasileiro");
		Endereco ed1 = new Endereco("21123-555", "Rio de Janeiro", "Rio de Janeiro", "Tijuca", "Gadernal", 203, "Próximo ao posto Ipiranga", "Casa número 204");
		Cliente cf1 = new ClienteFisico(ip1, ed1, "Lima Plus");
		ContaCorrente cc1 = new ContaCorrente(cf1, "11", "33213", 5000.00f);
		ContaPoupanca cp1 = new ContaPoupanca(cf1, "21", "23421", 300.00f);
		
		InformacoesPessoais ip2 = new InformacoesPessoais("Pedro", "Marins", "23/02/1992", "322.112.341-12", "33.221.225-3", "brasileiro");
		Endereco ed2 = new Endereco("22312-777", "Rio de Janeiro", "Rio de Janeiro", "Niteroi", "Bananada", 309, "Próximo a Caelum", "Casa número 301");
		Cliente cf2 = new ClienteFisico(ip2, ed2, "Lima Plus");
		ContaCorrente cc2 = new ContaCorrente(cf2,"12", "11111", 9000.00f);
		
		cc1.exibirConta();
		cc1.deposita(300.00f);
		cc1.transfere(cc2, 600.00f);
		cc1.exibirConta();
		
		cp1.investir(300.00f, 3);
		System.out.println();
		
		BancoLima bl = new BancoLima();
		bl.adicionaConta(cc1);
		bl.adicionaConta(cc2);
		bl.exibeContas();

		CartaoCredito cdc = new CartaoCredito("3444 1222 4333 1212", "12/06/2027", 322, 1212, 2000.00f, cc1);
		cdc.comprarComCartao("GTA V", 180.00f);
		System.out.println();
		cdc.comprarComCartao("FIFA 23", 320.00f);
		System.out.println();
		cdc.exibirFatura();
		System.out.println();
		cdc.pagarFatura();
		System.out.println();
		cdc.exibirFatura();
		System.out.println();
		
		CartaoDebito cdd = new CartaoDebito("3221 3243 6754 1414", "13/06/2030", 211, 3434, cc1);
		cdd.comprarComCartao("Fone de ouvido", 90.0f);
		System.out.println();
		cdd.comprarComCartao("Mercado", 230.0f);
		System.out.println();
		cdd.exibirExtrato();
		System.out.println();
		cdd.exibirDebito();
	}
}
