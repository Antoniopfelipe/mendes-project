package br.com.mendes.model;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TIPO_ITEM", discriminatorType = DiscriminatorType.STRING)
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codProduto;

	@OneToMany(mappedBy = "produto")
	private List<Feedback> feedbacks;

	private String nome;

	private Double precoCusto;

	private Double precoVenda;
	
	@ManyToOne
	private MetaEspecifica meta;

	@OneToOne(mappedBy = "produto")
	private Pedido pedido;


	public Long getCodProduto() {
		return codProduto;
	}

	public void setCodProduto(Long codProduto) {
		this.codProduto = codProduto;
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

	public MetaEspecifica getMeta() {
		return meta;
	}

	public void setMeta(MetaEspecifica meta) {
		this.meta = meta;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Pedido getOrcamento() {
		return pedido;
	}

	public void setOrcamento(Pedido orcamento) {
		this.pedido = orcamento;
	}
}
