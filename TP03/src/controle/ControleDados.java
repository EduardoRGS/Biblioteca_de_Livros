package controle;

import modelo.*;

public class ControleDados {
	private Dados d = new Dados();
	
	public ControleDados() {
		d.GerarDados();
	}

	public Dados getDados() {
		return d;
	}

	public void setDados(Dados d) {
		this.d = d;
	}
	public Livro[] getLivros() {
		return this.d.getLivros();
	}

	public int getQtdLivros() {
		return this.d.getQtdLivros();
	}
	public void TestaCadastro() {
		for(int i = 0; i< d.getQtdLivros(); i++) {
			System.out.println(d.getLivros()[i]);
		}
	}
	
	public boolean inserirEditarLivro(String[] dadosLivros) {
		Livro l = new Livro(dadosLivros[1], dadosLivros[2]);
		
		d.inserirEditarLivro(l, Integer.parseInt(dadosLivros[0]));
		return true;
		
	}
	
	public boolean removeLivro(int i) {
		int qtdLivros = d.getQtdLivros();
		String livroRemovido = d.getLivros()[i].getNome();
		String aux;
		for(int j = 0; j < 1; j++) {
			aux = d.getLivro()[j].getNome();
			if(livroRemovido.compareTo(aux) == 0)
				return false;
		}
		
		if(i == (d.getQtdLivros() - 1)) {
			d.setQtdLivros(getQtdLivros() - 1);
			d.getLivros()[d.getQtdLivros()] = null;
			return true;
			
		} else {
			int cont = 0;
			while(d.getLivros()[cont].getNome().compareTo(livroRemovido) != 0) {
				cont++;
			}
			for(int j = cont; j < d.getQtdLivros(); j++) {
				d.getLivros()[j] = null;
				d.getLivros()[j] = d.getLivros()[j+1];
			
			}
			d.getLivros()[d.getQtdLivros()] = null;
			d.setQtdLivros(d.getQtdLivros() - 1);
			return true;
		}
	}
	
}
