package modelo;

import java.util.*; // Para poder usar o tipo Date e os outras funções.
	/**
	 * Essa classe o livro emprestado junto dos gets e sets desse livro
	 * @author Lara Giuliana
	 * @version 1.0 (Abril 2021)
	 */
public class Emprestimo {
	private String livroEmprestado;
	
	public Emprestimo(){
		super();
	}
	public Emprestimo(String le) {
		livroEmprestado = le;
	}
	public Emprestimo(String[] dadosEmprestimo) {
		this.getlivroEmptrestado();
	}
	public String getlivroEmptrestado() {
		return livroEmprestado;
	}
	public void setlivroEmprestado(String livroEmprestado) {
		this.livroEmprestado = livroEmprestado;
	}
	
}
