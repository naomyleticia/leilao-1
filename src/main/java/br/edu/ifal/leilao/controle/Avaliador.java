package br.edu.ifal.leilao.controle;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;

public class Avaliador {
	private double maiorDeTodos = Double.NEGATIVE_INFINITY;
	
	public void avaliar(Leilao leilao) {
		for(Lance lance : leilao.getLances()) {
			if(maiorDeTodos < lance.getValor())
				maiorDeTodos = lance.getValor();
		}
	}
	
	public double getMaiorLance() {
		return maiorDeTodos;
	}
	
}
