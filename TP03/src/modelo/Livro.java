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

	public String toString() {			// ToString para cadastra o nome do Livro.
		return "Nome do Livro = " +nome;
	}
	public String toString1() {			// ToString1 para usar o Livro Cadastrado em modulos da biblioteca.
		return nome;
	}
	public String toString2() {			// ToString2 para cadastra o g�nero literario do Livro.
		return generoLiterario;
	}

	public String getGeneroLiterario() {
		return generoLiterario;
	}

	public void setGeneroLiterario(String generoLiterario) {
		this.generoLiterario = generoLiterario;
	}
}