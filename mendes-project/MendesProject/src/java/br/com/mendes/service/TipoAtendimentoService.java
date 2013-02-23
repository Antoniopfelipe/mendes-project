package br.com.mendes.service;

import java.util.List;

import br.com.mendes.model.TipoAtendimento;

public interface TipoAtendimentoService {

	TipoAtendimento obterTipoAtendimentoPorCod(Long codTipoAtendimento);

	List<TipoAtendimento> obterTodosTipoAtendimento();

	TipoAtendimento criarTipoAtendimento(TipoAtendimento tipoAtendimento);
}
