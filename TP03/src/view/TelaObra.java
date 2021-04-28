package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Collections;
import java.util.SortedSet;
import java.util.TreeSet;

import javax.swing.*;
import javax.swing.event.*;
import controle.*;

	/**
	 * Essa classe tem a funcionalidade de criar
	 * uma janela, titulos, uma lista de livros
	 * em ordem alfabetica, quantidade de livros
	 * e os bot�es Ordem Alfabetica e Estatistica
	 * @author Eduardo Ribeiro
	 * @version 1.0 (Abril 2021)
	 */
public class TelaObra implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton refreshOA;
	private JButton estatistica;
	private static ControleDados dados;
	private JList<String> listaOrdemLivros;
	private String[] listaOrdem = new String[50];
	
	/**
	 * M�todo que mostra a lista de livros cadastrados
	 * e os bot�es Ordem Alfabetica e Estatistica
	 * @param d ControleDados
	 * @param op op��o do switch case
	 */
	public void listaOrdemAlfabetica(ControleDados d, int op) {
		dados = d;
		
		switch (op) {
		case 4:
			// lista dos livros
			listaOrdem = new ControleLivro(dados).getNomeLivro();
			listaOrdemLivros = new JList<String>(listaOrdem);
			
			// nome dos jfrmae, jlabel, jbuttons.
			janela = new JFrame("Organiza��o");
			titulo = new JLabel("Livros");
			refreshOA = new JButton("Ordem Alfabetica");
			estatistica = new JButton("Estat�stica");
			
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
	
	/**
	 * M�todo que controla a a��o
	 * dos bot�es Ordem Alfabetica e Estatistica
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == refreshOA) { // atualiza a lista em ordem alfabeticva
			
			listaOrdemLivros.setListData(new ControleLivro(dados).getNomeLivro());
			listaOrdemLivros.updateUI();
			JOptionPane.showMessageDialog(null,"Essa op��o n�o foi configurada ", null,
					JOptionPane.INFORMATION_MESSAGE);
			
	
		}
		if(src == estatistica) { // mostra a quantidade de livros lidos,pendentes e totais.
			JOptionPane.showMessageDialog(null, "Quantidade de Livros Lidos "+new TelaDetalheLivro().quantidadeLido+
					"\n Qunatidade de Livros Pendentes "+new TelaDetalheLivro().quantidadePendentes+
					"\n Quantidade Total de Livros "+dados.getQtdLivros(), null,
					JOptionPane.INFORMATION_MESSAGE);
		}
			
			
	}
	
	/**
	 * M�todo atualiza a lista de livros cadastrados
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		if(e.getValueIsAdjusting() && src == listaOrdemLivros) {
			
		}
	}
	
}
