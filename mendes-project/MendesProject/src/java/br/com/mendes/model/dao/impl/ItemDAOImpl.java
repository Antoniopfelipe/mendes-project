package br.com.mendes.model.dao.impl;
import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.mendes.model.Item;
import br.com.mendes.model.TipoItem;
import br.com.mendes.model.dao.ItemDAO;

@Repository
public class ItemDAOImpl extends DAOImpl<Item,Long> implements ItemDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Item> buscarPorTipoECLiente(Long codCliente, TipoItem tipoItem) {
		
		StringBuilder hql = new StringBuilder();
		
		//TODO fazer join com item pedido, agrupar por produto e filtrar por cliente
		hql.append("select i from Item i where i.class=Produto ");
		
		Query query = getSession().createQuery(hql.toString());
		
		return query.list();
	}

}
