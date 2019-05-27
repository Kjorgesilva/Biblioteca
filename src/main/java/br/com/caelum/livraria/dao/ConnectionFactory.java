package br.com.caelum.livraria.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionFactory {

	public static Connection getConexao() throws Exception{
		

		Connection conn = null;
		
		Class.forName("com.mysql.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/livrariadb?useTimezone=true&serverTimezone=UTC";
		String usuario = "root";
		String senha = "123456";
		conn =  DriverManager.getConnection(url, usuario, senha);	
		
		conn.setAutoCommit(false);
		
		return conn;
			
	}
	
}
