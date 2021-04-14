package modelo;

import java.util.*;

public class Dados {
	private Livro[] livros = new Livro[50];
	private int qtdLivros = 0;
	private Emprestimo[] emprestimos = new Emprestimo[50];
	private int qtdEmprestados = 0;
	private Obra[] obra = new Obra[50];
	
	public void GerarDados() {
		
		for(int i = 0; i < 5; i++) {
			livros[i] = new Livro("Livro"+i, "Genero"+i);
		}
		qtdLivros = 5;
	}
	public void inserirEditarLivro(Livro l, int pos) {
		this.livros[pos] = l;
		if(pos == qtdLivros)
			qtdLivros++;
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

	public Emprestimo[] getEmprestimos() {
		return emprestimos;
	}
	public Obra[] getObra() {
		return obra;
	}

	public void setEmprestimos(Emprestimo[] emprestimos) {
		this.emprestimos = emprestimos;
	}

	public int getQtdLivros() {
		return qtdLivros;
	}

	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}

	public int getQtdEmprestados() {
		return qtdEmprestados;
	}

	public void setQtdEmprestados(int qtdEmprestados) {
		this.qtdEmprestados = qtdEmprestados;
	}
	
}
