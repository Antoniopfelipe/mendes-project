package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.TipoAtendimento;
import br.com.mendes.model.dao.TipoAtendimentoDAO;
import br.com.mendes.service.TipoAtendimentoService;

@Service
public class TipoAtendimentoServiceImpl implements TipoAtendimentoService {

	@Autowired
	private TipoAtendimentoDAO tipoAtendimentoDAO;

	@Override
	@Transactional
	public TipoAtendimento obterTipoAtendimentoPorCod(Long codTipoAtendimento) {
		return tipoAtendimentoDAO.getByCod(codTipoAtendimento);
	}

	@Override
	@Transactional
	public List<TipoAtendimento> obterTodosTipoAtendimento() {
		return tipoAtendimentoDAO.getAll();
	}

	@Override
	@Transactional
	public TipoAtendimento criarTipoAtendimento(TipoAtendimento tipoAtendimento) {
		return tipoAtendimentoDAO.saveUpdateGetEntity(tipoAtendimento);
	}
}
