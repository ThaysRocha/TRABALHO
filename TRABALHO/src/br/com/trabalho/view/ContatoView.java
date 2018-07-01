package br.com.trabalho.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.ContatoBean;
import br.com.trabalho.dao.ContatoDao;

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

public class ContatoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtgmail;
	private JTable tblListarContato;
	private JScrollPane scrollPane;
	private JTextField textField;


	public ContatoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblgmail = new JLabel("Gmail");
		lblgmail.setBounds(37, 37, 56, 14);
		lblgmail.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblgmail);
		
		txtgmail = new JTextField();
		txtgmail.setBounds(103, 30, 236, 21);
		txtgmail.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtgmail);
		txtgmail.setColumns(10);
		
		JButton btncadastrarContato = new JButton("Cadastrar");
		btncadastrarContato.setBounds(110, 144, 111, 33);
		btncadastrarContato.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Obter dados informados
				ContatoBean ctb = new ContatoBean();
				ctb.setgmail(txtgmail.getText());
				
				
				//Executar envio dos dados
				ContatoDao ctd = new ContatoDao();
				ctb.cadastrarContato(ctb);
				
				//Limpar campos
				txtgmail.setText("");
				
				
				//Cursor no campo 
				txtgmail.requestFocus();
				
			}
		});
		btncadastrarContato.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btncadastrarContato);
		
		//Objecto da classe Cursoctdao
		ContatoDao ctd = new ContatoDao();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 199, 356, 140);
		contentPane.add(scrollPane);
		
		tblListarContato = new JTable();
		tblListarContato.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Obter a linha selecionada
				int linhaSelecionada = tblListarContato.getSelectedRow();
				int idContato = (int) tblListarContato.getValueAt(linhaSelecionada, 0);
				
				//Fechar esse formulário
				dispose();
				
				//Instanciar outro formulário
				AlterarContatoView actv = new AlterarContatoView(idContato);
				actv.setVisible(true);
			}
		});

		scrollPane.setViewportView(tblListarContato);
		tblListarContato.setModel(ctd.listarContatos());
		
		JLabel lblTelefone = new JLabel("Telefone");
		lblTelefone.setFont(new Font("Arial", Font.PLAIN, 14));
		lblTelefone.setBounds(37, 64, 56, 14);
		contentPane.add(lblTelefone);
		
		textField = new JTextField();
		textField.setBounds(103, 62, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}
