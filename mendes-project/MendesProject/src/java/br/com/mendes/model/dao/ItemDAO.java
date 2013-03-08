package br.com.mendes.model.dao;

import java.util.List;

import br.com.mendes.dto.ItemComboDTO;
import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;


public interface ItemDAO extends DAO<Item, Long>{

	List<ItemComboDTO> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem);

}
