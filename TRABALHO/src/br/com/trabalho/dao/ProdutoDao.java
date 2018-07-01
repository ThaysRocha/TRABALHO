
package br.com.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.trabalho.bean.ProdutoBean;
import br.com.trabalho.connection.AlunosConnection;

public class ProdutoDao {

	// Atributo para obter a conexão
	private Connection conexao;

	// Construtor
	public ProdutoDao() {
		
		this.conexao = new AlunosConnection().obterConexao();
	}

	// Método para cadastrar um Produto
	public void cadastrarProduto(ProdutoBean pb) {

		// Comando SQL
		String sql = "INSERT INTO Produto (quantidade, produto) VALUES (?, ?)";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setString(1, pb.getproduto());
			pstmt.setInt(1, pb.getquantidade());
			pstmt.execute();

			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// Método para selecionar Produto
	public DefaultTableModel listarProdutos() {

		// Criando o DefaultTableModel
		DefaultTableModel modelo = new DefaultTableModel();

		// Definir as colunas do DefaultTableModel
		modelo.addColumn("Código");
		modelo.addColumn("quantidade");
		modelo.addColumn("produto");
		

		// Comando SQL
		String sql = "SELECT * FROM Produto";

		// Tentar realizar o comando SQL
		try {

			// Conectar e selecionar o comando SQL
			Statement stmt = conexao.createStatement();

			// Executando comando SQL e obtendo dados
			ResultSet rs = stmt.executeQuery(sql);

			// Listando Produto
			while (rs.next()) {

				modelo.addRow(
						new Object[] { rs.getInt("idProduto"), rs.getInt("quantidade"), rs.getString("produto")});

			}

			// Fechar a conexão
			stmt.close();

		} catch (Exception e) {

			// Caso haja falhas na seleção
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os Produtos.");

		}

		// Retornar o DefaultTableModel
		return modelo;

	}

	// Método para excluir um Produto
	public void excluirProduto(int idProduto) {

		// Comando SQL
		String sql = "DELETE FROM Produto WHERE idProduto = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros e executando
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idProduto);
			pstmt.execute();

			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");

		}

	}

	// Método para obter o quantidade e o produto do Produto
	public ProdutoBean obterquantidade(int idProduto) {

		// Criando um objeto da classe ProdutoBean
		ProdutoBean pb = new ProdutoBean();

		// Comando SQL
		String sql = "SELECT * FROM Produto WHERE idProduto = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, idProduto);

			// Executando e retornando dados
			ResultSet rs = pstmt.executeQuery();

			while (rs.next()) {
				pb.quantidadeset(rs.getInt("quantidade"));
				pb.produtoset(rs.getString("produto"));
			}

			// Fechar a conexão
			pstmt.close();

		} catch (Exception e) {

			// Caso haja falhas
			JOptionPane.showMessageDialog(null, "Falha ao selecionar os dados" + e.getMessage());

		}

		// Retorno
		return pb;

	}

	// Método para alterar o Produto
	public void alterarProduto (ProdutoBean pb) {


		// Comando SQL
		String sql = "UPDATE Produto SET produto, quantidade = ? WHERE idProduto = ?";

		// Tentar realizar o comando SQL
		try {

			// Enviando os parâmetros			
			PreparedStatement pstmt = this.conexao.prepareStatement(sql);
			pstmt.setInt(1, pb.getidProduto());
			pstmt.setInt(2, pb.getQuatidade());
			pstmt.setString(3, pb.getProduto());

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

