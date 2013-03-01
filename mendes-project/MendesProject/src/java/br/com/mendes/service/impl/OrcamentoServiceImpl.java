package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Orcamento;
import br.com.mendes.model.dao.OrcamentoDAO;
import br.com.mendes.service.OrcamentoService;

@Service
public class OrcamentoServiceImpl implements OrcamentoService {

	@Autowired
	private OrcamentoDAO orcamentoDAO;

	@Override
	@Transactional
	public Orcamento obterOrcamentoPorCod(Long codOrcamento) {
		return orcamentoDAO.getByCod(codOrcamento);
	}

	@Override
	@Transactional
	public List<Orcamento> obterTodosOrcamento() {
		return orcamentoDAO.getAll();
	}

	@Override
	@Transactional
	public Orcamento criarOrcamento(Orcamento orcamento) {
		return orcamentoDAO.saveUpdateGetEntity(orcamento);
	}
}
