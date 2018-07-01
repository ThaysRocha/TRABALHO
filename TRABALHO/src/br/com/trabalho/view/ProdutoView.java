package br.com.trabalho.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.ProdutoBean;
import br.com.trabalho.dao.ProdutoDao;

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

public class ProdutoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtproduto;
	private JTable tblListarProduto;
	private JScrollPane scrollPane;
	private JTextField textField;


	public ProdutoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 389);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblproduto = new JLabel("produto");
		lblproduto.setBounds(37, 37, 56, 14);
		lblproduto.setFont(new Font("Arial", Font.PLAIN, 14));
		contentPane.add(lblproduto);
		
		txtproduto = new JTextField();
		txtproduto.setBounds(103, 30, 236, 21);
		txtproduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(txtproduto);
		txtproduto.setColumns(10);
		
		JButton btncadastrarProduto = new JButton("Cadastrar");
		btncadastrarProduto.setBounds(110, 144, 111, 33);
		btncadastrarProduto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Obter dados informados
				ProdutoBean pb = new ProdutoBean();
				pb.setproduto(txtproduto.getText());
				
				
				//Executar envio dos dados
				ProdutoDao pd = new ProdutoDao();
				pb.cadastrarProduto(pb);
				
				//Limpar campos
				txtproduto.setText("");
				
				
				//Cursor no campo 
				txtproduto.requestFocus();
				
			}
		});
		btncadastrarProduto.setFont(new Font("Tahoma", Font.PLAIN, 16));
		contentPane.add(btncadastrarProduto);
		
		//Objecto da classe ProdutoDao
		ProdutoDao pd = new ProdutoDao();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(29, 199, 356, 140);
		contentPane.add(scrollPane);
		
		tblListarProduto = new JTable();
		tblListarProduto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Obter a linha selecionada
				int linhaSelecionada = tblListarProduto.getSelectedRow();
				int idProduto = (int) tblListarProduto.getValueAt(linhaSelecionada, 0);
				
				//Fechar esse formulário
				dispose();
				
				//Instanciar outro formulário
				AlterarProdutoView apv = new AlterarProdutoView(idProduto);
				apv.setVisible(true);
			}
		});

		scrollPane.setViewportView(tblListarProduto);
		tblListarProduto.setModel(pd.listarProdutos());
		
		JLabel lblquantidade = new JLabel("quantidade");
		lblquantidade.setFont(new Font("Arial", Font.PLAIN, 14));
		lblquantidade.setBounds(37, 64, 56, 14);
		contentPane.add(lblquantidade);
		
		textField = new JTextField();
		textField.setBounds(103, 62, 122, 20);
		contentPane.add(textField);
		textField.setColumns(10);
	}
}

