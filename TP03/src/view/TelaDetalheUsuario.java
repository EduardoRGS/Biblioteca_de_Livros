package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;
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
		
		if(op == 2) {
			valorUsuario = new JTextField(dados.getUsuarios()[pos].getNomeUsuario(), 200);
		} else {
			valorUsuario = new JTextField(200);
			
			botaoSalvar.setBounds(245, 175, 115, 30);
		}
		
		labelUsuario.setBounds(30 ,20, 150, 25);
		valorUsuario.setBounds(100, 20, 100, 25);
		
		if(op == 2) {
			botaoSalvar.setBounds(120, 175, 115, 30);
			botaoExcluir.setBounds(245, 175, 115, 30);
			this.janela.add(botaoExcluir);
		}
		
		this.janela.add(labelUsuario);
		this.janela.add(valorUsuario);
		this.janela.add(botaoSalvar);
		
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
					novoUsuario[0] = Integer.toString(dados.getQtdUsuarios());
				else 
					novoUsuario[0] = Integer.toString(posicao);
				
				novoUsuario[1] = valorUsuario.getText();
				
				if(opcao == 1) {
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
			
			if(opcao == 2) {
				res = dados.removeUsuario(posicao);
				if(res) mensagemSucessoExclusao();
				else mensagemErroExclusaoUsuario();
			}
		}
	}
	
		public void mensagemSucessoExclusao() {
			JOptionPane.showMessageDialog(null, "Os dados foram excluidos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}

		public void mensagemSucessoCadastro() {
			JOptionPane.showMessageDialog(null, "Os dados foram salvos com sucesso!", null, 
					JOptionPane.INFORMATION_MESSAGE);
			janela.dispose();
		}

		public void mensagemErroCadastro() {
			JOptionPane.showMessageDialog(null,"ERRO AO SALVAR OS DADOS!\n "
					, null, 
					JOptionPane.ERROR_MESSAGE);
		}

		public void mensagemErroExclusaoUsuario() {
			JOptionPane.showMessageDialog(null,"Ocorreu um erro ao excluir o dado.\n "
					, null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
}
