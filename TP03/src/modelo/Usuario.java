package modelo;

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
