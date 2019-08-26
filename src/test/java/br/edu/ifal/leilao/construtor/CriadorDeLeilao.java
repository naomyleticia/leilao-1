package br.edu.ifal.leilao.construtor;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
import br.edu.ifal.leilao.modelo.Usuario;

public class CriadorDeLeilao {
	
	private Leilao leilao;
	
	public CriadorDeLeilao(){
		
	}
	
	public CriadorDeLeilao para(Produto produto) {
		this.leilao = new Leilao(produto);
		return this;
	}
	
	public CriadorDeLeilao lance(Usuario usuario, double valor) {
		this.leilao.propoe(new Lance(usuario, valor));
		return this;
	}
	
	public Leilao constroi() {
		return this.leilao;
	}
}