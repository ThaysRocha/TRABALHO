package br.com.trabalho.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.SalaBean;
import br.com.trabalho.dao.SalaDao;

import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SalaView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeSala;
	private JTable tblListarSala;
	private JScrollPane scrollPane;


	public SalaView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeSala = new JLabel("Nome da sala");
		lblNomeSala.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeSala.setBounds(29, 32, 124, 27);
		contentPane.add(lblNomeSala);
		
		txtNomeSala = new JTextField();
		txtNomeSala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNomeSala.setBounds(184, 30, 182, 33);
		contentPane.add(txtNomeSala);
		txtNomeSala.setColumns(10);
		
		JButton btnCadastrarSala = new JButton("Cadastrar Sala");
		btnCadastrarSala.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Obter dados informados
				SalaBean sb = new SalaBean();
				sb.setNomeSala(txtNomeSala.getText());
				
				
				//Executar envio dos dados
				SalaDao cd = new SalaDao();
				sb.cadastrarSala(sb);
				
				//Limpar campos
				txtNomeSala.setText("");
				
				
				//Cursor no campo nome curso
				txtNomeSala.requestFocus();
				
			}
		});
		btnCadastrarSala.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarSala.setBounds(103, 95, 158, 33);
		contentPane.add(btnCadastrarSala);
		
		//Objecto da classe CursosDao
		SalaDao sd = new SalaDao();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 356, 140);
		contentPane.add(scrollPane);
		
		tblListarSala = new JTable();
		tblListarSala.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Obter a linha selecionada
				int linhaSelecionada = tblListarSala.getSelectedRow();
				int idSala = (int) tblListarSala.getValueAt(linhaSelecionada, 0);
				
				//Fechar esse formulário
				dispose();
				
				//Instanciar outro formulário
				AlterarSalaView asv = new AlterarSalaView(idSala);
				asv.setVisible(true);
			}
		});

		scrollPane.setViewportView(tblListarSala);
		tblListarSala.setModel(sd.listarSalas());
	}
}

