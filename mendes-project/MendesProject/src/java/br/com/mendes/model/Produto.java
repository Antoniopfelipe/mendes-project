package br.com.mendes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Pedro
 */
@Entity
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProduto;

	private String categoria;

	@OneToMany(mappedBy = "produto")
	private List<Feedback> feedbacks;

	private String nome;

	private Double precoCusto;

	private Double precoVenda;
	
	@ManyToOne
	private Meta meta;

	@OneToOne(mappedBy = "produto")
	private Pedido orcamento;

	public Produto() {
	}

	public Produto(Long codProduto, String categoria,
			List<Feedback> feedbacks, String nome, Double precoCusto,
			Double precoVenda, Meta meta, Pedido orcamento) {
		this.codProduto = codProduto;
		this.categoria = categoria;
		this.feedbacks = feedbacks;
		this.nome = nome;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.meta = meta;
		this.orcamento = orcamento;
	}

	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(Double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public Double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(Double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Pedido getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Pedido orcamento) {
		this.orcamento = orcamento;
	}

}
