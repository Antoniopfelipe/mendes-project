package br.com.mendes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Pedro
 */
@Entity
public class Feedback {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codFeedback;

	@ManyToOne(optional = false)
	private Cliente cliente;

	@ManyToOne(optional = false)
	private Produto produto;

	@ManyToOne(optional = false)
	private Servico servico;

	private String tipoAtendimento;

	private double nota;

	private String observacao;

	@Temporal(TemporalType.DATE)
	private Date dataFeedback;

	public Feedback() {
	}

	public Feedback(Long codFeedback, Cliente cliente, Produto produto,
			Servico servico, double nota, String tipoAtendimento,
			String observacao, Date dataFeedback) {
		this.codFeedback = codFeedback;
		this.cliente = cliente;
		this.produto = produto;
		this.servico = servico;
		this.nota = nota;
		this.tipoAtendimento = tipoAtendimento;
		this.observacao = observacao;
		this.dataFeedback = dataFeedback;
	}

	public Long getCodFeedback() {
		return codFeedback;
	}

	public void setCodFeedback(Long codFeedback) {
		this.codFeedback = codFeedback;
	}

	public Cliente getcliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}

	public String getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(String tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}

	public Date getDataFeedback() {
		return dataFeedback;
	}

	public void setDataFeedback(Date dataFeedback) {
		this.dataFeedback = dataFeedback;
	}
}
