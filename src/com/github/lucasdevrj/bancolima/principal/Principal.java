package com.github.lucasdevrj.bancolima.principal;

import java.io.IOException;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.cliente.ClienteFisico;
import com.github.lucasdevrj.bancolima.conta.ContaCorrente;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public class Principal {

	public static void main(String[] args) throws IOException {
		InformacoesPessoais ip1 = new InformacoesPessoais("Lucas", "Pereira", "15/04/1999", "111.222.111-11", "22.111.444-1", "brasileiro");
		Endereco ed1 = new Endereco("21123-555", "Rio de Janeiro", "Rio de Janeiro", "Tijuca", "Gadernal", 203, "Próximo ao posto Ipiranga", "Casa número 204");
		Cliente cf = new ClienteFisico(ip1, ed1);
		
		ContaCorrente cc1 = new ContaCorrente(cf, 5000.00f);
		cc1.deposita(300.00f);
		System.out.println(cc1.toString());
	}

}
