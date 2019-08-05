package br.edu.ifal.leilao.modelo;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
	private List<Lance> Lances = new ArrayList<Lance>();
	
	public Leilao() {
		
	}

	public List<Lance> getLances() {
		return Lances;
	}

	public void setLances(List<Lance> lances) {
		Lances = lances;
	}
	
}
