package br.com.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.SalaBean;
import br.com.trabalho.dao.SalaDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarSalaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdSala;

	
	public AlterarSalaView(int idSala) {
		
		//Objeto
		SalaDao sd = new SalaDao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlterarSala = new JButton("Alterar Sala");
		btnAlterarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instanciar objeto da classe SalaBean
				SalaBean sb = new SalaBean();
				sb.setNomeSala(idSala);			
				sb.setNomeSala(txtIdSala.getText());
				
				//Mensagem
				JOptionPane.showMessageDialog(null, "Sala alterado com sucesso!");
				
				//Chamar método para atualizar a tabela
				sd.alterarSala(sb);
				
				//Fechar JFrame
				dispose();
				
				//Abrir novo JFrame
				SalaView sv = new SalaView();
				sv.setVisible(true);
				
			}
		});
		JButton btnAlterarSala = new JButton("Alterar Sala");
		btnAlterarSala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAlterarSala.setBounds(10, 167, 135, 33);
		contentPane.add(btnAlterarSala);
		

		
		JLabel lblNomeSala = new JLabel("Nome da Sala");
		lblNomeSala.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeSala.setBounds(32, 45, 124, 27);
		contentPane.add(lblNomeSala);
		
		txtIdSala = new JTextField();
		txtIdSala.setEditable(false);
		txtIdSala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIdSala.setColumns(10);
		txtIdSala.setBounds(181, 43, 204, 33);
		contentPane.add(txtIdSala);
		
		JButton btnExcluirSala = new JButton("Excluir Sala");
		btnExcluirSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Verifica se realmente quer excluir
				int verifica = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "", 0);
				
				//Condicional
				if(verifica == 0){
					JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
					
					//Executar a ação de exclusão
					new SalaDao().excluirSala(idSala);
					
				}else{
					JOptionPane.showMessageDialog(null, "Ação cancelada.");
				}
				
				//Fecha o formulário e instancia o SalaView
				dispose();
				SalaView asv = new SalaView();
				asv.setVisible(true);
				
			}
		});
		btnExcluirSala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluirSala.setBounds(155, 167, 135, 33);
		contentPane.add(btnExcluirSala);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Fechar formulário
				dispose();
				
				//Abrir o formulário de cursos
				SalaView sv = new SalaView();
				sv.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(310, 167, 135, 33);
		contentPane.add(btnCancelar);
	}
}
