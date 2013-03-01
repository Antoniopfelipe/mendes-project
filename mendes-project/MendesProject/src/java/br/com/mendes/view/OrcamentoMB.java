package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.Cliente;
import br.com.mendes.model.Orcamento;
import br.com.mendes.model.Produto;
import br.com.mendes.model.Servico;
import br.com.mendes.service.ClienteService;
import br.com.mendes.service.OrcamentoService;
import br.com.mendes.service.ProdutoService;
import br.com.mendes.service.ServicoService;

@Scope(value = "request")
@Controller("orcamentoMB")
public class OrcamentoMB implements Serializable {

	private static final long serialVersionUID = -4165603506554303884L;

	private Orcamento orcamento;
	private Cliente cliente;
	private Produto produto;
	private Servico servico;

	private List<Orcamento> orcamentos;
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Servico> servicos;

	@Autowired
	private OrcamentoService orcamentoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ServicoService servicoService;

	@PostConstruct
	public void iniciar() {

		orcamentos = orcamentoService.obterTodosOrcamento();
		clientes = clienteService.obterTodosCliente();
		produtos = produtoService.obterTodosProduto();
		servicos = servicoService.obterTodosServicos();
	}

	public OrcamentoMB() {
		orcamento = new Orcamento();
		orcamento.setCliente(new Cliente());
		orcamento.setProduto(new Produto());
		orcamento.setServico(new Servico());
	}

	public void salvarOrcamento() {

		orcamentoService.criarOrcamento(orcamento);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
						"Cadastrado com sucesso."));

		orcamentos = orcamentoService.obterTodosOrcamento();
	}

	public Orcamento getOrcamento() {
		return orcamento;
	}

	public void setOrcamento(Orcamento orcamento) {
		this.orcamento = orcamento;
	}

	public List<Orcamento> getOrcamentos() {
		return orcamentos;
	}

	public void setOrcamentos(List<Orcamento> orcamentos) {
		this.orcamentos = orcamentos;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
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

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

}
