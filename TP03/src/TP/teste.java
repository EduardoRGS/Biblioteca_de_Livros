package TP;

import java.util.*;

public class teste {
	
	static Biblioteca b;
	static Obra o;
	static Emprestimo e;
	static Revista r;
	static Livro l;
	
	public static void main(String[] args) {
		
		Biblioteca p = new Biblioteca(); // Chamando a classe para poder usar os metodos dentro dela
		
		GregorianCalendar data = new GregorianCalendar();
		Date agora = data.getTime();
		
		
		l = new Livro("Harry Poter", agora,true);
		p.lido1(l.toBoolean()); // Metodo Livro Lido
		
		r = new Revista("Revista ", agora, false);
		p.lido1(r.toBoolean()); // MEtodo Livro Pendente
		
		
		
		System.out.println(l.toString()); // Nome do Livro
		p.pesquisa(l.toString1()); // Metodo Pesquisa
		
		System.out.println(r.toString()); // Nome da Revista
		p.pesquisa(r.toString1()); // Metodo Pesquisa
	}
}
