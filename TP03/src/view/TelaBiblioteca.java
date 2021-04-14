package view;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaBiblioteca implements ActionListener{
	private JFrame janela;
	private JLabel titulo;
	private JButton pesquisa;
	private JTextField valorPesquisa;
	private static ControleDados dados;
	
	public void pesquisa(ControleDados d, int op) {
		dados = d;
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
			janela.add(valorPesquisa);
			janela.add(pesquisa);
			
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
		if(src == pesquisa) {
			
		}
	}
	

}
