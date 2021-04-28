package view;

import java.awt.*;
import java.awt.event.*;
import java.util.Arrays;

import javax.swing.*;
import javax.swing.event.*;
import controle.*;
	
	/**
	 * Essa classe tem a funcionalidade de criar
	 * uma janela, titulos, uma lista de livros cadastrados
	 * e os botões Cadastrar e Refresh
	 * Além de atualizar a lista de livros
	 * @author Eduardo Ribeiro
	 * @version 1.0 (Abril 2021)
	 */
public class TelaLivro implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastraLivro;
	private JButton refreshLivro;
	private static ControleDados dados;
	private JList<String> listaLivrosCadastrados;
	private String[] listaLivros = new String[50];
	
	/**
	 * Método que mostra a lista de livros cadastrados
	 * e os botões Cadastrar e Refresh
	 * @param d classe ControleDados
	 * @param op opção do switch case
	 */
	public void mostraDados(ControleDados d, int op) {
		dados = d;
		
		switch (op) {
		case 1:
			listaLivros = new ControleLivro(dados).getNomeLivro(); // nome do livro no veotr de string
			listaLivrosCadastrados = new JList<String>(listaLivros); // adicona o vetor de string no jlist
			janela = new JFrame("Livros");
			titulo = new JLabel("Livros Cadastrados");
			
			cadastraLivro = new JButton("Cadastrar");
			refreshLivro = new JButton("Refresh");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 10, 250, 30);
			listaLivrosCadastrados.setBounds(20, 50, 350, 120);
			listaLivrosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaLivrosCadastrados.setVisibleRowCount(10);
			
			// tamanho dos botoes
			cadastraLivro.setBounds(70, 177, 100, 30); 
			refreshLivro.setBounds(200, 177, 100, 30);
			
			janela.setLayout(null);
			
			// adciona as janelas do titulo, jlist e botoes.
			janela.add(titulo);
			janela.add(listaLivrosCadastrados);
			janela.add(cadastraLivro);
			janela.add(refreshLivro);
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			cadastraLivro.addActionListener(this);
			refreshLivro.addActionListener(this);
			listaLivrosCadastrados.addListSelectionListener(this);
			
			break;
			
		default:
			JOptionPane.showMessageDialog(null, "Opção não encontrada", null,
				JOptionPane.ERROR_MESSAGE);
			
		}
	}
	
	/**
	 * Método que faz a ações dos
	 * botões Cadastrar e Refresh
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastraLivro) { // cadastra/ edita livro
			new TelaDetalheLivro().inserirEditar(1, dados, this, 0);
		}
		
		if(src == refreshLivro) { // atualiza a lista caso ocorra editao ou novo cadastro de livro
			
			listaLivrosCadastrados.setListData(new ControleLivro(dados).getNomeLivro());
			listaLivrosCadastrados.updateUI();
		}
	}
	
	/**
	 * Método que mostra e atualiza a lista de 
	 * livros cadastrados
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaLivrosCadastrados) {
			new TelaDetalheLivro().inserirEditar(3, dados, this,
				listaLivrosCadastrados.getSelectedIndex());
		}
	}
	

}
