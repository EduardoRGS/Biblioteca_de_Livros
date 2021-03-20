package TP;

import java.util.*;

public class Obra {
	protected String nome;
	protected boolean lido;
	protected Date dataPublicacao;
	
	public boolean toBoolean() {
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
