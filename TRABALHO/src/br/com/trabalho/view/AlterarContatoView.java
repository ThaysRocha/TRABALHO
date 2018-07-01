package br.com.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.ContatoBean;
import br.com.trabalho.dao.ContatoDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarContatoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtidContato;
	private JTextField textField;

	
	public AlterarContatoView(int idContato) {
		
		//Objeto
		ContatoDao ctd = new ContatoDao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefone.setBounds(32, 45, 63, 27);
		contentPane.add(lblTelefone);
		
		txtidContato = new JTextField();
		txtidContato.setEditable(false);
		txtidContato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtidContato.setColumns(10);
		txtidContato.setBounds(107, 50, 118, 14);
		contentPane.add(txtidContato);
		
		JButton btnExcluircontato = new JButton("Excluir ");
		btnExcluircontato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Verifica se realmente quer excluir
				int verifica = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "", 0);
				
				//Condicional
				if(verifica == 0){
					JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
					
					//Executar a ação de exclusão
					new ContatoDao().excluirContato(idContato);
					
				}else{
					JOptionPane.showMessageDialog(null, "Ação cancelada.");
				}
				
				//Fecha o formulário e instancia o Cursoctview
				dispose();
				ContatoView actv = new ContatoView();
				actv.setVisible(true);

			}
		});
		btnExcluircontato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluircontato.setBounds(73, 167, 94, 33);
		contentPane.add(btnExcluircontato);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Fechar formulário
				dispose();
				
				//Abrir o formulário de cursos
				ContatoView ctv = new ContatoView();
				ctv.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(177, 167, 111, 33);
		contentPane.add(btnCancelar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(326, 167, 89, 30);
		contentPane.add(btnAlterar);
		
		JLabel lblGmail = new JLabel("Gmail");
		lblGmail.setFont(new Font("Arial", Font.PLAIN, 14));
		lblGmail.setBounds(32, 83, 46, 14);
		contentPane.add(lblGmail);
		
		textField = new JTextField();
		textField.setBounds(105, 81, 217, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

