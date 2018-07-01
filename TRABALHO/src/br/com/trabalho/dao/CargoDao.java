package br.com.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.trabalho.bean.CargoBean;
import br.com.trabalho.connection.AlunosConnection;

public class CargoDao {

	// Atributo para obter a conex�o
	private Connection conexao;

	// Construtor
	public CargoDao() {
		
		this.conexao = new AlunosConnection().obterConexao();
	}

	// M�todo para cadastrar um cargo
	public void cadastrarCurso(CargoBean cb) {

		// Comando SQL
		String sql = "INSERT INTO cargo (nomeCargo) VALUES (?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, cb.getNomeCargo());
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// M�todo para selecionar sala
	public DefaultTableModel listarCargos() {

		// Criando o DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Definir as colunas do DefaultTableModel
		modelo.addColumn("C�digo");
		modelo.addColumn("Cargo");
		

		// Comando SQL
		String sql = "SELECT * FROM cargo";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cargos
			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt("idCargo"), rs.getString("nomeCargo")});

			}

			// Fechar a conex�o
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na sele��o
			JOptionPane.showMessageDialog(null, "Falha ao selecionar as Cargo.");

		}

		// Retornar o DefaultTableModel
		return modelo;

	}

	// M�todo para excluir uma cargo
	public void excluirCargo(int idCargo) {

		// Comando SQL
		String sql = "DELETE FROM sala WHERE idCargo = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idCargo);
			pstmt.execute();

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// M�todo para obter o nome do cargo
	public CargoBean obterNomeCargo(int idCargo) {

		// Criando um objeto da classe CargoBean
		CargoBean cb = new CargoBean();

		// Comando SQL
		String sql = "SELECT * FROM cargo WHERE idCargo = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idCargo);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				cb.setNomeCargo(rs.getString("nomeCargo"));
			}

			// Fechar a conex�o
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return cb;

	}

	// M�todo para alterar o cargo
	public void alterarCargo (CargoBean cb) {


		// Comando SQL
		String sql = "UPDATE cursos SET nomeCargo = ? WHERE idCargo = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os par�metros			
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1,cb.getNomeCargo());
			pstmt.setInt(3, cb.getIdCargo());

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
