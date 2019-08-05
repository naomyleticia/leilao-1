package br.edu.ifal.leilao.modelo;

import java.util.ArrayList;
import java.util.List;

public class Leilao {
	private List<Lance> lances; 
	
	public Leilao() {
		super();
		this.lances = new ArrayList<Lance>();
	}

	public List<Lance> getLances() {
		return lances;
	}

	public void setLances(List<Lance> lances) {
		this.lances = lances;
	}
	
	public void propoe(Lance lance) {
		lances.add(lance);
	}
	
}
