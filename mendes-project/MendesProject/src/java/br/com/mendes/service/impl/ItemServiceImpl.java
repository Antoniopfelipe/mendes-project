package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;
import br.com.mendes.model.dao.ItemDAO;
import br.com.mendes.service.ItemService;

@Service
public class ItemServiceImpl implements ItemService {

	
	private static final long serialVersionUID = 2705497057114522401L;
	
	@Autowired
	private ItemDAO itemDAO;

	@Override
	@Transactional
	public List<Item> obterTodosItens() {
		return itemDAO.getAll();
	}
	
	@Override
	@Transactional
	public List<Item> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem) {
		return itemDAO.buscarPorTipoECLiente(codCliente, tipoItem);
	}

	@Override
	@Transactional
	public List<Item> buscarTodos(TipoItem tipoItem) {
		return itemDAO.buscarTodos(tipoItem);
	}
	
	@Override
	@Transactional
	public Item buscarPorCodigo(Long cod) {
		return itemDAO.getByCod(cod);
	}
	
}