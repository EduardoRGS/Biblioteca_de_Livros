package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;
	
	/**
	 * Essa classe tem a funcionalidade de criar 
	 * uma janela, titulos e os botões Salvar e Excluir
	 * Além de mostra os detalhes no nome do usuario cadastrado
	 * @author Lara Giuliana
	 * @version 1.0 (Abril 2021)
	 */
public class TelaDetalheUsuario implements ActionListener {
	private JFrame janela;
	private JLabel labelUsuario = new JLabel("Nome: ");
	private JTextField valorUsuario;
	private JButton botaoSalvar = new JButton("Salvar");
	private JButton botaoExcluir = new JButton("Excluir");
	private String[] novoUsuario = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	/**
	 * Método que mostra a janela de detalhe
	 * do usuario com os botões Salvar e Excluir
	 * @param op opção do switch case
	 * @param d classe ControleDados
	 * @param u classe TelaUsuario
	 * @param pos posição do usuario
	 */
	public void inserirEditar(int op, ControleDados d,
			TelaUsuario u, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if(op == 1)
			s = "Cadastro Usuario";
		if(op == 2)
			s = "Detalhe de Usuario";
		
		janela = new JFrame(s);
		
		if(op == 2) {// preenche os dados do nome do usuario
			valorUsuario = new JTextField(dados.getUsuarios()[pos].getNomeUsuario(), 200);
		} else { // nao preenche com o nome do usaurio
			valorUsuario = new JTextField(200);
			// adicona o tamanho do botao salvar
			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		// tamanho do label e JTextFild usuario
		labelUsuario.setBounds(30 ,20, 150, 25);
		valorUsuario.setBounds(100, 20, 100, 25);
		
		if(op == 2) { // adicona o tamanho os botoes excluir e salvare a janela do botao excluir
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}
		// adiocna as jaenla do label, jtextflied e botao salvar
		this.janela.add(labelUsuario);
		this.janela.add(valorUsuario);
		this.janela.add(botaoSalvar);
		
		this.janela.setLayout(null);
		
		this.janela.setSize(400, 250);
		this.janela.setVisible(true);
		
		botaoSalvar.addActionListener(this);
		botaoExcluir.addActionListener(this);
		
	}
	
	/**
	 * Método que controla a ação dos
	 * botões Salvar e Excluir
	 */
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		if(src == botaoSalvar) {
			try {
				boolean res;
				if(opcao == 1) // prrenche os dados do usuario
					novoUsuario[0] = Integer.toString(dados.getQtdUsuarios());
				else 
					novoUsuario[0] = Integer.toString(posicao);
				
				novoUsuario[1] = valorUsuario.getText();
				
				if(opcao == 1) { // Cadastra um usuario
					res = dados.inserirEditarUsuario(novoUsuario);
				}
				
				if(res = true) 
					mensagemSucessoCadastro();
				else 
					mensagemErroCadastro();
				
				
			}	catch (NullPointerException exc1) {
					mensagemErroCadastro();
			}	catch (NumberFormatException ecx2) {
					mensagemErroCadastro();
			}
		}
		
		if(src == botaoExcluir) {
			boolean res = false;
			
			if(opcao == 2) { // Remove um usuario
				res = dados.removeUsuario(posicao);
				if(res) mensagemSucessoExclusao();
				else mensagemErroExclusaoUsuario();
			}
		}
	}
		/**
		 * Método que mostra a mensagem de sucesso
		 * de um usuario removido
		 */
	
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}
		
		/**
		 * Método que mostra a mesnsagem de sucesso
		 * de um novo usaurio cadastrado
		 */
		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}

		/**
		 * Método que mostra a mensagem de erro
		 * caso não consiga cadastra um novo usuario
		 */
		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
					, null, 
					JOptionPane.ERROR_MESSAGE);
		}
		/**
		 * Método que mostra a mensagem de erro
		 * caso não consiga remover um usuario
		 */
		public void mensagemErroExclusaoUsuario() {
			JOptionPane.showMessageDialog(null,"OCORREU UM ERRO AO EXCLUIR O USUARIO.\n "
					, null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
}
