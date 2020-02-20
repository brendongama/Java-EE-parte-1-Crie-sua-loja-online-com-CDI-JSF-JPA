package br.com.casadocodigo.beans;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import br.com.casadocodigo.models.Livro;

@Named
@RequestScoped
public class AdminLivrosBean {

	private Livro livro = new Livro();
	
	public void salvar() {
		System.out.println("Livro Cadastrado: " + livro);
	}

	public Livro getLivro() {
		return livro;
	}

	public void setLivro(Livro livro) {
		this.livro = livro;
	}
}
