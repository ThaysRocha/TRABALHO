package br.com.trabalho.connection;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class AlunoConnection {

	
	//Atributos
		private final String url = "jdbc:mysql://localhost:3306/aluno";
		private final String user = "root";
		private final String password = "";
		
	//Método para obter conecção
	public Connection obterConexao() {
		
		//Variável contendo a conexão
				Connection conexao = null;
				
				//Tentar realizar a conexão
				try{
					conexao = DriverManager.getConnection(url, user, password);
				}catch(SQLException e){
					throw new RuntimeException(e);
				}
		
		return null;
	}


}
