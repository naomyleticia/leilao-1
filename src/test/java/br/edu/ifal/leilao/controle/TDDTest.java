package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.leilao.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.construtor.CriadorDeUsuario;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
import br.edu.ifal.leilao.modelo.Usuario;

public class TDDTest {
	
	private CriadorDeLeilao criadorDeLeilao;
	private CriadorDeUsuario criadorDeUsuario;
	private Usuario primeiroUsuario;
	private Usuario segundoUsuario;
	private Usuario terceiroUsuario;
	private Usuario quartoUsuario;
	private Usuario quintoUsuario;
	private Leilao leilao;
	private Avaliador avaliador;
	
	@Before
	public void inicializador() {
		criadorDeLeilao = new CriadorDeLeilao();
		avaliador = new Avaliador();
		criadorDeUsuario = new CriadorDeUsuario();
		primeiroUsuario = criadorDeUsuario.com("Bruno", "bruno@gmail.com").constroi();
		segundoUsuario = criadorDeUsuario.com("Mario", "maria@gmail.com").constroi();
		terceiroUsuario = criadorDeUsuario.com("Joao", "joao@gmail.com").constroi();
		quartoUsuario = criadorDeUsuario.com("Jose", "jose@gmail.com").constroi();
		quintoUsuario = criadorDeUsuario.com("Breno", "breno@gmail.com").constroi();
	}
	
	@Test
	public void deveFuncionarComUsuariosELancesDiferentes() {
		
		double valorPrimeiroLance = 250;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 400;
		double valorQuartoLance = 500;
		double valorQuintoLance = 550;
		
		leilao = criadorDeLeilao.para(new Produto("Tv"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(segundoUsuario, valorSegundoLance)
				.lance(terceiroUsuario, valorTerceiroLance)
				.lance(quartoUsuario, valorQuartoLance)
				.lance(quintoUsuario, valorQuintoLance).constroi();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;
		
		assertEquals(validadeEsperada, validadeObtida);
	}
	
	@Test
	public void naoDeveFuncionarComMaisDeCincoLanceDoMesmoUsuario() {
		
		double valorPrimeiroLance = 250;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 400;
		double valorQuartoLance = 500;
		double valorQuintoLance = 550;
		double valorSextoLance = 600;
		
		leilao = criadorDeLeilao.para(new Produto("Tv"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(primeiroUsuario, valorSegundoLance)
				.lance(primeiroUsuario, valorTerceiroLance)
				.lance(primeiroUsuario, valorQuartoLance)
				.lance(primeiroUsuario, valorQuintoLance)
				.lance(primeiroUsuario, valorSextoLance).constroi();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = false;
		
		assertEquals(validadeEsperada, validadeObtida);
	}
	
	@Test
	public void deveFuncionarCom3LancePorUsuario() {
		
		double valorPrimeiroLance = 250;
		double valorSegundoLance = 300;
		double valorTerceiroLance = 400;
		double valorQuartoLance = 500;
		double valorQuintoLance = 550;
		double valorSextoLance = 600;
		
		leilao = criadorDeLeilao.para(new Produto("Tv"))
				.lance(primeiroUsuario, valorPrimeiroLance)
				.lance(primeiroUsuario, valorSegundoLance)
				.lance(primeiroUsuario, valorTerceiroLance)
				.lance(segundoUsuario, valorQuartoLance)
				.lance(segundoUsuario, valorQuintoLance)
				.lance(segundoUsuario, valorSextoLance).constroi();
		
		boolean validadeObtida = avaliador.validarLeilao(leilao);
		boolean validadeEsperada = true;
		
		assertEquals(validadeEsperada, validadeObtida);
	}
}
