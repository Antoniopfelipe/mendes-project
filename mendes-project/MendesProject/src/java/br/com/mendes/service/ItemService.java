package br.com.mendes.service;

import java.util.List;

import br.com.mendes.dto.ItemComboDTO;
import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;

public interface ItemService {
    
    List<Item> obterTodosItens();

	List<ItemComboDTO> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem);
    
}
