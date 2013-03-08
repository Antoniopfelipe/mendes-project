package br.com.mendes.model.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import br.com.mendes.dto.ItemComboDTO;
import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;
import br.com.mendes.model.dao.ItemDAO;

@Repository
public class ItemDAOImpl extends DAOImpl<Item,Long> implements ItemDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<ItemComboDTO> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem) {
		
		StringBuilder hql = new StringBuilder();
		
		//TODO fazer join com item pedido, agrupar por produto e filtrar por cliente
		hql.append(" select i.cod as cod, i.nome as descricao, i.class as tipo from ItemPedido ip " + 
				" join ip.item i " +
				" join ip.pedido p " +
				" join p.cliente c ");  
				
		hql.append(" where c.id=:codCliente");
		
		
		if(tipoItem!=null)
			hql.append(" and i.class=:tipoItem");
		
		hql.append(" group by i.cod, i.nome, i.class ");
		
		Query query = getSession().createQuery(hql.toString());
		
		query.setParameter("codCliente", codCliente);
		
		if(tipoItem!=null)
			query.setParameter("tipoItem", tipoItem.name());
				
		query.setResultTransformer(Transformers.aliasToBean(ItemComboDTO.class));
		
		return query.list();
	}

}
