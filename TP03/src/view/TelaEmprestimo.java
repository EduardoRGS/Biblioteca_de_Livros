package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaEmprestimo implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroEmprestimo;
	private JButton emEmprestimo;
	private JButton refreshEmprestimo;
	private static ControleDados dados;
	private JList<String> livrosBiblioteca;
	private String[] listaBiblioteca;
	
	public void emprestimoLivros(ControleDados d, int op) {
		dados = d;
		
		switch(op) {
		case 2:
			listaBiblioteca = new ControleLivro(dados).getNomeLivro(); // adiona os livros no vetor de String
			livrosBiblioteca = new JList<String>(listaBiblioteca);	// adiona o vetor de string no Jlist
			
			// nomes de jbuttos, jframe, jlabel.
			janela = new JFrame("Emprestimo de Livros");
			titulo = new JLabel("Livros na Biblioteca");
			cadastroEmprestimo = new JButton("Emprestimo");
			emEmprestimo = new JButton("Em Emprestimo");
			refreshEmprestimo = new JButton("Refresh");
			
			// tamanho de titulo e JList
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			livrosBiblioteca.setBounds(20, 50, 350, 120);
			livrosBiblioteca.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			livrosBiblioteca.setVisibleRowCount(10);
			
			// tamamho dos botoes
			cadastroEmprestimo.setBounds(100, 177, 180, 30);
			emEmprestimo.setBounds(20, 220, 150, 30);
			refreshEmprestimo.setBounds(220, 220, 150,30);
			
			janela.setLayout(null);
			
			// adicona as janelas do titulo, jlis, botoes.;
			janela.add(titulo);
			janela.add(livrosBiblioteca);
			janela.add(cadastroEmprestimo);
			janela.add(emEmprestimo);
			janela.add(refreshEmprestimo);
			
			janela.setSize(400, 400);
			janela.setVisible(true);
			
			cadastroEmprestimo.addActionListener(this);
			emEmprestimo.addActionListener(this);
			livrosBiblioteca.addListSelectionListener(this);
			refreshEmprestimo.addActionListener(this);
			
			
			break;
			
			default:
				JOptionPane.showMessageDialog(null,"Opção não encontrada", null,
						JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroEmprestimo) { // botao informativo sobre comop fazer o emprestimo
			JOptionPane.showMessageDialog(null, "Para fazer emprestimo além dos "
					+ "Livros Listados\n cadastre um novo Livro "
					+ "e um  novo Usuario", null,
					JOptionPane.INFORMATION_MESSAGE);
		}
		if(src == emEmprestimo) {	// botao que mostra o livro que esta emprestado no momento
			new TelaDetalheEmprestimo().fazerEmprestimo(3, dados, this, 0);
		}
		if(src == refreshEmprestimo) {	// atualiza  a lista
			livrosBiblioteca.setListData(new ControleLivro(dados).getNomeLivro());
			livrosBiblioteca.updateUI();
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == livrosBiblioteca) {
			new TelaDetalheEmprestimo().fazerEmprestimo(1, dados, this, 
					livrosBiblioteca.getSelectedIndex());
		} else {
			JOptionPane.showMessageDialog(null,"Cadastre um usuario para poder fazer o "
					+ "emprestimo do Livro", null,
					JOptionPane.INFORMATION_MESSAGE);
		}
		
	}
	
	
}
