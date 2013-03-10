package br.com.mendes.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Item;
import br.com.mendes.model.MetaEspecifica;
import br.com.mendes.model.MetaGeral;
import br.com.mendes.model.TipoMetaGeral;
import br.com.mendes.model.dao.MetaEspecificaDAO;
import br.com.mendes.model.dao.MetaGeralDAO;
import br.com.mendes.service.MetaService;

@Service
public class MetaServiceImpl implements MetaService {

	@Autowired
	private MetaGeralDAO metaGeralDAO;

	@Autowired
	private MetaEspecificaDAO metaEspeficicaDAO;
	
	@Override
	@Transactional
	public MetaGeral criarMetaGeral(MetaGeral meta) {
		return metaGeralDAO.saveUpdateGetEntity(meta);
	}
	
	@Override
	@Transactional
	public MetaEspecifica criarMetaEspecifica(MetaEspecifica meta) {
		return metaEspeficicaDAO.saveUpdateGetEntity(meta);
	}
	
	@Override
	@Transactional
	public MetaEspecifica criarMetaEspecifica(Double valor, Item item) {
		
		
		MetaEspecifica metaEspecifica  = metaEspeficicaDAO.obterMetaAtual(item.getCod());
		
		if(metaEspecifica != null && valor.equals(metaEspecifica.getValor()))		
			return metaEspecifica;
		
		metaEspecifica = new MetaEspecifica();
		metaEspecifica.setDataInicio(new Date());
		metaEspecifica.setItem(item);
		metaEspecifica.setValor(valor);
	
		return metaEspeficicaDAO.saveUpdateGetEntity(metaEspecifica);
	}
	
	@Override
	@Transactional
	public MetaGeral criarMetaGeral(Double valor , TipoMetaGeral tipo) {
		MetaGeral meta  = new MetaGeral();
		meta.setDataInicio(new Date());
		meta.setValor(valor);
		meta.setTipo(tipo);
		return metaGeralDAO.saveUpdateGetEntity(meta);
	}

	@Override
	@Transactional
	public MetaGeral obterMetaGeralAtual(TipoMetaGeral tipo) {
		return metaGeralDAO.obterMetaAtual(tipo);
	}
	
	@Override
	@Transactional
	public MetaEspecifica obterMetaEspecificaAtual(Long codItem) {
		return metaEspeficicaDAO.obterMetaAtual(codItem);
	}
}
