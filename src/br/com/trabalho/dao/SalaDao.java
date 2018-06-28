package br.com.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.trabalho.bean.SalaBean;
import br.com.trabalho.connection.AlunoConnection;

public class SalaDao {

	
	//Atributo para obter a conex�o
		private Connection conexao;
		
		//Construtor
		public SalaDao(){
			
			this.conexao = new AlunoConnection().obterConexao();
		}
		
		
		//M�todo para cadastrar um curso
		public void cadastrarSala(SalaBean s){
			
			//Comando SQL
			String sql = "INSERT INTO  (numeroSala) VALUES (?, ?)";
			
			//Tentar realizar o comando SQL
			try{
				
				//Enviando os par�metros e executando
				PreparedStatement pstmt = this.conexao.prepareStatement(sql);
				pstmt.setInt(1, s.getNumeroSala());
				pstmt.execute();
				
				//Fechar a conex�o
				pstmt.close();
				
			}catch(Exception e){
				
				//Caso haja falhas
				JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");
				
			}
			
			
			
		}
		
		//M�todo para selecionar cursos
		public DefaultTableModel listarSalas(){
			
			//Criando o DefaultTableModel
			DefaultTableModel modelo = new DefaultTableModel();
			
			//Definir as colunas do DefaultTableModel
			modelo.addColumn("C�digo");
			modelo.addColumn("Sala");
			
			//Comando SQL
			String sql = "SELECT * FROM sala";
			
			//Tentar realizar o comando SQL
			try{
				
				//Conectar e selecionar o comando SQL
				Statement stmt = conexao.createStatement();
				
				//Executando comando SQL e obtendo dados
				ResultSet rs = stmt.executeQuery(sql);
				
				//Listando cursos
				while(rs.next()){
					
					modelo.addRow(new Object[]{
						rs.getInt("idCurso"),
						rs.getString("numeroSala"),
						
					});
					
				}
				
				//Fechar a conex�o
				stmt.close();	
				
				
			}catch(Exception e){
				
				//Caso haja falhas na sele��o
				JOptionPane.showMessageDialog(null, "Falha ao selecionar salas.");
				
			}
			
			//Retornar o DefaultTableModel
			return modelo;
			
		}
}
