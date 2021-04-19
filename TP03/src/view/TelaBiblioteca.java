package view;

import java.awt.*;
import modelo.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaBiblioteca implements ActionListener{
	private JFrame janela;	
	private JLabel titulo;
	private JButton pesquisa;	// Botão para Pesquisar
	private JTextField valorPesquisa;	// JTextField para escrever o livro que quer pesquisar
	private static ControleDados dados;
	private String s;
	private int opcao;
	
	
	public void pesquisa(ControleDados d, int op) {
		dados = d;
		opcao = op;
		
		switch (op) {
		case 3:
			
			janela = new JFrame("Busca de Livros");
			titulo = new JLabel("Pesquisar Livros");
			pesquisa = new JButton("Pesquisar");
			valorPesquisa = new JTextField(200);
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(100, 10, 250, 30);
			pesquisa.setBounds(130, 105, 100,30);
			valorPesquisa.setBounds(30, 70, 300, 30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(pesquisa);
			janela.add(valorPesquisa);
			
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			pesquisa.addActionListener(this);
			
			break;
			
		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null
			,JOptionPane.ERROR_MESSAGE);
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == pesquisa) {	// Pesquisa o Livro
			if(opcao == 3) {
				s = valorPesquisa.getText();
				if(dados.pesquisa(s) >= 0) {
					
					mensagemSucessoPesquisa();	// Caso livro igual o livro pesquisado
				} else {
					
					 mensagemErroPesquisa();	// Caso livro pesquisa não for igual livros cadasrados
				}
			}
		}
	}
	public void mensagemSucessoPesquisa() {
		
		JOptionPane.showMessageDialog(null, "Livro Pesquisado encontrado", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	public void mensagemErroPesquisa() {
		JOptionPane.showMessageDialog(null,"LIVRO NÃO ENCONTRADO!\n"
				+ "Pesquise novamente!!!"
				, null, 
				JOptionPane.ERROR_MESSAGE);
	}

}
