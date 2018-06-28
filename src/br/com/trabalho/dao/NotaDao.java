package br.com.trabalho.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

import br.com.trabalho.bean.NotaBean;
import br.com.trabalho.connection.AlunoConnection;

public class NotaDao {

	//Atributo para obter a conexão
			private Connection conexao;
			
			//Construtor
			public NotaDao(){
				
				this.conexao = new AlunoConnection().obterConexao();
			}
			
			
			//Método para cadastrar um curso
			public void cadastrarNotas(NotaBean n){
				
				//Comando SQL
				String sql = "INSERT INTO  (nota1, nota2, nota3, nota4) VALUES (?, ?)";
				
				//Tentar realizar o comando SQL
				try{
					
					//Enviando os parâmetros e executando
					PreparedStatement pstmt = this.conexao.prepareStatement(sql);
					pstmt.setInt(1, n.getMediaNota());
					pstmt.execute();
					
					//Fechar a conexão
					pstmt.close();
					
				}catch(Exception e){
					
					//Caso haja falhas
					JOptionPane.showMessageDialog(null, "Falha ao inserir os dados");
					
				}
				
				
				
			}
			
			//Método para selecionar notas
			public DefaultTableModel listarNotas(){
				
				//Criando o DefaultTableModel
				DefaultTableModel modelo = new DefaultTableModel();
				
				//Definir as colunas do DefaultTableModel
				modelo.addColumn("Código");
				modelo.addColumn("Nota1");
				modelo.addColumn("nota2");
				modelo.addColumn("Nota3");
				modelo.addColumn("nota4");
				
				//Comando SQL
				String sql = "SELECT * FROM notas";
				
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
							rs.getDouble("nota1"),
							rs.getDouble("nota2"),
							rs.getDouble("nota3"),
							rs.getDouble("nota4"),
							
						});
						
					}
					
					//Fechar a conexão
					stmt.close();	
					
					
				}catch(Exception e){
					
					//Caso haja falhas na seleção
					JOptionPane.showMessageDialog(null, "Falha ao selecionar salas.");
					
				}
				
				//Retornar o DefaultTableModel
				return modelo;
				
			}
}
