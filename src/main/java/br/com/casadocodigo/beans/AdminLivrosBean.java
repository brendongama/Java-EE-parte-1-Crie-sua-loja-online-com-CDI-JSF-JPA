package br.com.casadocodigo.beans;

import java.util.ArrayList;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.transaction.Transactional;

import br.com.casadocodigo.daos.AutorDao;
import br.com.casadocodigo.daos.LivroDAO;
import br.com.casadocodigo.models.Autor;
import br.com.casadocodigo.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	private Livro livro = new Livro();
	
	@Inject
	private LivroDAO dao;
	@Inject
	private AutorDao autorDao;
	@Inject
	private FacesContext context;
	
	private List<Integer> autoresId = new ArrayList<Integer>();
		
	
	@Transactional
	public String salvar() {
		for(Integer autorId: autoresId) {
			livro.getAutores().add(new Autor(autorId));
		}
		dao.salvar(livro);
		context = FacesContext.getCurrentInstance();
		context.getExternalContext()
			.getFlash().setKeepMessages(true);		
		context
			.addMessage(null, new FacesMessage("Livro cadastrado com sucesso!"));
		
		return "/livros/lista?faces-redirect=true";
	}
	
	public List<Autor> getAutores() {
		 return autorDao.listar();
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}

	public LivroDAO getDao() {
		return dao;
	}

	public void setDao(LivroDAO dao) {
		this.dao = dao;
	}

	public List<Integer> getAutoresId() {
		return autoresId;
	}

	public void setAutoresId(List<Integer> autoresId) {
		this.autoresId = autoresId;
	}
}
