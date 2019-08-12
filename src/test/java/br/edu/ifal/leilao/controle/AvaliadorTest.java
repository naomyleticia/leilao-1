package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Usuario;

public class AvaliadorTest {
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");
		
		double valorPrimeiroLance = 300;
		double valorSegundoLance = 400;
		double valorTerceiroLance = 250;
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilao);
		double maiorLance = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		
		double menorLance = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLance, 0.001);
		assertEquals(menorLance, menorLanceEsperado, 0.001);
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemCrescente() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");
		
		double valorPrimeiroLance = 250;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 400;
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilao);
		double maiorLance = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		
		double menorLance = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLance, 0.001);
		assertEquals(menorLanceEsperado, menorLance, 0.001);
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemDecrescente() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");
		
		double valorPrimeiroLance = 400;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 250;
		
		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.avaliar(leilao);
		double maiorLance = avaliador.getMaiorLance();
		double maiorLanceEsperado = 400;
		
		double menorLance = avaliador.getMenorLance();
		double menorLanceEsperado = 250;
		
		assertEquals(maiorLanceEsperado, maiorLance, 0.001);
		assertEquals(menorLanceEsperado, menorLance, 0.001);
	}
	
	@Test
	public void top3DeveFuncionarCom3LancesEmOrdemAleatoria() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");

		double valorPrimeiroLance = 300;
		double valorSegundoLance = 400;
		double valorTerceiroLance = 250;

		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		double primeiroLanceObtido = top3Lances.get(0).getValor();
		double segundoLanceObtido = top3Lances.get(1).getValor();
		double terceiroLanceObtido = top3Lances.get(2).getValor();
		int tamanhoTop3LancesObtido = top3Lances.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 300;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3LancesEsperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.1);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.1);
		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
		
	}
	
	@Test
	public void top3DeveFuncionarCom3LancesEmOrdemCrescente() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");

		double valorPrimeiroLance = 250;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 400;

		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		double primeiroLanceObtido = top3Lances.get(0).getValor();
		double segundoLanceObtido = top3Lances.get(1).getValor();
		double terceiroLanceObtido = top3Lances.get(2).getValor();
		int tamanhoTop3LancesObtido = top3Lances.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 300;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3LancesEsperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.1);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.1);
		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
		
	}
	
	@Test
	public void top3DeveFuncionarCom3LancesEmOrdemDecrescente() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");

		double valorPrimeiroLance = 400;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 250;

		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		double primeiroLanceObtido = top3Lances.get(0).getValor();
		double segundoLanceObtido = top3Lances.get(1).getValor();
		double terceiroLanceObtido = top3Lances.get(2).getValor();
		int tamanhoTop3LancesObtido = top3Lances.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 300;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3LancesEsperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.1);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.1);
		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
	}
	
	@Test
	public void top3DeveFuncionarCom3LancesComMesmoValor() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");

		double valorPrimeiroLance = 250;
		double valorSegundoLance = 250;
		double valorTerceiroLance = 250;

		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		double primeiroLanceObtido = top3Lances.get(0).getValor();
		double segundoLanceObtido = top3Lances.get(1).getValor();
		double terceiroLanceObtido = top3Lances.get(2).getValor();
		int tamanhoTop3LancesObtido = top3Lances.size();
		
		double primeiroLanceEsperado = 250;
		double segundoLanceEsperado = 250;
		double terceiroLanceEsperado = 250;
		int tamanhoTop3LancesEsperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.1);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.1);
		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
		
	}
	
	
	@Test
	public void top3DeveFuncionarCom1Lance() {
		Usuario primeiroUsuario = new Usuario("Bruno");

		double valorPrimeiroLance = 250;

		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		double primeiroLanceObtido = top3Lances.get(0).getValor();
		int tamanhoTop3LancesObtido = top3Lances.size();
		
		double primeiroLanceEsperado = 250;
		int tamanhoTop3LancesEsperado = 1;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.1);
		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
		
	}
	
	@Test
	public void top3DeveFuncionarCom2Lances() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");

		double valorPrimeiroLance = 250;
		double valorSegundoLance = 400;

		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		double primeiroLanceObtido = top3Lances.get(0).getValor();
		double segundoLanceObtido = top3Lances.get(1).getValor();
		int tamanhoTop3LancesObtido = top3Lances.size();
		
		double primeiroLanceEsperado = 400;
		double segundoLanceEsperado = 250;
		int tamanhoTop3LancesEsperado = 2;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.1);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
		
	}
	
	@Test
	public void top3DeveFuncionarSemNenhumLance() {
		Leilao leilao = new Leilao();

		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		int tamanhoTop3LancesObtido = top3Lances.size();

		int tamanhoTop3LancesEsperado = 0;

		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
		
	}
	
	@Test
	public void top3DeveFuncionarComMaiseDe3Lances() {
		Usuario primeiroUsuario = new Usuario("Bruno");
		Usuario segundoUsuario = new Usuario("Maria");
		Usuario terceiroUsuario = new Usuario("Jorge");
		Usuario quartoUsuario = new Usuario("João");

		double valorPrimeiroLance = 400;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 250;
		double valorQuartoLance = 500;

		Leilao leilao = new Leilao();
		leilao.propoe(new Lance(primeiroUsuario, valorPrimeiroLance));
		leilao.propoe(new Lance(segundoUsuario, valorSegundoLance));
		leilao.propoe(new Lance(terceiroUsuario, valorTerceiroLance));
		leilao.propoe(new Lance(quartoUsuario, valorQuartoLance));
		
		Avaliador avaliador = new Avaliador();
		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		double primeiroLanceObtido = top3Lances.get(0).getValor();
		double segundoLanceObtido = top3Lances.get(1).getValor();
		double terceiroLanceObtido = top3Lances.get(2).getValor();
		int tamanhoTop3LancesObtido = top3Lances.size();
		
		double primeiroLanceEsperado = 500;
		double segundoLanceEsperado = 400;
		double terceiroLanceEsperado = 300;
		int tamanhoTop3LancesEsperado = 3;
		
		assertEquals(primeiroLanceEsperado, primeiroLanceObtido, 0.1);
		assertEquals(segundoLanceEsperado, segundoLanceObtido, 0.1);
		assertEquals(terceiroLanceEsperado, terceiroLanceObtido, 0.1);
		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
	}
}
