package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaObra implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton refresh;
	private static ControleDados dados;
	private JList<String> listaOrdemLivros;
	private String[] listaOrdem = new String[50];
	
	public void listaOrdemAlfabetica(ControleDados d, int op) {
		dados = d;
		
		switch (op) {
		case 4:
			listaOrdem = new ControleLivro(dados).getNomeLivro();
			listaOrdemLivros = new JList<String>(listaOrdem);
			janela = new JFrame("Organiza��o");
			titulo = new JLabel("Livros");
			refresh = new JButton("Ordem Alfabetica");
			
			titulo.setFont(new Font("Arial", Font.BOLD, 20));
			titulo.setBounds(20, 10, 150, 30);
			listaOrdemLivros.setBounds(20, 50, 350, 120);
			listaOrdemLivros.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaOrdemLivros.setVisibleRowCount(10);
			
			refresh.setBounds(20, 177, 150, 30);
			
			
			janela.setLayout(null);
			
			janela.add(titulo);
			janela.add(listaOrdemLivros);
			janela.add(refresh);
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			refresh.addActionListener(this);
			listaOrdemLivros.addListSelectionListener(this);
			
			break;
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		if(e.getValueIsAdjusting() && src == listaOrdemLivros) {
			
		}
	}
	
}
