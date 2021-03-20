package TP;

import java.util.*;

public class Revista extends Obra{
	
	private String categoria;
	private int edicao;
	
	public Revista(String n2, Date d2, boolean l2) {
		nome = n2;
		dataPublicacao = d2;
		lido = l2;
	}
	public String toString() {
		return "Nome da Revista = " + nome;
	}
	public String toString1() {
		return nome;
	}
	
	public String getCategoria() {
		return categoria;
	}
	
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	public int getEdicao() {
		return edicao;
	}
	
	public void setEdicao(int edicao) {
		this.edicao = edicao;
	}
}
