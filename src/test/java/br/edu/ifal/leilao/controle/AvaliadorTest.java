package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Usuario;

public class AvaliadorTest {
	
	@Test
	public void teste() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");
		
		double valorPrimeiroLance = 300;
		double valorSegundoLance = 400;
		double valorTerceiroLance = 250;
		
		Leilao leilao = new Leilao();
		Lance primeiroLance = new Lance(primeiroUsuario, valorPrimeiroLance);
		Lance segundoLance = new Lance(segundoUsuario, valorSegundoLance);
		Lance teceiroLance = new Lance(terceiroUsuario, valorTerceiroLance);
		
		leilao.propoe(primeiroLance);
		leilao.propoe(segundoLance);
		leilao.propoe(teceiroLance);
		
		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilao);
		double maiorLance = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		
		assertEquals(maiorLanceEsperado, maiorLance, 0.00001);
	}
}
