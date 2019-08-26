package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.leilao.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.construtor.CriadorDeUsuario;
import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
import br.edu.ifal.leilao.modelo.Usuario;

public class AvaliadorTest {
	
	private Usuario primeiroUsuario;
	private Usuario segundoUsuario;
	private Usuario terceiroUsuario;
	private Usuario quartoUsuario;
	private Leilao leilao;
	private Avaliador avaliador;
	private CriadorDeLeilao criadorDeLeilao;
	private CriadorDeUsuario criadorDeUsuario;
	
	@Before
	public void inicializacao(){
		criadorDeUsuario = new CriadorDeUsuario();
		primeiroUsuario = criadorDeUsuario.com("Bruno", "Bruno@gmail.com").constroi();
		segundoUsuario = criadorDeUsuario.com("Maria", "Maria@gmail.com").constroi();
		terceiroUsuario = criadorDeUsuario.com("Joao", "Joao@gmail.com").constroi();
		quartoUsuario = criadorDeUsuario.com("Jose", "Jose@gmail.com").constroi();
		criadorDeLeilao = new CriadorDeLeilao();
		avaliador = new Avaliador();
	}
	
	@Test
	public void avaliadorDeveFuncionarComLancesEmOrdemAleatoria() {

		double valorPrimeiroLance = 300;
		double valorSegundoLance = 400;
		double valorTerceiroLance = 250;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance).constroi();
		
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
		
		double valorPrimeiroLance = 250;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 400;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance).constroi();

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

		double valorPrimeiroLance = 400;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 250;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance).constroi();

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

		double valorPrimeiroLance = 300;
		double valorSegundoLance = 400;
		double valorTerceiroLance = 250;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance).constroi();
		
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

		double valorPrimeiroLance = 250;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 400;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance).constroi();

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
		double valorPrimeiroLance = 400;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 250;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance).constroi();


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

		double valorPrimeiroLance = 250;
		double valorSegundoLance = 250;
		double valorTerceiroLance = 250;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance).constroi();

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

		double valorPrimeiroLance = 250;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.constroi();

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

		double valorPrimeiroLance = 250;
		double valorSegundoLance = 400;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.constroi();
		
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
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos")).constroi();

		avaliador.setTop3Lances(leilao);
		
		List<Lance> top3Lances = avaliador.getTop3Lances();
		
		int tamanhoTop3LancesObtido = top3Lances.size();

		int tamanhoTop3LancesEsperado = 0;

		assertEquals(tamanhoTop3LancesEsperado, tamanhoTop3LancesObtido);
		
	}
	
	@Test
	public void top3DeveFuncionarComMaiseDe3Lances() {

		double valorPrimeiroLance = 400;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 250;
		double valorQuartoLance = 500;
		
		leilao = criadorDeLeilao.para(new Produto("Wacom Intuos"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance)
				.lance(quartoUsuario, valorQuartoLance).constroi();
		
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