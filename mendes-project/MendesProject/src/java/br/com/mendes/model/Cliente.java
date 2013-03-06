package br.com.mendes.model;

import java.util.Date;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * 
 * @author Pedro
 */
@Entity
public class Cliente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codCliente;

	private String nome;

	private String sobrenome;

	private Long codEndereco;

	private String telefone;

	private String celular;

	private String rg;

	private String cpf;
	
	@OneToMany(mappedBy = "cliente")
	private List<Feedback> feedbacks;

	@Temporal(TemporalType.DATE)
	private Date dataNascimento;

	@Temporal(TemporalType.DATE)
	private Date dataCadastro;

	@OneToOne(mappedBy = "cliente")
	private Pedido orcamento;

	public Cliente() {
	}

	public Cliente(Long codCliente, String nome, String sobrenome,
			Long codEndereco, String telefone, String celular, String rg,
			String cpf,  Date dataNascimento, Date dataCadastro) {
		this.codCliente = codCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
		this.codEndereco = codEndereco;
		this.telefone = telefone;
		this.celular = celular;
		this.rg = rg;
		this.cpf = cpf;
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
	}

	public Cliente(Long codCliente, String nome, String sobrenome) {

		this.codCliente = codCliente;
		this.nome = nome;
		this.sobrenome = sobrenome;
	}

	public Long getCodCliente() {
		return codCliente;
	}

	public void setCodCliente(Long codCliente) {
		this.codCliente = codCliente;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getSobrenome() {
		return sobrenome;
	}

	public void setSobrenome(String sobrenome) {
		this.sobrenome = sobrenome;
	}

	public Long getCodEndereco() {
		return codEndereco;
	}

	public void setCodEndereco(Long codEndereco) {
		this.codEndereco = codEndereco;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Pedido getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Pedido orcamento) {
		this.orcamento = orcamento;
	}

}
