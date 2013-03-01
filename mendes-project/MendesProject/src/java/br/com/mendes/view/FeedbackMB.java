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
import br.com.mendes.model.Feedback;
import br.com.mendes.model.Produto;
import br.com.mendes.model.Servico;
import br.com.mendes.model.TipoAtendimento;
import br.com.mendes.service.ClienteService;
import br.com.mendes.service.FeedbackService;
import br.com.mendes.service.ProdutoService;
import br.com.mendes.service.ServicoService;
import br.com.mendes.service.TipoAtendimentoService;

@Scope(value = "request")
@Controller("feedbackMB")
public class FeedbackMB implements Serializable {

	private static final long serialVersionUID = -4165603506554303884L;

	private Feedback feedback;
	private TipoAtendimento tipoAtendimento;
	private Produto produto;
	private Servico servico;
	private Cliente cliente;

	private List<Feedback> feedbacks;
	private List<TipoAtendimento> tiposAtendimentos;
	private List<Produto> produtos;
	private List<Servico> servicos;
	private List<Cliente> clientes;

	@Autowired
	private FeedbackService feedbackService;
	@Autowired
	private TipoAtendimentoService tipoAtendimentoService;
	@Autowired
	private ProdutoService produtoService;
	@Autowired
	private ServicoService servicoService;
	@Autowired
	private ClienteService clienteService;

	@PostConstruct
	public void iniciar() {

		feedbacks = feedbackService.obterTodosFeedback();
		tiposAtendimentos = tipoAtendimentoService.obterTodosTipoAtendimento();
		produtos = produtoService.obterTodosProduto();
		servicos = servicoService.obterTodosServicos();
		clientes = clienteService.obterTodosCliente();
	}

	public FeedbackMB() {

		feedback = new Feedback();

		feedback.setTipoAtendimento(new TipoAtendimento());
		feedback.setProduto(new Produto());
		feedback.setServico(new Servico());
		feedback.setCliente(new Cliente());
	}

	public void salvarFeedback() {
		feedbackService.criarFeedback(feedback);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
						"Cadastrado com sucesso."));

		feedbacks = feedbackService.obterTodosFeedback();
	}

	public Feedback getFeedback() {
		return feedback;
	}

	public void setFeedback(Feedback feedback) {
		this.feedback = feedback;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}

	public List<TipoAtendimento> getTiposAtendimentos() {
		return tiposAtendimentos;
	}

	public void setTiposAtendimentos(List<TipoAtendimento> tiposAtendimentos) {
		this.tiposAtendimentos = tiposAtendimentos;
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

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

}
