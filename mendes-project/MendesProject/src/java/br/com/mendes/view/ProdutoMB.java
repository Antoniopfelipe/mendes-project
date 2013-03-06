package br.com.mendes.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.CategoriaProduto;
import br.com.mendes.model.Produto;
import br.com.mendes.service.MetaService;
import br.com.mendes.service.ProdutoService;


@Scope(value="request")
@Controller("produtoMB")
public class ProdutoMB implements Serializable{

	private static final long serialVersionUID = -4165603506554303884L;
	
	private Produto produto;
	
	private List<Produto> produtos;
	
	private List<CategoriaProduto> categoriasProduto;
	
	private Double valorMeta;
	
	@Autowired 
	private ProdutoService produtoService;
	
	@Autowired 
	private MetaService metaService;
	
	@PostConstruct
	public void iniciar() {
		produtos = produtoService.obterTodosProduto();
		
		produto = new Produto(); 
    	categoriasProduto = Arrays.asList(CategoriaProduto.values());
	}
	
        
    public void salvarProduto() {

    	Produto produtoSalvo = produtoService.criarProduto(produto);
    	
    	metaService.criarMetaEspecifica(valorMeta, produtoSalvo);
    	
    	FacesContext.getCurrentInstance().addMessage(null, 
	      		new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso" , "Cadastrado com sucesso."));  
    	
    }

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}


	public List<Produto> getProdutos() {
		return produtos;
	}


	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<CategoriaProduto> getCategoriasProduto() {
		return categoriasProduto;
	}

	public void setCategoriasProduto(List<CategoriaProduto> categoriasProduto) {
		this.categoriasProduto = categoriasProduto;
	}
	
	public Double getValorMeta() {
		return valorMeta;
	}
	
	public void setValorMeta(Double valorMeta) {
		this.valorMeta = valorMeta;
	}
}
