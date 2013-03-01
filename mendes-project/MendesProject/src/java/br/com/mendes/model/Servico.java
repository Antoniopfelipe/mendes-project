package br.com.mendes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 * 
 * @author Pedro
 */
@Entity
public class Servico {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codServico;

	private String descricao;

	private double precoCusto;

	private double precoVenda;

	@OneToMany(mappedBy = "servico")
	private List<Feedback> feedbacks;

	// @OneToMany
	private Long codMeta;

	@OneToOne(mappedBy = "servico")
	private Orcamento orcamento;

	public Servico() {
	}

	public Servico(Long codServico, String descricao, double precoCusto,
			double precoVenda, Long codMeta, Orcamento orcamento) {
		this.codServico = codServico;
		this.descricao = descricao;
		this.precoCusto = precoCusto;
		this.precoVenda = precoVenda;
		this.codMeta = codMeta;
		this.orcamento = orcamento;
	}

	public Long getCodServico() {
		return codServico;
	}

	public void setCodServico(Long codServico) {
		this.codServico = codServico;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public double getPrecoCusto() {
		return precoCusto;
	}

	public void setPrecoCusto(double precoCusto) {
		this.precoCusto = precoCusto;
	}

	public double getPrecoVenda() {
		return precoVenda;
	}

	public void setPrecoVenda(double precoVenda) {
		this.precoVenda = precoVenda;
	}

	public Long getCodMeta() {
		return codMeta;
	}

	public void setCodMeta(Long codMeta) {
		this.codMeta = codMeta;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

}
