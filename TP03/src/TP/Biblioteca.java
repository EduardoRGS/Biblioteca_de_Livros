package TP;

public class Biblioteca {
	
	private String usuario;
	private String telefone;
	
	
	
	public void lido1(boolean lid) {
		if(lid == true) {
			System.out.println("Livro Lido");
			
		}else {
			System.out.println("Livro Pendente");
		}
	}
	
	public void qauntidade() {
		
	}
	
	
	public void pesquisa (String nome) {
		String pesquisa;
		pesquisa = "Harry Poter";
		if(pesquisa.equals(nome) == true) {
			System.out.println("Livro Pesquisado: " +pesquisa);
		}else {
			System.out.println("Livro Não Encontrado");
		}
		
	}
	
	
	
	public String getUsuario() {
		return usuario;
	}
	
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	
	public String getTelefone() {
		return telefone;
	}
	
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	
}
