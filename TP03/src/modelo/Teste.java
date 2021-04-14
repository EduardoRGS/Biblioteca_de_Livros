package modelo;

import java.util.*; // Para poder usar o tipo Date e ostras funções.

public class Teste {
	
	static Biblioteca b;	// Para poder usar os atributos da classe Biblioteca.
	static Obra o;			// Para poder usar os atributos da classe Obra.
	static Emprestimo e;	// Para poder usar os atrbutos da classe Emprestimo.
	static Livro l;			// Para poder usar os atributos da classe Livro
	static Livro l2;		// Para poder cadastra mais de um Livro.
	
	/*
	public static void main(String[] args) {
		
		 Biblioteca aux = new Biblioteca("Eduardo R.","61 999999999"); // Chamando a classe para poder 
		 																// usar os métodos dentro dela.
		
		GregorianCalendar data = new GregorianCalendar(); // Funcâo para mostrar a Data e hora Atual.
		Date d = data.getTime();
		
		
		
		l = new Livro("Harry Potter e a Pedra Filosofal","Fantasia", true); // Cadastrando os dados do Livro 1.
		l2 = new Livro("Clean Code","Tecnologia", true);	// Dados do Livro 2;
		
		e = new Emprestimo("Harry Potter e a Pedra Filosofal","Lara G.","61 999999999",d); // Dados do Livro de Emprestimo.
		
		b = new Biblioteca("Eduardo R.","61 999999999"); // Cadastrando o usuario e telefone da classe Biblioteca.
		
		
		
		
		System.out.println("Biblioteca Particular do " +b.toString()+ " - Telefone: "+b.toString1()+ "\n");
		//Print do usuario e telefone cadastrados.
		
		aux.quantidadeLivros(l.toBoolean()); // Mostra se o Livro esta lido é a quantidade de livros Lidos.
		
		
		aux.quantidadeLivros(l2.toBoolean()); // Mostra a de Livro que esta Pendente é a Qauntidade de livros Pendentes
		
		
		aux.quantidadeTotal(); // Mostra a quantidade Total de Livros cadastrados.
		
		
		aux.ordemAlfabetica(l.toString(), l2.toString()); // Colocar os Livros os por ordem alfabetica.
		
		
		
		aux.generoLiterario(l.toString2(), l.toString1()); // Livro por Organizado por Genero
		
		aux.generoLiterario(l2.toString2(), l2.toString1()); // Caso o Livro não tenha o genero selecionado.
		
		
		
		
		
		System.out.println(l.toString()); // Nome do Primeiro Livro.
		aux.pesquisa(l.toString1()); // Metodo pesquisa.
		
		
		
		System.out.println(l2.toString()); // Nome do Segundo Livro
		aux.pesquisa(l2.toString1()); // Metodo pesquisa caso não ache o Livro pesquisado.
		
		
		
	
		aux.emprestimo(l.toString1(), e.toString0()); // Metodo do Livro Emprestado.

		System.out.println("Livro Emprestado para: " +e.toString1()); // Print do Nome do usuario.
		
		System.out.println(e.toDate()+ "\n"); // Data do Emprestimo.
		
		
		aux.quantidadeTotal(); // Mostra a quantidade Total depois do Emprestimo de um Livro.
		
	}
	*/
}
