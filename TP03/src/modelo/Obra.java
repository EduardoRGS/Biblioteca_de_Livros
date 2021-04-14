package modelo;

import java.util.*;

public class Obra {
	
	protected String nome;	
	protected boolean lido;
	protected Date dataPublicacao;
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
	
	public boolean toBoolean() {	// ToBoolean para ler variavewl tipo boolean.
		return lido;
	}
	
	public String getNome() {
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
	
	
	public Date getDataPublicacao() {
		return dataPublicacao;
	}
	
	
	public void setDataPublicacao(Date dataPublicacao) {
		this.dataPublicacao = dataPublicacao;
	}
	
	
}
