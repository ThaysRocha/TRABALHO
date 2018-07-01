package br.com.trabalho.view;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.NotaBean;
import br.com.trabalho.dao.NotaDao;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class AlteracaoNotaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtIdNota;
	private JTextField campo1;
	private JTextField campo2;
	private JTextField campo3;
	private JTextField campo4;
	private JTable table;

	
	public AlteracaoNotaView(int idNota) {
		
		//Objeto
		NotaDao nd = new NotaDao();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 464, 344);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAlteracaoNota = new JButton("Alterar Nota");
		btnAlteracaoNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Instanciar objeto da classe NotaBean
				NotaBean nb = new NotaBean();
				nb.setNota(idNota);			
				nb.setNota(txtIdNota.getText());
				
				//Mensagem
				JOptionPane.showMessageDialog(null, "Nota alterado com sucesso!");
				
				//Chamar método para atualizar a tabela
				JButton btnAlterarNota = new JButton("Alterar Nota");
				btnAlterarNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
				btnAlterarNota.setBounds(10, 167, 135, 33);
				contentPane.add(btnAlterarNota);
				nd.alterarNota(nb);
				
				//Fechar JFrame
				dispose();
				
				//Abrir novo JFrame
				NotaView nv = new NotaView();
				nv.setVisible(true);
				
			}
		});


		
		JLabel lblNota_1 = new JLabel("Nota 1");
		lblNota_1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota_1.setBounds(32, 30, 68, 22);
		contentPane.add(lblNota_1);
		
		txtIdNota = new JTextField();
		txtIdNota.setEditable(false);
		txtIdNota.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtIdNota.setColumns(10);
		txtIdNota.setBounds(181, 43, 204, 33);
		contentPane.add(txtIdNota);
		
		JButton btnExcluirNota = new JButton("Excluir Nota");
		btnExcluirNota.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				//Verifica se realmente quer excluir
				int verifica = JOptionPane.showConfirmDialog(null, "Deseja realmente excluir?", "", 0);
				
				//Condicional
				if(verifica == 0){
					JOptionPane.showMessageDialog(null, "Excluído com sucesso!");
					
					//Executar a ação de exclusão
					new NotaDao().excluirNota(idNota);
					
				}else{
					JOptionPane.showMessageDialog(null, "Ação cancelada.");
				}
				
				//Fecha o formulário e instancia a NotaView
				dispose();
				NotaView asv = new NotaView();
				asv.setVisible(true);
				
			}
		});
		btnExcluirNota.setFont(new Font("Arial", Font.PLAIN, 14));
		btnExcluirNota.setBounds(32, 107, 105, 32);
		contentPane.add(btnExcluirNota);
		
		JButton btnCancelar = new JButton("Cancelar");
		btnCancelar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				//Fechar formulário
				dispose();
				
				//Abrir o formulário de cursos
				NotaView sv = new NotaView();
				sv.setVisible(true);
			}
		});
		btnCancelar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCancelar.setBounds(177, 107, 98, 32);
		contentPane.add(btnCancelar);
		
		JLabel lblNota_2 = new JLabel("Nota 2 ");
		lblNota_2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota_2.setBounds(32, 63, 46, 14);
		contentPane.add(lblNota_2);
		
		campo1 = new JTextField();
		campo1.setBounds(110, 32, 86, 20);
		contentPane.add(campo1);
		campo1.setColumns(10);
		
		campo2 = new JTextField();
		campo2.setBounds(110, 61, 86, 20);
		contentPane.add(campo2);
		campo2.setColumns(10);
		
		JLabel lblNota_3 = new JLabel("Nota 3");
		lblNota_3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota_3.setBounds(255, 34, 46, 14);
		contentPane.add(lblNota_3);
		
		JLabel lblNota_4 = new JLabel("Nota 4");
		lblNota_4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota_4.setBounds(255, 63, 46, 14);
		contentPane.add(lblNota_4);
		
		campo3 = new JTextField();
		campo3.setBounds(336, 32, 86, 20);
		contentPane.add(campo3);
		campo3.setColumns(10);
		
		campo4 = new JTextField();
		campo4.setBounds(336, 61, 86, 20);
		contentPane.add(campo4);
		campo4.setColumns(10);
		
		JButton btnAlterar = new JButton("Alterar");
		btnAlterar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnAlterar.setBounds(333, 109, 86, 30);
		contentPane.add(btnAlterar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(32, 170, 375, 106);
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nota 1", "Nota 2", "Nota 3", "Nota4"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}
}
