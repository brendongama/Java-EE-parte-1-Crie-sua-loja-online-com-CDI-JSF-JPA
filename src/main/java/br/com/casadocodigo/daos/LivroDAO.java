package br.com.casadocodigo.daos;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import br.com.casadocodigo.models.Livro;

public class LivroDAO {
		
	@PersistenceContext
	private EntityManager manager;

	
	public void salvar(Livro livro) {
		manager.persist(livro);
	}
}
