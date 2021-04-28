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
	
	/**
	 * Essa classe tem a funcionalidade de criar
	 * uma janela , titulos, criar a lista de livros cadastrados
	 * e os botões Ja Li, Ainda vou Ler, Salvar e Excluir
	 * Alem de mostra os detalhes do livro
	 * que e o nome e o genero literario
	 * @author Eduardo Ribeiro
	 * @version 1.0 (Abril 2021)
	 */
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
	
	private String[] novoDado = new String[50];	// String para Cadastra/ Editar um livro
	private int posicao;
	private int opcao;
	private String s;
	int quantidadeLido = 3;	// Quantidade de Livros Lidos
	int quantidadePendentes = 2; // Quantidade de Livros Pendentes
	
	/**
	 * Método que mostra a janela de detalhe
	 * do livro e os botões Já Li,
	 * Ainda vou Ler, Salvar e Excluir
	 * @param op opção do switch case
	 * @param d classe ControleDados
	 * @param l classe TelaLivro
	 * @param pos posicao do livro
	 */
	public void inserirEditar(int op, ControleDados d, TelaLivro l, int pos) {
		opcao = op;
		posicao = pos;
		dados = d;
		
		if(op == 1)
			s = "Cadastro de Livro";
		if(op == 3)
			s = "Detalhe de Livro";
		
		janela = new JFrame(s);
		
		if(op == 3) {	// Preenche com os dados do Livro seu nome e genero literario
			valorLivro = new JTextField(dados.getLivros()[pos].getNome(), 200);
			valorGenero = new JTextField(dados.getLivros()[pos].getGeneroLiterario(), 200);
			
			
		} else { // Não preenche com os dados
			valorLivro = new JTextField(200);
			valorGenero = new JTextField(200);
			
			botaoSalvar.setBounds(120, 175, 115, 30); // tamamho do Botao de salvar 
		}
		// tamanho ds botões, Lbalbes e JTextField;
		labelLivro.setBounds(30, 20, 150, 25);
		valorLivro.setBounds(100, 20, 180, 25);
		labelGenero.setBounds(30, 50, 150, 25);
		valorGenero.setBounds(140, 50, 180, 25);
		botaoLido.setBounds(200, 80, 150, 25);
		botaoNaoLido.setBounds(200, 120, 150, 25);
		
		if(op == 3) {
			// Tamanho dos botoes 
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir); // Adicona a janela do botao excluir
		}
		// adiciona todos os botões, Lbalbes e JTextField;
		this.janela.add(labelLivro);
		this.janela.add(valorLivro);
		this.janela.add(labelGenero);
		this.janela.add(valorGenero);
		this.janela.add(botaoSalvar);
		this.janela.add(botaoExcluir);
		this.janela.add(botaoLido);
		this.janela.add(botaoNaoLido);
		
		this.janela.setLayout(null);
		
		this.janela.setSize(400, 250);	// tamanho da janela
		this.janela.setVisible(true);	// mostra a janela 
		
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		botaoLido.addActionListener(this);
		botaoNaoLido.addActionListener(this);
	}
	
	/**
	 * Métod que controla a ação dos bõtoes
	 * Já Li, Ainda vou Ler, Salvar e Excluir
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == botaoSalvar) {	// caso clicke no botao salvar
			try {
				boolean res;
				if(opcao == 1)  // preenche o nome do livro
					novoDado[0] = Integer.toString(dados.getQtdLivros());
				else // não preenche com os dados
					novoDado[0] = Integer.toString(posicao);
				
				
				novoDado[1] = valorLivro.getText();
				novoDado[2] = valorGenero.getText();
				
				if(opcao == 1 || opcao == 3) {
					// cadasta o livro
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
				// exclui o livro
				res = dados.removeLivro(posicao);
				
				if(res) { 
					
					mensagemSucessoExclusao();
					
					
				} else {
					mensagemErroExclusaoLivro();
				}
			}
		}
		if(src == botaoLido) {
			quantidadeLido++;
			// mostra a mensagem de livro lido
			JOptionPane.showMessageDialog(null, "Marcado com Livro Lido ", null,
					JOptionPane.INFORMATION_MESSAGE);
			
		}
		if(src == botaoNaoLido) {
			// mostra o mensagem do livro pedente
			quantidadePendentes++;
			JOptionPane.showMessageDialog(null, "Marcado com Livro Pendente", null,
					JOptionPane.INFORMATION_MESSAGE);
		}
	}
	
	/**
	 * Método que mostra a mensagem de sucesso de um
	 * livro removido
	 */
	public void mensagemSucessoExclusao() {
		JOptionPane.showMessageDialog(null,"O Livro foi Excluido com sucesso", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Método que mostra a mesnsagem de sucesso de um
	 * livro cadastrado
	 */
	public void mensagemSucessoCadastro() {
		JOptionPane.showMessageDialog(null, "O Livro foi salvo com sucesso!", null, 
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}
	
	/**
	 * Método que mostra a mensagem de erro no
	 * cadastro de um livro
	 */
	public void mensagemErroCadastro() {
		JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
				, null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	/**
	 * Método que mostra a mensagem de erro ao
	 * tentar remover um livro
	 */
	public void mensagemErroExclusaoLivro() {
		JOptionPane.showMessageDialog(null,"ERRO AO EXCLUIR DADOS!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
	
	
}
