package br.edu.ifal.leilao.controle;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import br.edu.ifal.leilao.construtor.CriadorDeLeilao;
import br.edu.ifal.leilao.construtor.CriadorDeProduto;
import br.edu.ifal.leilao.modelo.Lance;
import br.edu.ifal.leilao.modelo.Leilao;
import br.edu.ifal.leilao.modelo.Produto;
import br.edu.ifal.leilao.modelo.Usuario;


public class LanceTest {
	
	private Leilao leilao;
	private Avaliador avaliador;
	private Usuario usuario1,usuario2,usuario3;
	private CriadorDeLeilao criadorleilao;
	private CriadorDeProduto criadorDeProduto;
	
	@Before
	
	public void Inicializar() {
		this.avaliador = new Avaliador();
		this.usuario1 = new Usuario("Ray");
		this.usuario2 = new Usuario("nah");
		this.usuario3 = new Usuario("gfg");
		this.criadorleilao = new CriadorDeLeilao();
		this.criadorDeProduto = new CriadorDeProduto();
		
		
		
	}
	
	@Test
	public void naoDeveAceitarOPimeiroLanceMenorQueOValorInicialDoProduto() {
		Produto produto = criadorDeProduto.chamado("GARRAFA")
				.detalhe("BRANCA")
				.valendo(30.50)
				.constroi();
		
		leilao = criadorleilao.para(produto).constroi();
		
		Lance lance = new Lance(usuario1, 20);
		
		boolean aceitacaoObtida = avaliador.aceitarPrimeiroLance(leilao, lance);
		boolean aceitacaoEsperada = false;
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
		
	}
	
	
	@Test
	public void deveAceitarOPrimeiroLanceMaiorQueOValorInicialDoProduto() {
		Produto produto = criadorDeProduto.chamado("GARRAFA")
				.detalhe("BRANCA")
				.valendo(30.50)
				.constroi();
		
		leilao = criadorleilao.para(produto).constroi();
		
		Lance lance = new Lance(usuario1, 32.75);
		
		boolean aceitacaoObtida = avaliador.aceitarPrimeiroLance(leilao, lance);
		boolean aceitacaoEsperada = true;
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
		
	}
	
	@Test
	public void deveAceitarOPrimeiroLanceIgualAoValorInicialDoProduto() {
		Produto produto = criadorDeProduto.chamado("bola")
				.detalhe("AZUL")
				.valendo(30.50)
				.constroi();
		
		leilao = criadorleilao.para(produto).constroi();
		
		Lance lance = new Lance(usuario1, 30.50);
		
		
		boolean aceitacaoObtida = avaliador.aceitarPrimeiroLance(leilao, lance);
		boolean aceitacaoEsperada = true;
		assertEquals(aceitacaoEsperada, aceitacaoObtida);
		
	}
	
	

}
