package br.com.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.trabalho.bean.SalaBean;
import br.com.trabalho.connection.AlunosConnection;

public class SalaDao {

	// Atributo para obter a conex�o
	private Connection conexao;

	// Construtor
	public SalaDao() {
		
		this.conexao = new AlunosConnection().obterConexao();
	}

	// M�todo para cadastrar uma sala
	public void cadastrarSala(SalaBean sb) {

		// Comando SQL
		String sql = "INSERT INTO sala (nomeSala) VALUES (?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, sb.getNomeSala());
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// M�todo para selecionar sala
	public DefaultTableModel listarSalas() {

		// Criando o DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Definir as colunas do DefaultTableModel
		modelo.addColumn("C�digo");
		modelo.addColumn("Sala");
		

		// Comando SQL
		String sql = "SELECT * FROM sala";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando sala
			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt("idSala"), rs.getString("nomeSala")});

			}

			// Fechar a conex�o
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na sele��o
			JOptionPane.showMessageDialog(null, "Falha ao selecionar as Salas.");

		}

		// Retornar o DefaultTableModel
		return modelo;

	}

	// M�todo para excluir uma sala
	public void excluirSala(int idSala) {

		// Comando SQL
		String sql = "DELETE FROM sala WHERE idSala = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idSala);
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// M�todo para obter o nome e o valor do curso
	public SalaBean obterNomeSala(int idSala) {

		// Criando um objeto da classe SalaBean
		SalaBean sb = new SalaBean();

		// Comando SQL
		String sql = "SELECT * FROM sala WHERE idSala = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idSala);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				sb.setNomeSala(rs.getString("nomeSala"));
			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return sb;

	}

	// M�todo para alterar o sala
	public void alterarSala (SalaBean sb) {


		// Comando SQL
		String sql = "UPDATE sala SET nomeSala = ? WHERE idSala = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros			
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, sb.getNomeSala());
			pstmt.setInt(3, sb.getIdSala());

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



