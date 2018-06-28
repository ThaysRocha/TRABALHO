package br.com.trabalho.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.SalaBean;
import br.com.trabalho.dao.SalaDao;
import javax.swing.table.DefaultTableModel;

public class telaSalaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNumeroSala;
	private JTable tblListarSala;
	private JScrollPane scrollPane;


	public telaSalaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 445);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNumeroSala = new JLabel("N\u00FAmero da Sala");
		lblNumeroSala.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNumeroSala.setBounds(22, 44, 146, 27);
		contentPane.add(lblNumeroSala);
		
		txtNumeroSala = new JTextField();
		txtNumeroSala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNumeroSala.setBounds(178, 44, 182, 33);
		contentPane.add(txtNumeroSala);
		txtNumeroSala.setColumns(10);
		
		JButton btnCadastrarSala = new JButton("Cadastrar Sala");
		btnCadastrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Obter dados informados
				SalaBean sb = new SalaBean();
				sb.setNumeroSala(txtNumeroSala.getText());
				
				//Executar envio dos dados
				SalaDao sd = new SalaDao();
				sd.cadastrarSala(sb);
				
				//Limpar campos
				txtNumeroSala.setText("");
				
				//Cursor no campo nome curso
				txtNumeroSala.requestFocus();
				
			}
		});
		btnCadastrarSala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarSala.setBounds(121, 142, 158, 33);
		contentPane.add(btnCadastrarSala);
		
		//Objecto da classe CursosDao
		SalaDao sd = new SalaDao();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(53, 201, 307, 144);
		contentPane.add(scrollPane);
		
		tblListarSala = new JTable();
		scrollPane.setViewportView(tblListarSala);
		tblListarSala.setModel(new DefaultTableModel(
			new Object[][] {
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
				{null, null},
			},
			new String[] {
				"idSala", "N\u00FAmero da Sala"
			}
		));
	}

}
