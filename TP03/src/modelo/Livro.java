package modelo;



public class Livro extends Obra {
	private String generoLiterario;
	
	
	public Livro() {
		super();
	}
	public Livro(String n1, String g1) {
		nome = n1;
		generoLiterario = g1;
		
	}
	public Livro(String[] dadosLivros) {
		this.getNome();
	}

	public String getGeneroLiterario() {
		return generoLiterario;
	}

	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}
}
