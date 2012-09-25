package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Categoria;
import br.com.mendes.model.dao.CategoriaDAO;
import br.com.mendes.service.CategoriaService;

@Service
public class CategoriaServiceImpl implements CategoriaService {

	@Autowired
	private CategoriaDAO categoriaDAO;

	@Override
	@Transactional
	public Categoria obterCategoriaPorCod(Long codCategoria) {
		return categoriaDAO.getByCod(codCategoria);
	}

	@Override
	@Transactional
	public List<Categoria> obterTodasCategorias() {
		return categoriaDAO.getAll();
	}

	@Override
	@Transactional
	public Categoria criarCategoria(Categoria categoria) {
		return categoriaDAO.saveUpdateGetEntity(categoria);
	}
}
