package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Pedido;
import br.com.mendes.model.dao.PedidoDAO;
import br.com.mendes.service.PedidoService;

@Service
public class PedidoServiceImpl implements PedidoService {

	@Autowired
	private PedidoDAO pedidoDAO;

	@Override
	@Transactional
	public Pedido obterPedidoPorCod(Long codPedido) {
		return pedidoDAO.getByCod(codPedido);
	}

	@Override
	@Transactional
	public List<Pedido> obterTodosPedidos() {
		return pedidoDAO.getAll();
	}

	@Override
	@Transactional
	public Pedido criarPedido(Pedido pedido) {
		return pedidoDAO.saveUpdateGetEntity(pedido);
	}
}
