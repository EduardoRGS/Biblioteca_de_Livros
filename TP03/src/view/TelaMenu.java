package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import controle.*;


public class TelaMenu implements ActionListener {
	
	private static JFrame janela = new JFrame("Biblioteca");
	private static JLabel titulo = new JLabel("Organizador de Livros");
	private static JButton livro = new JButton("Livro");  // Aqui fica os Livros
	private static JButton emprestimo = new JButton("Emprestimo"); // Aqui fica o Empresimo
	private static JButton biblioteca = new JButton("Biblioteca");	// Aqui fica a Pesquisa
	private static JButton obra = new JButton("Obra");	// Aqui os Livros listados por ordem alfabetica.
	private static JButton usuario  = new JButton("Usuario");
	public static ControleDados dados = new ControleDados();
	
	public TelaMenu() {
		titulo.setFont(new Font("Arial", Font.BOLD, 20));
		titulo.setBounds(80, 10, 250, 50);
		livro.setBounds(120, 80, 150, 30);
		emprestimo.setBounds(120, 150, 150, 30);
		biblioteca.setBounds(120, 220, 150, 30);
		obra.setBounds(120, 290, 150, 30);
		usuario.setBounds(120, 360, 150,30);
		
		janela.setLayout(null);
		
		janela.add(titulo);
		janela.add(livro);
		janela.add(emprestimo);
		janela.add(biblioteca);
		janela.add(obra);
		janela.add(usuario);
		
		
		janela.setSize(400, 475);
		janela.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		janela.setVisible(true);
	}
	
	public static void main(String[] args) {
		TelaMenu menu = new TelaMenu();
		
		livro.addActionListener(menu);
		emprestimo.addActionListener(menu);
		biblioteca.addActionListener(menu);
		obra.addActionListener(menu);
		usuario.addActionListener(menu);		
	
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == livro)
			new TelaLivro().mostraDados(dados, 1);

		if(src == emprestimo) {
			new TelaEmprestimo().emprestimoLivros(dados, 2);
		}
		if(src == biblioteca) {
			new TelaBiblioteca().pesquisa(dados, 3);
		
		}
		if(src == obra) {
			new TelaObra().listaOrdemAlfabetica(dados, 4);
		}
		if(src == usuario) {
			new TelaUsuario().mostraUsuarios(dados, 5);
		}

	}
}
