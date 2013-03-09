package br.com.mendes.service;

import java.io.Serializable;
import java.util.List;

import br.com.mendes.dto.ItemComboDTO;
import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;

public interface ItemService extends Serializable {
    
    List<Item> obterTodosItens();

	List<ItemComboDTO> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem);
    
}
