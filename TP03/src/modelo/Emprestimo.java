package modelo;

import java.util.*; // Para poder usar o tipo Date e os outras funções.

public class Emprestimo {
	private String nomeLivro;
	private String nomeUsuario;
	private String telefone;
	private Date data;
	
	public Emprestimo(String nl, String nu, String t, Date d) {	// Para cadastrar na Cadastrar e usar na classe Teste.
		nomeLivro = nl;
		nomeUsuario = nu;
		telefone = t;
		data = d;
	}
	public Emprestimo(String[] dadosLivros) {
		this.getNomeLivro();
	}
	
	
	
	public String toString() {					// ToString apenas para cadastra e printar o nome do 
												//	Livro de Emprestimo quando necessario.
		return "Nome do Livro = " +nomeLivro;
	}
	public String toString0() { 	// ToString0 para usar o nome do Livro de emprestimo nos modulos necessarios.
		return nomeLivro;
	}
	
	public String toString1() {		// ToString1 para cadastra o nome do usuario.
		return "Nome do Usuario = " +nomeUsuario;
	}
	
	public String toString2() {		// ToString2 para cadastra o telefone do Usuario emprestimo.
		return "Telefone = " +telefone;
	}
	
	public Date toDate() {			// ToDate para printar a Data do emprestimo
		return data;
	}
	
	public String getNomeLivro() {
		return nomeLivro;
	}

	
	public void setNomeLivro(String nomeLivro) {
		this.nomeLivro = nomeLivro;
	}
	
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
	public Date getData() {
		return data;
	}
	
	public void setData(Date data) {
		this.data = data;
	}
	
	
}
