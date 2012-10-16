package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Meta;
import br.com.mendes.model.dao.MetaDAO;
import br.com.mendes.service.MetaService;

@Service
public class MetaServiceImpl implements MetaService {

	@Autowired
	private MetaDAO metaDAO;

	@Override
	@Transactional
	public Meta obterMetaPorCod(Long codMeta) {
		return metaDAO.getByCod(codMeta);
	}

	@Override
	@Transactional
	public List<Meta> obterTodasMeta() {
		return metaDAO.getAll();
	}

	@Override
	@Transactional
	public Meta criarMeta(Meta meta) {
		return metaDAO.saveUpdateGetEntity(meta);
	}
}
