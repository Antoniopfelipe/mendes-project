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

import br.com.mendes.model.Cliente;
import br.com.mendes.model.Item;
import br.com.mendes.model.Pedido;
import br.com.mendes.model.Produto;
import br.com.mendes.model.Servico;
import br.com.mendes.model.TipoItem;
import br.com.mendes.service.ClienteService;
import br.com.mendes.service.ItemService;
import br.com.mendes.service.PedidoService;
import br.com.mendes.service.ProdutoService;
import br.com.mendes.service.ServicoService;

@Scope(value = "request")
@Controller("orcamentoMB")
public class PedidoMB implements Serializable {

	private static final long serialVersionUID = -4165603506554303884L;

	private Pedido pedido;
	private Cliente cliente;
	private Produto produto;
	private Servico servico;
	private TipoItem tipoItem;
	private Integer quantidade;

	private List<Pedido> pedidos;
	private List<Cliente> clientes;
	private List<Produto> produtos;
	private List<Servico> servicos;
	private List<TipoItem> tiposItem;
	private List<Item> itens;

	@Autowired
	private PedidoService pedidoService;

	@Autowired
	private ClienteService clienteService;

	@Autowired
	private ProdutoService produtoService;

	@Autowired
	private ServicoService servicoService;
	
	@Autowired
	private ItemService itemService;

	@PostConstruct
	public void iniciar() {

	
		
		pedidos = pedidoService.obterTodosPedidos();
		clientes = clienteService.obterTodosCliente();
		produtos = produtoService.obterTodosProduto();
		servicos = servicoService.obterTodosServicos();
		
	}

	public PedidoMB() {
		pedido = new Pedido();
		pedido.setCliente(new Cliente());
		pedido.setServico(new Servico());
		
		tiposItem = Arrays.asList(TipoItem.values());	
	}
	
	public void escolherTipoItem() {
		
		itens = itemService.buscarPorTipoECLiente(cliente.getCodCliente(), tipoItem);
	}

	public void salvarPedido() {

		pedidoService.criarPedido(pedido);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
						"Cadastrado com sucesso."));

		pedidos = pedidoService.obterTodosPedidos();
	}
	

	public Pedido getPedido() {
		return pedido;
	}

	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}

	public void setOrcamentos(List<Pedido> pedidos) {
		this.pedidos = pedidos;
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

	public TipoItem getTipoItem() {
		return tipoItem;
	}

	public void setTipoItem(TipoItem tipoItem) {
		this.tipoItem = tipoItem;
	}

	public List<TipoItem> getTiposItem() {
		return tiposItem;
	}

	public void setTiposItem(List<TipoItem> tiposItem) {
		this.tiposItem = tiposItem;
	}

	public List<Item> getItens() {
		return itens;
	}

	public void setItens(List<Item> itens) {
		this.itens = itens;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

}
