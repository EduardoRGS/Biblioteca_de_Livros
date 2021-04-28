package modelo;

	/**
	 * Essa classe define o nome do usuario
	 * @author Lara Giuliana
	 * @version 1.0 (Abril 2021)
	 */
public class Usuario {
	
	private String nomeUsuario;

	
	public Usuario() {
		super();
	}
	public Usuario(String u1) {
		nomeUsuario = u1;
	}
	public Usuario(String[] dadosUsuarios) {
		this.getNomeUsuario();
	}
	public String getNomeUsuario() {
		return nomeUsuario;
	}
	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
	}
	
	
	
	
}
