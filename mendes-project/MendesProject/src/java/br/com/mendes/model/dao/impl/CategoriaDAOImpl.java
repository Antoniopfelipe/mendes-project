package br.com.mendes.model.dao.impl;


import org.springframework.stereotype.Repository;
import br.com.mendes.model.Categoria;
import br.com.mendes.model.dao.CategoriaDAO;

@Repository
public class CategoriaDAOImpl extends DAOImpl<Categoria,Long> implements CategoriaDAO {

}
