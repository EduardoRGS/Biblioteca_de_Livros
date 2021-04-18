package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaDetalheEmprestimo implements ActionListener, ListSelectionListener{
	
	private JFrame janela;
	private JLabel labelEmprestimo = new JLabel("Nome do Usuario: ");
	private JTextField valorEmprestimo;
	private JLabel labelEmprestimoLivro = new JLabel("Livro: ");
	private JTextField valorEmprestimoLivro;
	private JButton salvarEmprestimo = new JButton("Fazer Emprestimo");
	private JButton cadastroEmprestimo = new JButton("Salvar");
	private String[] novoEmprestimo = new String[50];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	private JList<String> livrosEmprestados;
	private String[] emEmprestimo = new String[50];
	private String[] aux = new String[50];
	int quant = 0;
	
	private JList<String> devolução;
	private String[] paraDevolver;
	
	public void fazerEmprestimo(int op, ControleDados d,
			 TelaEmprestimo e, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if(op == 1)
			s = "Área de Emprestimo";
		if(op == 2)
			s = "Detalhe de Emprestimo";
		if(op == 3)
			s = "Livros Emprestados";
		
		
		janela = new JFrame(s);
		switch(op){
		case 1:
			if(op == 1) {
				valorEmprestimo = new JTextField(dados.getUsuarios()[pos].getNomeUsuario());
				valorEmprestimoLivro = new JTextField(dados.getLivros()[pos].getNome());
			} else {
				valorEmprestimo = new JTextField(200);
				valorEmprestimoLivro = new JTextField(200);
				
				cadastroEmprestimo.setBounds(200, 175, 155, 30);
			}
			
			
			labelEmprestimo.setBounds(30, 20, 150, 30);
			valorEmprestimo.setBounds(140, 20, 180, 25);
			labelEmprestimoLivro.setBounds(30, 50, 150, 25);
			valorEmprestimoLivro.setBounds(80, 50, 180, 25);
			
			if(op == 1) {
				salvarEmprestimo.setBounds(120, 175, 155, 30);
				this.janela.add(salvarEmprestimo);
			}
			
			this.janela.add(labelEmprestimo);
			this.janela.add(valorEmprestimo);
			this.janela.add(labelEmprestimoLivro);
			this.janela.add(valorEmprestimoLivro);
			this.janela.add(salvarEmprestimo);
			this.janela.add(cadastroEmprestimo);
			
			this.janela.setLayout(null);
			
			this.janela.setSize(400, 250);
			this.janela.setVisible(true);
			
			salvarEmprestimo.addActionListener(this);
			cadastroEmprestimo.addActionListener(this);
			break;
		case 2:
			break;
		case 3:
			quant++;
			for(int j = 0; j< quant; j++) {
				aux[j] = d.remove;
				emEmprestimo[j] = aux[j];
			}
			
			livrosEmprestados = new JList<String>(emEmprestimo);
			livrosEmprestados.setBounds(20, 50, 350, 120);
			livrosEmprestados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			livrosEmprestados.setVisibleRowCount(10);
			
			janela.add(livrosEmprestados);
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			livrosEmprestados.addListSelectionListener(e);
			break;
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		String pesquisa2;
		String pesquisa1;
		String lista[] = new  String[50];
		
		if(src == salvarEmprestimo) {
			boolean res = false;
			
			
			if(opcao == 1) {
				novoEmprestimo[0] = Integer.toString(dados.getQtdUsuarios());
				novoEmprestimo[0] = Integer.toString(dados.getQtdLivros());
			} else 
				novoEmprestimo[0] = Integer.toString(posicao);
			
				
			
			novoEmprestimo[1] = valorEmprestimo.getText();
			novoEmprestimo[2] = valorEmprestimoLivro.getText();
			
			if(opcao == 1) {
			pesquisa1 = novoEmprestimo[1];
			pesquisa2 = novoEmprestimo[2];
				if(dados.pesquisa(pesquisa2) >= 0 && dados.pesquisaUsuario(pesquisa1) >= 0) {
				res = dados.removeLivro(posicao);
				res = dados.removeUsuario(posicao);
				
				}
			}
			if(res) {
				
				mensagemSucessoEmprestimo();
				
			}
			 else 
				mensagemErroExclusaoEmprestimo();
			
		}
		
	}
	
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == livrosEmprestados) {
			new TelaDetalheEmprestimo().fazerEmprestimo(3, dados, null, 
				livrosEmprestados.getSelectedIndex());
			
			
		}
	}
	
	public void mensagemSucessoEmprestimo() {
		JOptionPane.showMessageDialog(null,"O Emprestimo foi realizado com sucesso", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroExclusaoEmprestimo() {
		JOptionPane.showMessageDialog(null,"ERRO AO REALIZAR EMPRESTIMO!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO REALIZAR CADASTRO DO EMPRESTIMO!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null,"O Cadastro do Emprestimo foi realizado com sucesso", null,
				JOptionPane.INFORMATION_MESSAGE);
	}
}
