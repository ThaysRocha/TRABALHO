package br.com.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JButton;
import javax.swing.JMenuItem;

public class TelaPrincipalView extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPrincipalView frame = new TelaPrincipalView();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaPrincipalView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnMaterias = new JMenu("Materias");
		menuBar.add(mnMaterias);
		
		JMenuItem mntmNotas = new JMenuItem("Notas");
		mnMaterias.add(mntmNotas);
		
		JMenuItem mntmSala = new JMenuItem("Sala");
		mnMaterias.add(mntmSala);
		
		JMenuItem mntmMateria = new JMenuItem("Materia");
		mnMaterias.add(mntmMateria);
		
		JMenu mnFuncionarios = new JMenu("Funcionarios");
		menuBar.add(mnFuncionarios);
		
		JMenuItem mntmProfessores = new JMenuItem("Professores");
		mnFuncionarios.add(mntmProfessores);
		
		JMenuItem mntmFuncionarios = new JMenuItem("Funcionarios");
		mnFuncionarios.add(mntmFuncionarios);
		
		JMenuItem mntmAlunos = new JMenuItem("Alunos");
		mnFuncionarios.add(mntmAlunos);
		
		JMenu mnContatos = new JMenu("Contatos");
		menuBar.add(mnContatos);
		
		JMenuItem mntmColaboradores = new JMenuItem("Colaboradores");
		mnContatos.add(mntmColaboradores);
		
		JMenuItem mntmContatos = new JMenuItem("Contatos");
		mnContatos.add(mntmContatos);
		
		JMenuItem mntmProdutos = new JMenuItem("Produtos");
		mnContatos.add(mntmProdutos);
		
		JMenuItem mntmCargos = new JMenuItem("Cargos");
		mnContatos.add(mntmCargos);
		
		JButton btnSair = new JButton("Sair");
		menuBar.add(btnSair);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
	}

}
