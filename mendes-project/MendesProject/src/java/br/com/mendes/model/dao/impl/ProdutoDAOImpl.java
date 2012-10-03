package br.com.mendes.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mendes.model.Produto;
import br.com.mendes.model.dao.ProdutoDAO;

@Repository
public class ProdutoDAOImpl extends DAOImpl<Produto,Long> implements ProdutoDAO {

}
