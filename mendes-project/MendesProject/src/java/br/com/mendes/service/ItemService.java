package br.com.mendes.service;

import java.io.Serializable;
import java.util.List;

import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;

public interface ItemService extends Serializable {
    
    List<Item> obterTodosItens();

	List<Item> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem);

	List<Item> buscarTodos(TipoItem tipoItem);

	Item buscarPorCodigo(Long cod);
    
}
