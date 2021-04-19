package view;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import controle.*;

public class TelaUsuario implements ActionListener, ListSelectionListener {
	private JFrame janela;
	private JLabel titulo;
	private JButton cadastroUsuarios;
	private JButton refreshUsuarios;
	private static ControleDados dados;
	private JList<String> listaUsuariosCadastrados;
	private String[] listaUsuarios = new String[50];
	
	public void mostraUsuarios(ControleDados d, int op) {
		dados = d;
		
		switch(op) {
		case 5:
			// lista os usuarios
			listaUsuarios = new ControleUsuario(dados).getNomeUsuario();
			listaUsuariosCadastrados = new JList<String>(listaUsuarios);
			
			// nome dos jframe, jlabel, jabuttons
			janela = new JFrame("Usuarios");
			titulo = new JLabel("Usuarios Cadastrados");
			cadastroUsuarios = new JButton("Cadastrar");
			refreshUsuarios = new JButton("Refresh");
			
			//tamanho das janelas do titulo e lista
			titulo.setFont(new Font ("Arial", Font.BOLD, 20));
			titulo.setBounds(90, 20, 250, 30);
			listaUsuariosCadastrados .setBounds(20, 50, 350, 120);
			listaUsuariosCadastrados.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
			listaUsuariosCadastrados.setVisibleRowCount(10);
			
			// tamanho dos botoes
			cadastroUsuarios.setBounds(70, 177, 100, 30);
			refreshUsuarios.setBounds(200, 177, 100, 30);
			
			janela.setLayout(null);
			
			// adicona as jaenlas dos jframe, jlist, jbuttons.
			janela.add(titulo);
			janela.add(listaUsuariosCadastrados);
			janela.add(cadastroUsuarios);
			janela.add(refreshUsuarios);
			
			janela.setSize(400, 250);
			janela.setVisible(true);
			
			cadastroUsuarios.addActionListener(this);
			refreshUsuarios.addActionListener(this);
			listaUsuariosCadastrados.addListSelectionListener(this);
			
			break;
		default:
			JOptionPane.showMessageDialog(null,"Opção não encontrada!", null, 
					JOptionPane.ERROR_MESSAGE);
		}
		
	}
	public void actionPerformed(ActionEvent e) {
		Object src = e.getSource();
		
		if(src == cadastroUsuarios) { // Cadastra e edita Usuario
			new TelaDetalheUsuario().inserirEditar(1, dados, this, 0);
		}
		if(src == refreshUsuarios) { // Atualiza a lista
			listaUsuariosCadastrados.setListData(new ControleUsuario(dados).getNomeUsuario());
			listaUsuariosCadastrados.updateUI();
		}
			
	}
	public void valueChanged(ListSelectionEvent e) {
		Object src = e.getSource();
		
		if(e.getValueIsAdjusting() && src == listaUsuariosCadastrados) { // mantem a list aatualizada
			new TelaDetalheUsuario().inserirEditar(2, dados, this,
					listaUsuariosCadastrados.getSelectedIndex());
		}
	}
}
