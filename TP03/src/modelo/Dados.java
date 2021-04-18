package modelo;

import java.util.*;

public class Dados {
	private Livro[] livros = new Livro[50];
	private int qtdLivros = 0;
	private Emprestimo[] emprestimos = new Emprestimo[50];
	private int qtdEmprestados = 0;
	private Obra[] obra = new Obra[50];
	private Usuario[] usuarios = new Usuario[50];
	private int qtdUsuarios = 0;
	
	
	public void GerarDados() {
		
		for(int i = 0; i < 5; i++) {
			livros[i] = new Livro("Livro"+i, "Genero"+i);
			usuarios[i] = new Usuario("Usuario"+i);
		}
		qtdLivros = 5;
		qtdUsuarios = 5;
	}
	public void inserirEditarLivro(Livro l, int pos) {
		this.livros[pos] = l;
		if(pos == qtdLivros)
			qtdLivros++;
	}
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
	

	public Emprestimo[] getEmprestimos() {
		return emprestimos;
	}
	public void setEmprestimos(Emprestimo[] emprestimos) {
		this.emprestimos = emprestimos;
	}
	public int getQtdEmprestados() {
		return qtdEmprestados;
	}
	public void setQtdEmprestados(int qtdEmprestados) {
		this.qtdEmprestados = qtdEmprestados;
	}
	public String setlivroEmprestado(String emprestimo) {
		return emprestimo;
	}
	
	
	public Obra[] getObra() {
		return obra;
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
