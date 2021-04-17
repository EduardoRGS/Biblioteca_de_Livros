package view;

import java.awt.event.ActionEvent;
import java.util.Arrays;
import modelo.*;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;

public class TelaDetalheLivro implements ActionListener {
	
	private JFrame janela;
	private JLabel labelLivro = new JLabel("Nome: ");
	private JTextField valorLivro;
	private JLabel labelGenero = new JLabel ("Genero Literário: ");
	private JTextField valorGenero;
	
	private JButton botaoLido = new JButton("Já Li");
	private JButton botaoNaoLido = new JButton("Ainda vou Ler");
	private JButton botaoExcluir = new JButton("Excluir");
	private JButton botaoSalvar = new JButton("Salvar");
	private static ControleDados dados;
	
	private String[] novoDado = new String[9];
	private int posicao;
	private int opcao;
	private String s;
	public void inserirEditar(int op, ControleDados d, TelaLivro l, int pos) {
		opcao = op;
		posicao = pos;
		dados = d;
		
		if(op == 1)
			s = "Cadastro de Livro";
		if(op == 3)
			s = "Detalhe de Livro";
		
		janela = new JFrame(s);
		
		if(op == 3) {
			valorLivro = new JTextField(dados.getLivros()[pos].getNome(), 200);
			valorGenero = new JTextField(dados.getLivros()[pos].getGeneroLiterario(), 200);
			
			
		} else {
			valorLivro = new JTextField(200);
			valorGenero = new JTextField(200);
			
			botaoSalvar.setBounds(120, 175, 115, 30);
		}
		
		labelLivro.setBounds(30, 20, 150, 25);
		valorLivro.setBounds(100, 20, 180, 25);
		labelGenero.setBounds(30, 50, 150, 25);
		valorGenero.setBounds(140, 50, 180, 25);
		botaoLido.setBounds(200, 80, 150, 25);
		botaoNaoLido.setBounds(200, 120, 150, 25);
		
		if(op == 3) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}
		
		this.janela.add(labelLivro);
		this.janela.add(valorLivro);
		this.janela.add(labelGenero);
		this.janela.add(valorGenero);
		this.janela.add(botaoSalvar);
		this.janela.add(botaoExcluir);
		this.janela.add(botaoLido);
		this.janela.add(botaoNaoLido);
		
		this.janela.setLayout(null);
		
		this.janela.setSize(400, 250);
		this.janela.setVisible(true);
		
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) 
					novoDado[0] = Integer.toString(dados.getQtdLivros());
				else 
					novoDado[0] = Integer.toString(posicao);
				
				
				novoDado[1] = valorLivro.getText();
				novoDado[2] = valorGenero.getText();
				
				if(opcao == 1 || opcao == 3) {
					
					res = dados.inserirEditarLivro(novoDado);
					
					
				}
				if(res = true) {
					mensagemSucessoCadastro();
				}
				else mensagemErroCadastro();
				
					
			} catch (NullPointerException ex1) {
				mensagemErroCadastro();
			} catch (NumberFormatException ex2) {
				mensagemErroCadastro();
			}
		}
		
		if(src == botaoExcluir) {
			boolean res = false;
			
			if(opcao == 3) {
				
				res = dados.removeLivro(posicao);
				
				if(res) { 
					mensagemSucessoExclusao();
					
				} else {
					mensagemErroExclusaoLivro();
				}
			}
		}
		
	}
	

	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null,"O Livro foi Excluido com sucesso", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "O Livro foi salvo com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				, null, 
				JOptionPane.ERROR_MESSAGE);
	}

	public void mensagemErroExclusaoLivro() {
		JOptionPane.showMessageDialog(null,"ERRO AO EXCLUIR DADOS!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	
	
}
