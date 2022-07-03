package com.github.lucasdevrj.bancolima.principal;

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
		Cliente cf1 = new ClienteFisico(ip1, ed1);
		ContaCorrente cc1 = new ContaCorrente(cf1, "11", "33332", 5000.00f);
		ContaPoupanca cp1 = new ContaPoupanca(cf1, "21", "11111", 300.00f);
		
		InformacoesPessoais ip2 = new InformacoesPessoais("Pedro", "Marins", "23/02/1992", "322.112.341-12", "33.221.225-3", "brasileiro");
		Endereco ed2 = new Endereco("22312-777", "Rio de Janeiro", "Rio de Janeiro", "Niteroi", "Bananada", 309, "Próximo a Caelum", "Casa número 301");
		Cliente cf2 = new ClienteFisico(ip2, ed2);
		ContaCorrente cc2 = new ContaCorrente(cf2,"11", "11111", 9000.00f);
		
		cc1.deposita(300.00f);
		System.out.println(cc1.toString());
		cc1.transfere(cc2, 600.00f);
		System.out.println(cc2.toString());
		
		System.out.println(cp1.toString());
		System.out.println();
		cp1.investir(300.00f, 3);
		System.out.println();
		System.out.println(cp1.toString());
	}

}
