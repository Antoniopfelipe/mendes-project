package br.com.mendes.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mendes.model.Pedido;
import br.com.mendes.model.dao.PedidoDAO;

@Repository
public class PedidoDAOImpl extends DAOImpl<Pedido, Long> implements
		PedidoDAO {

}
