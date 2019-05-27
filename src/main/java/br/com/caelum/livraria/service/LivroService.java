package br.com.caelum.livraria.service;

import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import br.com.caelum.livraria.dao.LivroDAO;
import br.com.caelum.livraria.modelo.Livro;

public class LivroService implements Serializable {

	

	@Inject
	private LivroDAO livrodao;
		
	
//	
//	public List<Livro> findByIdLivro() {
//		return livrodao.findAll();
//	}
	
	
}
