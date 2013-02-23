package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.Categoria;
import br.com.mendes.service.CategoriaService;

@Scope(value = "request")
@Controller("categoriaMB")
public class CategoriaMB implements Serializable {

	private static final long serialVersionUID = -4165603506554303884L;

	private Categoria categoria;

	private List<Categoria> categorias;

	@Autowired
	private CategoriaService categoriaService;

	@PostConstruct
	public void iniciar() {
		categorias = categoriaService.obterTodasCategorias();
	}

	public CategoriaMB() {

		categoria = new Categoria();
	}

	public void salvarCategoria() {

		categoriaService.criarCategoria(categoria);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
						"Cadastrado com sucesso."));

		categorias = categoriaService.obterTodasCategorias();
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}

}
