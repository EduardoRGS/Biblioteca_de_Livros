package modelo;

import java.util.*;
import java.util.Arrays;
	
	/**
	 * Responsalvel por guardar os vetores de livro e usuario e a quantidade de livros e usuarios
	 * @author Eduardo Ribeiro
	 * @version 1.0 (Abril 2021)
	 */
public class Dados {
	private Livro[] livros = new Livro[50];
	private int qtdLivros = 0;
	private Usuario[] usuarios = new Usuario[50];
	private int qtdUsuarios = 0;
	
	
	/**
	 * Gera os dados de livro e usuario
	 */
	public void GerarDados() {
		
		for(int i = 0; i < 5; i++) {
			
			livros[i] = new Livro("Livro"+i, "Genero"+i);
			usuarios[i] = new Usuario("Usuario"+i);
			
		}
		
		qtdLivros = 5;
		qtdUsuarios = 5;
		
	}
	
	/**
	 * Aumenta a quantidade de livros quando um novo livro for cadastrado
	 * @param l classe Livro
	 * @param pos posição 
	 */
	public void inserirEditarLivro(Livro l, int pos) {
		this.livros[pos] = l;
		if(pos == qtdLivros)
			qtdLivros++;
	}
	
	/**
	 * Aumenta a quantidade de usuarios quando um novo usuario for cadastrado
	 * @param u classe Usuario
	 * @param pos
	 */
	public void inserirEditarUsuario(Usuario u, int pos) {
		this.usuarios[pos] = u;
		if(pos == qtdUsuarios)
			qtdUsuarios++;
	}
	
	
	public Livro[] getLivros() {
		return livros;
	}
	public Livro[] getLivro() {
		return livros;
	}

	public void setLivros(Livro[] livros) {
		this.livros = livros;
	}
	public int getQtdLivros() {
		return qtdLivros;
	}
	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}
	
	
	public Usuario[] getUsuarios() {
		return usuarios;
	}
	public void setUsuarios(Usuario[] usuarios) {
		this.usuarios = usuarios;
	}
	public int getQtdUsuarios() {
		return qtdUsuarios;
	}
	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}
}
