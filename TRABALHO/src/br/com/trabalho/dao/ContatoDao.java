package br.com.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.trabalho.bean.ContatoBean;
import br.com.trabalho.connection.AlunosConnection;

public class ContatoDao {

	// Atributo para obter a conex�o
	private Connection conexao;

	// Construtor
	public ContatoDao() {
		
		this.conexao = new AlunosConnection().obterConexao();
	}

	// M�todo para cadastrar um Contato
	public void cadastrarContato(ContatoBean ctb) {

		// Comando SQL
		String sql = "INSERT INTO Contato (telefone, gmail) VALUES (?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, ctb.getGmail());
			pstmt.setInt(1, ctb.getTelefone());
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// M�todo para selecionar contato
	public DefaultTableModel listarContatos() {

		// Criando o DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Definir as colunas do DefaultTableModel
		modelo.addColumn("C�digo");
		modelo.addColumn("Telefone");
		modelo.addColumn("Gmail");
		

		// Comando SQL
		String sql = "SELECT * FROM contato";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando contato
			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt("idContato"), rs.getInt("telefone"), rs.getString("gmail")});

			}

			// Fechar a conex�o
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na sele��o
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os Contatos.");

		}

		// Retornar o DefaultTableModel
		return modelo;

	}

	// M�todo para excluir um Contato
	public void excluirContato(int idContato) {

		// Comando SQL
		String sql = "DELETE FROM contato WHERE idContato = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idContato);
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// M�todo para obter o telefone e o gmail do contato
	public ContatoBean obtertelefone(int idContato) {

		// Criando um objeto da classe ContatoBean
		ContatoBean ctb = new ContatoBean();

		// Comando SQL
		String sql = "SELECT * FROM contato WHERE idContato = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idContato);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				ctb.telefoneset(rs.getInt("telefone"));
				ctb.gmailset(rs.getString("gmail"));
			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return ctb;

	}

	// M�todo para alterar o contato
	public void alterarContato (ContatoBean ctb) {


		// Comando SQL
		String sql = "UPDATE contato SET telefone, gmail = ? WHERE idContato = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros			
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, ctb.getIdContato());
			pstmt.setInt(2, ctb.getTelefone());
			pstmt.setString(3, ctb.getGmail());

			// Executando a��o
			pstmt.execute();
			
			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}


	}




	

}