package com.github.lucasdevrj.bancolima.leituraarquivo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;

public class LeituraArquivo {

	public static void leArquivo() throws IOException {
		InputStream fis = new FileInputStream("arquivo.txt");
		Reader isr = new InputStreamReader(fis);
		BufferedReader br = new BufferedReader(isr);
		
		String linha = br.readLine();
		
		while (linha != null) {
			System.out.println(linha);
			linha = br.readLine();
		}
		
		br.close();
	}
}
