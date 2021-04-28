package view;

	
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;
		
	/**
	 * Essa classe tem a funcionalidade de criar
	 * uma janela, titulos, uma lista de livros emprestados
	 * e os bot�es Fazer Emprestimo
	 * Al�m de mostra os detalhes com o 
	 * nome do livro e do usuario
	 * @author Lara Giuliana
	 * @version 1.0 (Abril 2021)
	 */

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
	
	private JList<String> livrosEmprestados;	// lista o Livro Emprestado
	private String[] emEmprestimo = new String[50];	
	int quant = 0;
	
	
	/**
	 * M�todo que mostra a janela 
	 * de datalhe do emprestimo 
	 * e o bot�o de Fazer Emprestimo
	 * @param op op��o so switch case
	 * @param d classe ControleDados
	 * @param e classe TelaEmprestimo
	 * @param pos posi��o do livro
	 */
	public void fazerEmprestimo(int op, ControleDados d,
			 TelaEmprestimo e, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if(op == 1)
			s = "�rea de Emprestimo";
		if(op == 2)
			s = "Detalhe de Emprestimo";
		if(op == 3)
			s = "Livros Emprestados";
		
		
		janela = new JFrame(s);
		switch(op){
		case 1:
			if(op == 1) {	// Preenche dados com dados do Livro e Usuario clicando
				valorEmprestimo = new JTextField(dados.getUsuarios()[pos].getNomeUsuario());
				valorEmprestimoLivro = new JTextField(dados.getLivros()[pos].getNome());
			} else { // N�o preenche com dados
				valorEmprestimo = new JTextField(200);
				valorEmprestimoLivro = new JTextField(200);
				
				cadastroEmprestimo.setBounds(200, 175, 155, 30);
			}
			// tamanho de bot�es e JTextField
			
			labelEmprestimo.setBounds(30, 20, 150, 30);	
			valorEmprestimo.setBounds(140, 20, 180, 25);
			labelEmprestimoLivro.setBounds(30, 50, 150, 25);
			valorEmprestimoLivro.setBounds(80, 50, 180, 25);
			
			if(op == 1) {
				salvarEmprestimo.setBounds(120, 175, 155, 30);
				this.janela.add(salvarEmprestimo);	
			}
			// Adiciona as janelas do bot�es e JTextsFileds
			this.janela.add(labelEmprestimo);	
			this.janela.add(valorEmprestimo);
			this.janela.add(labelEmprestimoLivro);
			this.janela.add(valorEmprestimoLivro);
			this.janela.add(salvarEmprestimo);
			this.janela.add(cadastroEmprestimo);
			
			this.janela.setLayout(null);	// Sem layaout
			
			this.janela.setSize(400, 250);	// Define o Tamanho da Janela
			this.janela.setVisible(true);	// Torna visivel a janela
			
			salvarEmprestimo.addActionListener(this);	// Adiocna a a��o dos bot�es
			cadastroEmprestimo.addActionListener(this);
			break;
		case 3:
			quant++;
			
			for(int j = 0; j< quant; j++) { // Pega p Livro que foi Emprestado
				emEmprestimo[j] = d.remove;
			
			}
			
			livrosEmprestados = new JList<String>(emEmprestimo);	// lista o livro emprstado
			livrosEmprestados.setBounds(20, 50, 350, 120);	// Tamanho do JList
			livrosEmprestados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);	
			livrosEmprestados.setVisibleRowCount(10);	
			
			janela.add(livrosEmprestados); // Adiciona a janela do Jlist
			janela.setSize(400, 250);	// Tamaho da janela do Jlist
			janela.setVisible(true);	// Torna a janela visivel
			
			livrosEmprestados.addListSelectionListener(this);// Fun��o de 
			break;
		}
		
	}
	
	/**
	 * M�todo que controla a a��o dos bot�es Emprestimo, Em emprestimo e Refresh
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		String pesquisa2;
		String pesquisa1;
		
		if(src == salvarEmprestimo) {
			boolean res = false;
			
			
			if(opcao == 1) { // Preenche os dados do livro e do usuario
				novoEmprestimo[0] = Integer.toString(dados.getQtdUsuarios());
				novoEmprestimo[0] = Integer.toString(dados.getQtdLivros());
			} else // N�o preeche os dados
				novoEmprestimo[0] = Integer.toString(posicao);
			
				
			
			novoEmprestimo[1] = valorEmprestimo.getText();	// JtextFiled do Usuario
			novoEmprestimo[2] = valorEmprestimoLivro.getText();// JTextFiled do Livro
			
			if(opcao == 1) {
			pesquisa1 = novoEmprestimo[1]; // Pesquisa1 adiquire o nome do usuariu
			pesquisa2 = novoEmprestimo[2];	// Pesquisa2 adquire o nome do livro
				if(dados.pesquisa(pesquisa2) >= 0 && dados.pesquisaUsuario(pesquisa1) >= 0) {	
					res = dados.removeLivro(posicao);
					res = dados.removeUsuario(posicao);
				// So da para fazer emprestimo se houver um usaurio e livro cadastrado
				}
				
			}
			if(res) {
				
				mensagemSucessoEmprestimo();
				
			}
			 else 
				mensagemErroExclusaoEmprestimo();
			
		}
		
	}
	
	/**
	 * M�todo que atualiza a lista de livros na 
	 * Classe TelaEmprestimo
	 */
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == livrosEmprestados) { // atualiza do JList
			new TelaDetalheEmprestimo().fazerEmprestimo(3, dados, null, 
				livrosEmprestados.getSelectedIndex());
		}
	}
	
	/**
	 * M�todo que mostra a mesagem de sucesso do emprestimo
	 */
	public void mensagemSucessoEmprestimo() {
		JOptionPane.showMessageDialog(null,"O Emprestimo foi realizado com sucesso", null,
				JOptionPane.INFORMATION_MESSAGE);
		janela.dispose();
	}

	/**
	 * M�todo que mostra a mesagem de erro do emprestimo
	 */
	public void mensagemErroExclusaoEmprestimo() {
		JOptionPane.showMessageDialog(null,"ERRO AO REALIZAR EMPRESTIMO!\n ", null, 
				JOptionPane.ERROR_MESSAGE);
	}
}
