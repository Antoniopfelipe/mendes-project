package br.com.mendes.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mendes.model.Orcamento;
import br.com.mendes.model.dao.OrcamentoDAO;

@Repository
public class OrcamentoDAOImpl extends DAOImpl<Orcamento, Long> implements
		OrcamentoDAO {

}
