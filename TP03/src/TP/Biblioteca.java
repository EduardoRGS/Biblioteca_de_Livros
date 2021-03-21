package TP;

import java.util.*; // Api para usar a funcao SordSet para colcoar os Livros em ordem Alafabetica e outras funções.

public class Biblioteca {
	
	private String usuario;
	private String telefone;
	
	int quantLidos = 0;			// variavel para contar a quantidade de livros lidos.
	int quantPendentes = 0;		// variavel para contar a quantidade de livros pendentes.
	int quant = 0;				// variavel para contar a quantidade total de livros
	
	public boolean lido1(boolean lid) {		// Modulo para verificar se o livro Lido ou ainda esta Pendente/ não lido.
		if(lid == true) {
			
			System.out.println("Livro Lido ");
			
			quant++;
			
			return true;
			
		}else {
			
			System.out.println("Livro Pendente");
			
			quant++;
			return false;
		}
	}
	
	public void ordemAlfabetica(String nomeLivro, String nomeLivro2) {	// Modulo que organiza os Livros por ordem alfabetica.
		
		
		SortedSet<String> nome =  new TreeSet<String>();
		nome.add(nomeLivro);
		nome.add(nomeLivro2);
		
		for(int i = 1; i<quant; i++) {
			
			System.out.println("Livros por Ordem Alfabetica ");
			System.out.println(nome+"\n");
			
		}
	}
	public void generoLiterario(String genero,String nomeLivro) { // Modulo que organiza por gênero os Livros armazenaods.
		String g1;
		
		g1 = "Fantasia";
		
		if(g1.equals(genero) == true) {
			
			for(int i = 1; i<=1; i++) {
				
				System.out.println("Livros do Genero " +g1);
				System.out.println(nomeLivro+ "\n");
			}
		}else {
			
			System.out.println("Nenhum Livro com este Genero " +g1+ "\n");
		}
	}
	
	public int quantidadeLivros(boolean lidoQuant) { // Modulo com a quantidade de Livros Lidos e Pendentes. 
		
		
		if(lido1(lidoQuant) == true) {
			
			quantLidos++;

			System.out.println("Quantidade de Livros Lidos = " +quantLidos+ "\n");
			
			return quantLidos;
			
		}else {
		
			quantPendentes++;
			
			System.out.println("Quantidade de Livros Pendentes = " +quantPendentes+ "\n");
			
			return quantPendentes;
		}
		
	
		
	}
	
	
	public void pesquisa (String nome) {	// Modulo de Pesquisa de um Livro.
		String pesquisa;
		
		pesquisa = "Harry Potter e a Pedra Filosofal";
		
		if(pesquisa.equals(nome) == true) {
			
			System.out.println("Livro Pesquisado: " +pesquisa+ "\n");
			
		}else {
			
			System.out.println("Livro Não Encontrado \n");
		}
		
	}
	
	public void emprestimo(String nomeLivro1,String nomeLivro2) {	// Mpdulo de Emprestimo de um Livro
		
		if(nomeLivro1.equals(nomeLivro2) == true) {
			
			System.out.println("Livro Emprestado = " + nomeLivro1+ "\n");
			quant--;
		}
	}
	
	public void quantidadeTotal() {		// Modulo apenas para mostrar a quantidade total de Livros cadastrados.
		
		System.out.println("Quantidade Total de livros na Biblioteca = " +quant+ "\n");
	}
	
	public Biblioteca (String n1, String t1) {
		usuario = n1;
		telefone = t1;
	}
	
	public String toString() {		// ToString para cadastro do Usuario Biblioteca.
		return usuario;
	}
	public String toString1() {		// ToString1 para o telefone do Usuario Biblioteca.
		return telefone;
	}
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
