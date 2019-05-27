package br.com.caelum.livraria.resource;

import java.util.List;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import br.com.caelum.livraria.dao.LivroDAO;
import br.com.caelum.livraria.modelo.Livro;
import br.com.caelum.livraria.service.LivroService;

@Path("/livro")
public class BibliotecaControle {
	
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/getLivro")
	public List<Livro>getLivro() {		
		try {
			System.out.println("chegou");
			return new LivroDAO().retornoExibir();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
		

}
