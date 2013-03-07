package br.com.mendes.service;

import java.util.List;

import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;

public interface ItemService {
    
    List<Item> obterTodosItens();

	List<Item> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem);
    
}
