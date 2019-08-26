package br.edu.ifal.leilao.construtor;

import br.edu.ifal.leilao.modelo.Usuario;

public class CriadorDeUsuario {
	
	private Usuario usuario;
	
	public CriadorDeUsuario() {
		
	}
	
	public CriadorDeUsuario com(String nome,String email) {
		usuario = new Usuario(nome);
		usuario.setEmail(email);
		return this;
	}
	
	public Usuario constroi() {
		return this.usuario;
	}
}
