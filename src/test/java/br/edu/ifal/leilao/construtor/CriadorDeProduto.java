package br.edu.ifal.leilao.construtor;

import br.edu.ifal.leilao.modelo.Produto;

public class CriadorDeProduto {
	
	private Produto produto;

	public CriadorDeProduto chamado(String nome) {
		this.produto = new Produto(nome);
		return this;
	}
	
	public CriadorDeProduto detalhe (String descricao) {
		this.produto.setDescricao(descricao);
		return this;
	}
	
	public CriadorDeProduto valendo(double valor) {
		this.produto.setValorInicial(valor);
		return this;
	}

	public Produto constroi() {
		return this.produto;
	}

	
	
	

}
