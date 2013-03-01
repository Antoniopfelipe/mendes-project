package br.com.mendes.service;

import java.util.List;

import br.com.mendes.model.Orcamento;

public interface OrcamentoService {

	Orcamento obterOrcamentoPorCod(Long codOrcamento);

	List<Orcamento> obterTodosOrcamento();

	Orcamento criarOrcamento(Orcamento orcamento);
}
