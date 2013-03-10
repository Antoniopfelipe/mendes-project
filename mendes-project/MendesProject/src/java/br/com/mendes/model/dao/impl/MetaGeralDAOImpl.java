package br.com.mendes.model.dao.impl;

import java.security.InvalidParameterException;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import br.com.mendes.model.MetaGeral;
import br.com.mendes.model.TipoMetaGeral;
import br.com.mendes.model.dao.MetaGeralDAO;

@Repository
public class MetaGeralDAOImpl extends DAOImpl<MetaGeral,Long> implements MetaGeralDAO {

	private static final long serialVersionUID = 2478166995437747144L;

	@Override
	public MetaGeral obterMetaAtual(TipoMetaGeral tipo) {
		
		if(tipo==null)
			throw new InvalidParameterException();
		
		StringBuilder hql = new StringBuilder();
		
		hql.append(" select m from MetaGeral m " +
				   " where m.tipo=:tipo " +
				   " and m.dataInicio=(select max(mi.dataInicio) from MetaGeral mi where mi.tipo=:tipo )");		
		
		Query query = getSession().createQuery(hql.toString());
				
		query.setParameter("tipo", tipo);
						
		return (MetaGeral) query.uniqueResult();
		
	}

}
