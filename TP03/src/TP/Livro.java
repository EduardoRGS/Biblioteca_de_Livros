package TP;

import java.util.*;

public class Livro extends Obra {
	private String generoLiterario;
	
	public Livro (String n1, Date d1,boolean l1) {
		nome = n1;
		dataPublicacao = d1;
		lido = l1;
	}
	
	public String toString() {
		return "Nome do Livro = " +nome;
	}
	public String toString1() {
		return nome;
	}

	public String getGeneroLiterario() {
		return generoLiterario;
	}

	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}
}
