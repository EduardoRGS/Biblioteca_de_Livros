package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.event.*;
import controle.*;


public class TelaObra implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton refreshOA;
	private JButton estatistica;
	private static ControleDados dados;
	private JList<String> listaOrdemLivros;
	private String[] listaOrdem = new String[50];
	
	public void listaOrdemAlfabetica(ControleDados d, int op) {
		dados = d;
		
		switch (op) {
		case 4:
			// lista dos livros
			listaOrdem = new ControleLivro(dados).getNomeLivro();
			listaOrdemLivros = new JList<String>(listaOrdem);
			
			// nome dos jfrmae, jlabel, jbuttons.
			janela = new JFrame("Organização");
			titulo = new JLabel("Livros");
			refreshOA = new JButton("Ordem Alfabetica");
			estatistica = new JButton("Estatística");
			
			// tamamnho do titulo e jlist
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(20, 10, 150, 30);
			listaOrdemLivros.setBounds(20, 50, 350, 120);
			listaOrdemLivros.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaOrdemLivros.setVisibleRowCount(10);
			
			// tamanho dos botoes
			refreshOA.setBounds(20, 177, 150, 30);
			estatistica.setBounds(200, 177, 150, 30);
			
			janela.setLayout(null);
			
			// adiciona a janela do titulo, jlist botoes.
			janela.add(titulo);
			janela.add(listaOrdemLivros);
			janela.add(refreshOA);
			janela.add(estatistica);
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			refreshOA.addActionListener(this);
			estatistica.addActionListener(this);
			listaOrdemLivros.addListSelectionListener(this);
			
			break;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == refreshOA) { // atualiza a lista em ordem alfabeticva
			
			listaOrdemLivros.setListData(new ControleLivro(dados).getNomeLivro());
			listaOrdemLivros.updateUI();
			JOptionPane.showMessageDialog(null,"Essa opção não foi configurada ", null,
					JOptionPane.INFORMATION_MESSAGE);
			
	
		}
		if(src == estatistica) { // mostra aquantidade de livros lidos,pendentes e totais.
			JOptionPane.showMessageDialog(null, "Quantidade de Livros Lidos "+new TelaDetalheLivro().quantidadeLido+
					"\n Qunatidade de Livros Pendentes "+new TelaDetalheLivro().quantidadePendentes+
					"\n Quantidade Total de Livros "+dados.getQtdLivros(), null,
					JOptionPane.INFORMATION_MESSAGE);
		}
			
			
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		if(e.getValueIsAdjusting() && src == listaOrdemLivros) {
			
		}
	}
	
}
