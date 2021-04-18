package controle;

import modelo.*;
import java.lang.String;

public class ControleLivro {
	private Livro[] l;
	private int qtdLivros;
	private Emprestimo[] e;
	
	
	public ControleLivro(ControleDados d) {
		l = d.getLivros();
		qtdLivros = d.getQtdLivros();
		e = d.getEmprestimos();
	}
	
	public String[] getNomeLivro() {
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
