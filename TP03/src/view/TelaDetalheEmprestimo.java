package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import controle.*;

public class TelaDetalheEmprestimo implements ActionListener {
	
	private JFrame janela;
	private JLabel labelEmprestimo = new JLabel("Nome do Usuario: ");
	private JTextField valorEmprestimo;
	private JLabel labelEmprestimoLivro = new JLabel("Livro: ");
	private JTextField valorEmprestimoLivro;
	private JButton salvarEmprestimo = new JButton("Salvar");
	private String[] novoEmprestimo = new String[9];
	private static ControleDados dados;
	private int posicao;
	private int opcao;
	private String s;
	
	public void fazerEmprestimo(int op, ControleDados d,
			 TelaEmprestimo e, int pos) {
		
		opcao = op;
		posicao = pos;
		dados = d;
		
		if(op == 1)
			s = "Área de Emprestimo";
		if(op == 2)
			s = "Detalhe de Emprestimo";
		
		janela = new JFrame(s);
		
		if(op == 2) {
			valorEmprestimo = new JTextField(dados.getUsuarios()[pos].getNomeUsuario());
			valorEmprestimoLivro = new JTextField(dados.getLivros()[pos].getNome());
		} else {
			valorEmprestimo = new JTextField(200);
			valorEmprestimoLivro = new JTextField(200);
			
			salvarEmprestimo.setBounds(200, 175, 155, 30);
		}
		
		labelEmprestimo.setBounds(30, 20, 150, 30);
		valorEmprestimo.setBounds(140, 20, 180, 25);
		labelEmprestimoLivro.setBounds(30, 50, 150, 25);
		valorEmprestimoLivro.setBounds(80, 50, 180, 25);
		if(op == 2) {
			salvarEmprestimo.setBounds(120, 175, 155, 30);
		}
		
		this.janela.add(labelEmprestimo);
		this.janela.add(valorEmprestimo);
		this.janela.add(labelEmprestimoLivro);
		this.janela.add(valorEmprestimoLivro);
		this.janela.add(salvarEmprestimo);
		
		this.janela.setLayout(null);
		
		this.janela.setSize(400, 250);
		this.janela.setVisible(true);
		
		salvarEmprestimo.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == salvarEmprestimo) {
			try {
				boolean res;
				String pesq;
				
				
			//	novoEmprestimo[1] = valorEmprestimo.getText();
				//novoEmprestimo[2] = valorEmprestimoLivro.getText();
				
				if(opcao == 2) {
				pesq = novoEmprestimo[2];
				System.out.println(pesq);
				if(dados.pesquisa(pesq) >= 0) {
					
						res = dados.removeLivro(posicao);
						System.out.println(posicao);
				}
				}
				if(res = true) {
					mensagemSucessoEmprestimo();
				} else {
					mensagemErroExclusaoEmprestimo();
				}
					
				
			} catch (NullPointerException exc1) {
				mensagemErroExclusaoEmprestimo();
			} catch (NumberFormatException exc2) {
				mensagemErroExclusaoEmprestimo();
			}

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
}
