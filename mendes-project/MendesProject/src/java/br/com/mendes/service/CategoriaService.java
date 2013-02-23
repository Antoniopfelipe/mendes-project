package br.com.mendes.service;

import java.util.List;

import br.com.mendes.model.Categoria;

public interface CategoriaService {

    Categoria obterCategoriaPorCod(Long codCategoria);
    
    List<Categoria> obterTodasCategorias();
    
    Categoria criarCategoria(Categoria categoria);
}
