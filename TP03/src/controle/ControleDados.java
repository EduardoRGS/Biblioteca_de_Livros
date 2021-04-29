package controle;

import javax.swing.JList;
import modelo.*;

/**
 * Essa clasee simula um banco de dados
 * que se comunica com os pacotes modelo e view
 * @author Eduardo Ribeiro
 * @version 1.0 (Abril 2021)
 */


public class ControleDados {
	private Dados d = new Dados();
	public String remove;
	public int contador;
	
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
	
	public Usuario[] getUsuarios() { 
		return this.d.getUsuarios();
	}
	public int getQtdUsuarios() {	
		return this.d.getQtdUsuarios();
	}
	
	/**
	 * Cadastra um novo Livro na Biblioteca e também pode se editar o Livro cadastrado
	 * @param dadosLivros pega o nome do livro da classe Livro
	 * @return verdadeiro
	 */
	
	public boolean inserirEditarLivro(String[] dadosLivros) {	
		Livro l = new Livro(dadosLivros[1], dadosLivros[2]);
		
		d.inserirEditarLivro(l, Integer.parseInt(dadosLivros[0]));
		return true;
		
	}
	/**
	 * Remove um livro cadastrado.
	 * @param i é a posição do Livro para remover o Livro da posição selecionada 
	 * @return verdadero ou falso
	 */
	
	public boolean removeLivro(int i) {	
		int qtdLivros = d.getQtdLivros();
		String livroRemovido = d.getLivros()[i].getNome();
		String aux;
		
		for(int j = 0; j < 1; j++) {	// Retorna falso se o Livro não estiver cadastrado
			aux = d.getLivro()[j].getNome();
			if(livroRemovido.compareTo(aux) == 0) {
				
				return false;	
			}
			
		}
		
		
		if(i == (d.getQtdLivros() - 1)) {
			d.setQtdLivros(getQtdLivros() - 1);
			d.getLivros()[d.getQtdLivros()] = null;
			
			remove = livroRemovido;
			
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
			remove = livroRemovido;
			return true;
		}
		
	}
	/**
	 * Verifica se o nome pesquisado é igual ao nome do livro cadastrado
	 * @param nomeLivro nome do livro pesquisado
	 * @return  posicao >= 0 se for igual ou posicao -1 se a pesquisa for diferente do livro cadastrado
	 */
	public int pesquisa(String nomeLivro) {	
		int posicao = -1;
		
			
		for(int i = 0; i < d.getQtdLivros(); i++) {
			
			if(d.getLivro()[i].getNome().toLowerCase().compareTo(nomeLivro.toLowerCase()) == 0) {
					posicao = i;
					return posicao;
			} else {
				posicao = -1;
			}
		}
		return posicao;	 
		
	}
	
	/**
	 * Cadastra um novo usuario na Biblioteca e também pode se editar o usuario cadastrado.
	 * @param dadosUsuario pega o nome do usuario na classe Usuario
	 * @return verdadeiro
	 */
	public boolean inserirEditarUsuario(String[] dadosUsuario) { 
		Usuario u = new Usuario(dadosUsuario[1]);
		
		d.inserirEditarUsuario(u, getQtdUsuarios());
		return true;
	}
	
	/**
	 * Remove um usuario cadastrado
	 * @param i é a posição do usuario para remover o usuario da posição selecionada 
	 * @return verdadeiro ou falso
	 */
	public boolean removeUsuario(int i) {	
		int qtdUsuario = d.getQtdUsuarios();
		String userRemovido = d.getUsuarios()[i].getNomeUsuario();
		String aux;
		for(int j = 0; j < 1; j++) {
			aux = d.getUsuarios()[j].getNomeUsuario();
			if(userRemovido.compareTo(aux) == 0)
				return false;
		}
		
		if(i == (d.getQtdUsuarios() - 1)) {
			d.setQtdUsuarios(getQtdUsuarios() - 1);
			d.getUsuarios()[d.getQtdUsuarios()] = null;
			return true;
			
		} else {
			int cont = 0;
			while(d.getUsuarios()[cont].getNomeUsuario().compareTo(userRemovido) != 0) {
				cont++;
			}
			for(int j = cont; j < d.getQtdUsuarios(); j++) {
				d.getUsuarios()[j] = null;
				d.getUsuarios()[j] = d.getUsuarios()[j+1];
			
			}
			d.getUsuarios()[d.getQtdUsuarios()] = null;
			d.setQtdUsuarios(d.getQtdUsuarios() - 1);
			return true;
		}
	}
	
	/**
	 * Verifica se o nome do usuario pesquisado é igual ao nome do usuario cadastrado
	 * @param nomeUsuario do usuario pesquisado
	 * @return posicao >= 0 se for igual ou posicao -1 se a pesquisa for diferente do usuario cadastrado
	 */
	public int pesquisaUsuario(String nomeUsuario) {	
		int posicao = -1;
		
		for(int i = 0; i < d.getQtdUsuarios(); i++) {
			
			if(d.getUsuarios()[i].getNomeUsuario().toLowerCase().compareTo(nomeUsuario.toLowerCase()) == 0) {
					posicao = i;
					return posicao;
			} else {
				posicao = -1;
			}
		}
		return posicao;	 
		
	}
	
}
