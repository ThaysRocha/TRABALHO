package br.com.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.trabalho.bean.NotaBean;
import br.com.trabalho.connection.AlunosConnection;

public class NotaDao {

	// Atributo para obter a conexão
	private Connection conexao;

	// Construtor
	public NotaDao() {

		this.conexao = new AlunosConnection().obterConexao();
	}

	// Método para cadastrar uma nota
	public void cadastrarNota(NotaBean nb) {

		// Comando SQL
		String sql = "INSERT INTO nota (nota1, nota2, nota3, nota4) VALUES (?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setDouble(1, nb.getNota1());
			pstmt.setDouble(2, nb.getNota2());
			pstmt.setDouble(1, nb.getNota3());
			pstmt.setDouble(2, nb.getNota4());
			pstmt.execute();

			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// Método para selecionar nota
	public DefaultTableModel listarNotas() {

		// Criando o DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Definir as colunas do DefaultTableModel
		modelo.addColumn("Código");
		modelo.addColumn("Nota1");
		modelo.addColumn("Nota2");
		modelo.addColumn("nota3");
		modelo.addColumn("nota4");

		// Comando SQL
		String sql = "SELECT * FROM nota";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando cursos
			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt("idNota"), rs.getDouble("nota1"), rs.getDouble("nota2"), rs.getDouble("nota3"), rs.getDouble("nota4") });

			}

			// Fechar a conexão
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na seleção
			JOptionPane.showMessageDialog(null, "Falha ao selecionar as notas.");

		}

		// Retornar o DefaultTableModel
		return modelo;

	}

	// Método para excluir um curso
	public void excluirNota(int idNota) {

		// Comando SQL
		String sql = "DELETE FROM cursos WHERE idNota = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idNota);
			pstmt.execute();

			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// Método para obter o nome e o valor da nota
	public NotaBean obterNota(int idNota) {

		// Criando um objeto da classe NotaBean
		NotaBean nb = new NotaBean();

		// Comando SQL
		String sql = "SELECT * FROM nota WHERE idNota = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idNota);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				nb.setNota1(rs.getDouble("Nota1"));
				nb.setNota2(rs.getDouble("Nota2"));
				nb.setNota3(rs.getDouble("Nota3"));
				nb.setNota4(rs.getDouble("Nota4"));
			}

			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return nb;

	}

	// Método para alterar o curso
	public void alterarNota(NotaBean nb) {


		// Comando SQL
		String sql = "UPDATE nota SET nota1 = ?, nota2 = ?, nota3 = ?, nota4 = ? WHERE idNota = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros			
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setDouble(1, nb.getNota1());
			pstmt.setDouble(2, nb.getNota2());
			pstmt.setDouble(2, nb.getNota3());
			pstmt.setDouble(4, nb.getNota4());
			pstmt.setInt(3, nb.getIdNota());

			// Executando ação
			pstmt.execute();
			
			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}


	}

}

