package br.com.mendes.model.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;
import br.com.mendes.model.dao.ItemDAO;

@Repository
public class ItemDAOImpl extends DAOImpl<Item,Long> implements ItemDAO {

	private static final long serialVersionUID = 2157614205573395922L;

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem) {
		
		StringBuilder hql = new StringBuilder();
		
		hql.append(" select distinct i as tipo from ItemPedido ip " + 
				" join ip.item i " +
				" join ip.pedido p " +
				" join p.cliente c ");  
				
		hql.append(" where c.id=:codCliente");
		
		
		if(tipoItem!=null)
			hql.append(" and i.class=:tipoItem");
				
		Query query = getSession().createQuery(hql.toString());
		
		query.setParameter("codCliente", codCliente);
		
		if(tipoItem!=null)
			query.setParameter("tipoItem", tipoItem.name());
						
		return query.list();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> buscarTodos(TipoItem tipoItem) {
		
		StringBuilder hql = new StringBuilder();
		
		hql.append(" select distinct i as tipo from Item i ");
		
		if(tipoItem!=null)
			hql.append(" where i.class=:tipoItem");		
		
		Query query = getSession().createQuery(hql.toString());
				
		if(tipoItem!=null)
			query.setParameter("tipoItem", tipoItem.name());
						
		return query.list();
	}

}
