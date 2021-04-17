package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaEmprestimo implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton fazerEmprestimo;
	private JButton devolverLivro;
	private JButton emEmprestimo;
	private JButton refreshEmprestimo;
	private static ControleDados dados;
	private JList<String> livrosBiblioteca;
	private String[] listaBiblioteca;
	
	public void emprestimoLivros(ControleDados d, int op) {
		dados = d;
		
		switch(op) {
		case 2:
			listaBiblioteca = new ControleLivro(dados).getNomeLivro();
			livrosBiblioteca = new JList<String>(listaBiblioteca);
			janela = new JFrame("Emprestimo de Livros");
			titulo = new JLabel("Livros na Biblioteca");
			fazerEmprestimo = new JButton("Fazer Emprestimo");
			devolverLivro = new JButton("Devolver Emrestimo");
			emEmprestimo = new JButton("Em Emprestimo");
			refreshEmprestimo = new JButton("Refresh");
			
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			livrosBiblioteca.setBounds(20, 50, 350, 120);
			livrosBiblioteca.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			livrosBiblioteca.setVisibleRowCount(10);
			
			fazerEmprestimo.setBounds(20, 177, 150, 30);
			devolverLivro.setBounds(220, 177, 150, 30);
			emEmprestimo.setBounds(20, 220, 150, 30);
			refreshEmprestimo.setBounds(220, 220, 150,30);
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(livrosBiblioteca);
			janela.add(fazerEmprestimo);
			janela.add(devolverLivro);
			janela.add(emEmprestimo);
			janela.add(refreshEmprestimo);
			
			janela.setSize(400, 300);
			janela.setVisible(true);
			
			fazerEmprestimo.addActionListener(this);
			devolverLivro.addActionListener(this);
			emEmprestimo.addActionListener(this);
			livrosBiblioteca.addListSelectionListener(this);
			
			break;
			
			default:
				JOptionPane.showMessageDialog(null,"Opção não encontrada", null,
						JOptionPane.ERROR_MESSAGE);
		}
			
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == fazerEmprestimo) {
			new TelaDetalheEmprestimo().fazerEmprestimo(1, dados, this, 0);
		}
		if(src == devolverLivro) {
			
		}
		if(src == emEmprestimo) {
			
		}
		if(src == refreshEmprestimo) {
			livrosBiblioteca.setListData(new ControleLivro(dados).getNomeLivro());
			livrosBiblioteca.updateUI();
		}
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == livrosBiblioteca) {
			new TelaDetalheEmprestimo().fazerEmprestimo(2, dados, null, 
					livrosBiblioteca.getSelectedIndex());
		}
	}
	
	
}
