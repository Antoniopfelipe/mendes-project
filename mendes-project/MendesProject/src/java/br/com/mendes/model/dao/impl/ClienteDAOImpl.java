package br.com.mendes.model.dao.impl;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.transform.Transformers;
import org.springframework.stereotype.Repository;

import br.com.mendes.dto.ClientesPeriodoDTO;
import br.com.mendes.model.Cliente;
import br.com.mendes.model.dao.ClienteDAO;

@Repository
public class ClienteDAOImpl extends DAOImpl<Cliente,Long> implements ClienteDAO {

	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<ClientesPeriodoDTO> obterQtdeClientesPorPeriodo() {
	
		StringBuilder hql = new StringBuilder();
		
		hql.append(" select year(c.dataCadastro) as ano, " +
				   "        month(c.dataCadastro) as mes, " +
				   "        count(c.codCliente) as qtde  " +
				   " from  Cliente c 					 " +
				   " group by year(c.dataCadastro), month(c.dataCadastro)  " +
				   " order by year(c.dataCadastro), month(c.dataCadastro) ");
		
		Query query = getSession().createQuery(hql.toString());
		
		query.setResultTransformer(Transformers.aliasToBean(ClientesPeriodoDTO.class));
		
		return query.list();
		
	}
	
}
