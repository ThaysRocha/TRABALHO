package br.com.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;

public class NotaView extends JFrame {

	private JPanel contentPane;
	private JTextField campo1;
	private JTextField campo2;
	private JTextField campo3;
	private JTextField campo4;
	private JTable table;

	public NotaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 341, 348);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNota1 = new JLabel("1\u00AA Nota");
		lblNota1.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota1.setBounds(10, 11, 54, 14);
		contentPane.add(lblNota1);
		
		JLabel lblNota2 = new JLabel("2\u00AA Nota");
		lblNota2.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota2.setBounds(10, 47, 46, 14);
		contentPane.add(lblNota2);
		
		JLabel lblNota3 = new JLabel("3\u00AA Nota");
		lblNota3.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota3.setBounds(10, 83, 46, 14);
		contentPane.add(lblNota3);
		
		JLabel lblNota4 = new JLabel("4\u00AA Nota");
		lblNota4.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNota4.setBounds(10, 108, 46, 14);
		contentPane.add(lblNota4);
		
		campo1 = new JTextField();
		campo1.setBounds(72, 9, 86, 20);
		contentPane.add(campo1);
		campo1.setColumns(10);
		
		campo2 = new JTextField();
		campo2.setBounds(72, 45, 86, 20);
		contentPane.add(campo2);
		campo2.setColumns(10);
		
		campo3 = new JTextField();
		campo3.setBounds(72, 76, 86, 20);
		contentPane.add(campo3);
		campo3.setColumns(10);
		
		campo4 = new JTextField();
		campo4.setBounds(72, 106, 86, 20);
		contentPane.add(campo4);
		campo4.setColumns(10);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setFont(new Font("Arial", Font.PLAIN, 14));
		btnCadastrar.setBounds(199, 61, 102, 23);
		contentPane.add(btnCadastrar);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(34, 147, 267, 151);
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
				{null, null, null, null},
				{null, null, null, null},
			},
			new String[] {
				"Nota 1", "Nota 2", "Nota 3", "Nota 4"
			}
		));
		table.setFont(new Font("Arial", Font.PLAIN, 14));
		scrollPane.setViewportView(table);
	}
}
