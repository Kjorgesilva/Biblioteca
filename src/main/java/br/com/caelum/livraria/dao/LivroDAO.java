package br.com.caelum.livraria.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.caelum.livraria.modelo.Livro;

public class LivroDAO {

	public ArrayList<Livro> retornoExibir() throws Exception {
		
		PreparedStatement stmt = null;
		Connection conexao = null;
		conexao = ConnectionFactory.getConexao();		
		ResultSet rs = null;
		ArrayList<Livro> lista = new ArrayList<Livro>();
		StringBuilder query = new StringBuilder();		
		try {
			query.append("select id, autor,titulo,isbn,preco,dataNascimento from livros;");				
//			query.append(" select l.autor autor_livro, l.titulo titulo_livro , l.isbn isbn_livro, l.preco preco_livro,");
//			query.append(" l.valor valor_livro, l.dataNascimento dataNascimento_livros,");
//			query.append(" from livros l left join autor a  on  l.id_autor = a.id; ");	
			stmt = conexao.prepareStatement(query.toString());
			rs = stmt.executeQuery();
			while (rs.next()) {
				Livro livro1 = new Livro();				
				livro1.setId(rs.getInt("id"));
				livro1.setAutor(rs.getString("autor"));
				livro1.setTitulo(rs.getString("titulo"));
				livro1.setIsbn(rs.getString("isbn"));
				livro1.setPreco(rs.getDouble("preco"));
				livro1.setDataLancamento(rs.getString("dataNascimento"));
				lista.add(livro1);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conexao.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return lista;
	}

	
	public boolean inserir(Livro livros){
		try {
			PreparedStatement consulta1 = null;
			Connection conexao = null;	
			conexao = ConnectionFactory.getConexao();
			
			StringBuffer sql1 = new StringBuffer();
			sql1.append("INSERT INTO livros (autor,titulo,isbn,preco,dataNascimento) " + "VALUES (?, ?, ?, ?,?)");
			consulta1 = conexao.prepareStatement(sql1.toString());
			
			consulta1.setString(1, livros.getAutor());
			consulta1.setString(2, livros.getTitulo());
			consulta1.setString(3, livros.getIsbn());	
			consulta1.setDouble(4, livros.getPreco());
			consulta1.setString(5, livros.getDataLancamento());
			consulta1.executeUpdate();
			conexao.commit();
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	public int excluirLivro(int idLivro) throws SQLException {

		try {	
	
			PreparedStatement consulta1 = null;
			Connection conexao = null;	
			conexao = ConnectionFactory.getConexao();			
		
			
			System.out.println("excluir dados " + idLivro);
			
			StringBuffer sql1 = new StringBuffer();
			sql1.append("DELETE FROM livros WHERE id = " + idLivro);			
			consulta1 = conexao.prepareStatement(sql1.toString());
			consulta1.executeUpdate();
			conexao.commit();			
		} catch (Exception e) {
			e.printStackTrace();		
		}

		return 1;
	}
	
	
    public  int update (Livro livro) throws Exception  { 
    	try {
    		
    		PreparedStatement consulta1 = null;
			Connection conexao = null;	
			conexao = ConnectionFactory.getConexao();
			conexao.setAutoCommit(false);
			
			
			StringBuffer sql1 = new StringBuffer();			
			
			sql1.append("UPDATE livros SET autor =?, titulo =?, isbn =?, preco =?, dataNascimento=? where id=?");			
			consulta1 = conexao.prepareStatement(sql1.toString());
			consulta1.setString(1, livro.getAutor());
			consulta1.setString(2, livro.getTitulo());
			consulta1.setString(3, livro.getIsbn());
			consulta1.setDouble(4, livro.getPreco());
			consulta1.setString(5, livro.getDataLancamento());
			consulta1.setInt(6, livro.getId());
			
			consulta1.executeUpdate();
			conexao.commit();	
		
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	return 1;
		
		
    }



}
