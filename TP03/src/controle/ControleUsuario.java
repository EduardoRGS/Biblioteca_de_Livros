package controle;

import modelo.*;

public class ControleUsuario {
	private Usuario[] u;
	private int qtdUsuarios;
	
	public ControleUsuario(ControleDados d) {
		u = d.getUsuarios();
		qtdUsuarios = d.getQtdUsuarios();
	}
	public String[] getNomeUsuario() {
		String[] s = new String[qtdUsuarios];
		for(int i = 0; i < qtdUsuarios; i++) {
			s[i] = u[i].getNomeUsuario();
		}
		return s;
	}
	
	public String getNome(int i) {
		return u[i].getNomeUsuario();
	}
	public int getQtdUsuarios() {
		return qtdUsuarios;
	}
	public void setQtdUsuarios(int qtdUsuarios) {
		this.qtdUsuarios = qtdUsuarios;
	}
}
