package modelo;

import java.util.*;

public class Obra {
	
	protected String nome;	
	protected boolean lido;
	private Livro livro;
	public Obra() {
		super();
	}
	public Livro getLivros() {
		return livro;
	}
	public void setLivros(Livro livro) {
		this.livro = livro;
	}
	
	public String getNome() {
		return nome;
	}
	public String getNomeEmprestimo() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	
	public boolean isLido() {
		return lido;
	}
	
	
	public void setLido(boolean lido) {
		this.lido = lido;
	}
	
	
	
}
