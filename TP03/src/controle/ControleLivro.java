package controle;

import modelo.*;
import java.lang.String;
	/**
	 * Essa classe define a comunicação
	 * entre o pacote modelo (Livro,Dados) e a view
	 * @author Eduardo Ribeiro
	 * @version 1.0 (Abril 2021)
	 */
public class ControleLivro {
	private Livro[] l;
	private int qtdLivros;
	
	
	public ControleLivro(ControleDados d) {
		l = d.getLivros();
		qtdLivros = d.getQtdLivros();
	}
	
	/**
	 * Armazena e retorna o nome do livro
	 * @return s
	 */
	public String[] getNomeLivro() {	// Retorna o nome do Livro
		String[] s = new String[qtdLivros];
		for(int i = 0; i < qtdLivros; i++) {
			s[i] = l[i].getNome();
			
			
		}
		return s;
	}
	
	public String getNome(int i) {
		return l[i].getNome();
	}
	public int getQtdLivros() {
		return qtdLivros;
	}
	public void setQtdLivros(int qtdLivros) {
		this.qtdLivros = qtdLivros;
	}
	
	
}
