package controle;

import modelo.*;
	/**
	 * Essa classe define a comunicação
	 * entre o pacote modelo (Usuario,Dados) e a view
	 * @author Lara Giuliana
	 * @version 1.0 (Abril 2021)
	 */

public class ControleUsuario {
	private Usuario[] u;
	private int qtdUsuarios;
	
	public ControleUsuario(ControleDados d) {
		u = d.getUsuarios();
		qtdUsuarios = d.getQtdUsuarios();
	}
	
	/**
	 * Armazena e retorna o nome do usuario
	 * @return s
	 */
	public String[] getNomeUsuario() {	// Retorna o Nome do Usuario
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
