package br.com.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaPrincipalView extends JFrame {


	public TelaPrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 374, 305);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnSistema = new JMenu("Funcionarios");
		mnSistema.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnSistema);
		
		JMenuItem mntmProfessor = new JMenuItem("Professor");
		mntmProfessor.setFont(new Font("Arial", Font.PLAIN, 14));
		mnSistema.add(mntmProfessor);
		
		JMenuItem mntmFuncionarios = new JMenuItem("Funcionarios");
		mntmFuncionarios.setFont(new Font("Arial", Font.PLAIN, 14));
		mnSistema.add(mntmFuncionarios);
		
		JMenu mnSistema_1 = new JMenu("Sistema");
		mnSistema_1.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnSistema_1);
		
		JMenuItem mntmColaboradores = new JMenuItem("Colaboradores");
		mntmColaboradores.setFont(new Font("Arial", Font.PLAIN, 14));
		mnSistema_1.add(mntmColaboradores);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mntmProdutos.setFont(new Font("Arial", Font.PLAIN, 14));
		mnSistema_1.add(mntmProdutos);
		
		JMenuItem mntmContatos = new JMenuItem("Contatos");
		mntmContatos.setFont(new Font("Arial", Font.PLAIN, 14));
		mnSistema_1.add(mntmContatos);
		
		JMenu mnEnsino = new JMenu("Ensino");
		mnEnsino.setFont(new Font("Arial", Font.PLAIN, 14));
		menuBar.add(mnEnsino);
		
		JMenuItem mntmSala = new JMenuItem("Sala");
		mntmSala.setFont(new Font("Arial", Font.PLAIN, 14));
		mnEnsino.add(mntmSala);
		
		JMenuItem mntmAlunos = new JMenuItem("Alunos");
		mntmAlunos.setFont(new Font("Arial", Font.PLAIN, 14));
		mnEnsino.add(mntmAlunos);
		
		JMenuItem mntmNota = new JMenuItem("Nota");
		mntmNota.setFont(new Font("Arial", Font.PLAIN, 14));
		mnEnsino.add(mntmNota);
		
		JMenuItem mntmMatria = new JMenuItem("Mat\u00E9ria");
		mntmMatria.setFont(new Font("Arial", Font.PLAIN, 14));
		mnEnsino.add(mntmMatria);
		
		JButton btnSair = new JButton("SAIR");
		btnSair.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		menuBar.add(btnSair);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
		getContentPane().setLayout(null);
	}
}
