package br.com.mendes.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Pedro
 */
@Entity
public class Orcamento {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codOrcamento;

	@OneToOne
	private Cliente cliente;

	@Temporal(TemporalType.DATE)
	private Date dataEmissao;

	@Temporal(TemporalType.DATE)
	private Date previsaoEntrega;

	@OneToOne
	private Produto produto;

	@OneToOne
	private Servico servico;

	private double valorTotal;

	private boolean status;

	public Orcamento() {
	}

	public Orcamento(Long codOrcamento, Cliente cliente, Date dataEmissao,
			Date previsaoEntrega, Produto produto, Servico servico,
			double valorTotal, boolean status) {
		this.codOrcamento = codOrcamento;
		this.cliente = cliente;
		this.dataEmissao = dataEmissao;
		this.previsaoEntrega = previsaoEntrega;
		this.produto = produto;
		this.servico = servico;
		this.valorTotal = valorTotal;
		this.status = status;
	}

	public Long getCodOrcamento() {
		return codOrcamento;
	}

	public void setCodOrcamento(Long codOrcamento) {
		this.codOrcamento = codOrcamento;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Date getDataEmissao() {
		return dataEmissao;
	}

	public void setDataEmissao(Date dataEmissao) {
		this.dataEmissao = dataEmissao;
	}

	public Date getPrevisaoEntrega() {
		return previsaoEntrega;
	}

	public void setPrevisaoEntrega(Date previsaoEntrega) {
		this.previsaoEntrega = previsaoEntrega;
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

	public double getValorTotal() {
		return valorTotal;
	}

	public void setValorTotal(double valorTotal) {
		this.valorTotal = valorTotal;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
