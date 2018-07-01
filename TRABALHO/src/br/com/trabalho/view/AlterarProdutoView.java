package br.com.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.ProdutoBean;
import br.com.trabalho.dao.ProdutoDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class AlterarProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtidProduto;
	private JTextField textField;

	
	public AlterarProdutoView(int idProduto) {
		
		//Objeto
		ProdutoDao pd = new ProdutoDao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 514, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		

		
		JLabel lblQuantidade = new JLabel("Quantidade");
		lblQuantidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblQuantidade.setBounds(32, 45, 89, 27);
		contentPane.add(lblQuantidade);
		
		txtidProduto = new JTextField();
		txtidProduto.setEditable(false);
		txtidProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtidProduto.setColumns(10);
		txtidProduto.setBounds(124, 50, 118, 14);
		contentPane.add(txtidProduto);
		
		JButton btnExcluirProduto = new JButton("Excluir ");
		btnExcluirProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Verifica se realmente quer excluir
				int verifica = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "", 0);
				
				//Condicional
				if(verifica == 0){
					JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
					
					//Executar a ação de exclusão
					new ProdutoDao().excluirProduto(idProduto);
					
				}else{
					JOptionPane.showMessageDialog(null, "Ação cancelada.");
				}
				
				//Fecha o formulário e instancia o Cursopview
				dispose();
				ProdutoView apv = new ProdutoView();
				apv.setVisible(true);

			}
		});
		btnExcluirProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnExcluirProduto.setBounds(73, 167, 94, 33);
		contentPane.add(btnExcluirProduto);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Fechar formulário
				dispose();
				
				//Abrir o formulário de cursos
				ProdutoView pv = new ProdutoView();
				pv.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCancelar.setBounds(177, 167, 111, 33);
		contentPane.add(btnCancelar);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(311, 167, 89, 32);
		contentPane.add(btnAlterar);
		
		JLabel lblProduto = new JLabel("Produto");
		lblProduto.setFont(new Font("Arial", Font.PLAIN, 14));
		lblProduto.setBounds(32, 83, 63, 14);
		contentPane.add(lblProduto);
		
		textField = new JTextField();
		textField.setBounds(107, 81, 217, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

