package com.github.lucasdevrj.bancolima.principal;

import com.github.lucasdevrj.bancolima.cliente.Cliente;
import com.github.lucasdevrj.bancolima.cliente.Fisico;
import com.github.lucasdevrj.bancolima.endereco.Endereco;
import com.github.lucasdevrj.bancolima.informacoespessoais.InformacoesPessoais;

public class Principal {

	public static void main(String[] args) {
		InformacoesPessoais ip1 = new InformacoesPessoais("Lucas", "Pereira", "15/04/1999", "111.222.111-11", "22.111.444-1", "brasileiro");
		Endereco ed1 = new Endereco("21123-555", "Rio de Janeiro", "Rio de Janeiro", "Tijuca", "Gadernal", 203, "Próximo ao posto Ipiranga", "Casa número 204");
		
		Cliente cf = new Fisico(ip1, ed1);
	}

}
