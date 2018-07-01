package br.com.trabalho.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import br.com.trabalho.bean.CargoBean;
import br.com.trabalho.dao.CargoDao;

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

public class CargoView extends JFrame {

	private JPanel contentPane;
	private JTextField txtNomeCargo;
	private JTable tblListarCargo;
	private JScrollPane scrollPane;


	public CargoView() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 394, 329);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNomeCargo = new JLabel("Nome do cargo");
		lblNomeCargo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNomeCargo.setBounds(29, 32, 124, 27);
		contentPane.add(lblNomeCargo);
		
		txtNomeCargo = new JTextField();
		txtNomeCargo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		txtNomeCargo.setBounds(184, 30, 182, 33);
		contentPane.add(txtNomeCargo);
		txtNomeCargo.setColumns(10);
		
		JButton btnCadastrarCargo = new JButton("Cadastrar Cargo");
		btnCadastrarCargo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
				//Obter dados informados
				CargoBean cb = new CargoBean();
				cb.setNomeCargo(txtNomeCargo.getText());
				
				
				//Executar envio dos dados
				CargoDao cd = new CargoDao();
				cb.cadastrarCargo(cb);
				
				//Limpar campos
				txtNomeCargo.setText("");
				
				
				//Cursor no campo nome cargo
				txtNomeCargo.requestFocus();
				
			}
		});
		btnCadastrarCargo.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnCadastrarCargo.setBounds(103, 95, 158, 33);
		contentPane.add(btnCadastrarCargo);
		
		//Objecto da classe CargoDao
		CargoDao cd = new CargoDao();
		
		scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 139, 356, 140);
		contentPane.add(scrollPane);
		
		tblListarCargo = new JTable();
		tblListarCargo.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				//Obter a linha selecionada
				int linhaSelecionada = tblListarCargo.getSelectedRow();
				int idCargo = (int) tblListarCargo.getValueAt(linhaSelecionada, 0);
				
				//Fechar esse formulário
				dispose();
				
				//Instanciar outro formulário
				AlterarCargoView asv = new AlterarCargoView(idCargo);
				asv.setVisible(true);
			}
		});

		scrollPane.setViewportView(tblListarCargo);
		tblListarCargo.setModel(cd.listarCargos());
	}
}



