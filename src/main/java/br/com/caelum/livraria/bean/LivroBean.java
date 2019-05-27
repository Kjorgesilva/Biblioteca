package br.com.caelum.livraria.bean;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Named;
import br.com.caelum.livraria.dao.LivroDAO;
import br.com.caelum.livraria.modelo.Livro;


@ViewScoped
@Named
public class LivroBean implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Livro livro = new Livro();
	private List<Livro> listaa = new ArrayList<Livro>();
	private int idLivro;
	private double resultado;
	
	private String testeAutor;

	

	public String getTesteAutor() {
		return testeAutor;
	}

	public void setTesteAutor(String testeAutor) {
		this.testeAutor = testeAutor;
	}

	public double getResultado() {
		return resultado;
	}

	public void setResultado(double resultado) {
		this.resultado = resultado;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int idLivro) {
		this.idLivro = idLivro;
	}

	public List<Livro> getListaa() {
		return listaa;
	}

	public void setListaa(List<Livro> listaa) {
		this.listaa = listaa;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public Livro getLivro() {
		return livro;
	}

	// metodos para o banco



	public void excluir() {
		try {
			new LivroDAO().excluirLivro(idLivro);
			exibir();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void alterar(Livro livro) {
		try {
			new LivroDAO().update(livro);
			System.out.println("alterar informação: " + listaa.size());
			
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void limpar() {
		listaa.clear();
		livro = new Livro();
	}


	
	public void inserir() throws Exception {
		String x = "inserir";		
		System.out.println(x);

		try {
			if (livro.getId() != null && livro.getId() > 0) {
				alterar(livro);
			} else {
				new LivroDAO().inserir(livro);
			}

			exibir();
			livro = new Livro();
		} catch (Exception e) {
			e.printStackTrace();
		}

	
	}

	public String exibir() {
			
		listaa = new ArrayList<Livro>();
		try {
			listaa = new LivroDAO().retornoExibir();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;		

	}

	public void livroAlterar(Livro livroAlterar) {
		livro.setAutor(livroAlterar.getAutor());
		livro.setId(livroAlterar.getId());
		livro.setTitulo(livroAlterar.getTitulo());
		livro.setIsbn(livroAlterar.getIsbn());
		livro.setPreco(livroAlterar.getPreco());
		livro.setDataLancamento(livroAlterar.getDataLancamento());

	}

	

}
