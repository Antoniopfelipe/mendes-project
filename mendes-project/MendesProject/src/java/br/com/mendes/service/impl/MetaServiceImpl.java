package br.com.mendes.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Item;
import br.com.mendes.model.Meta;
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
		MetaEspecifica meta  = new MetaEspecifica();
		meta.setData(new Date());
		
		meta.setValor(valor);
		meta.setItem(item);
		return metaEspeficicaDAO.saveUpdateGetEntity(meta);
	}
	
	@Override
	@Transactional
	public Meta criarMetaGeral(Double valor , TipoMetaGeral tipo) {
		MetaGeral meta  = new MetaGeral();
		meta.setData(new Date());
		meta.setValor(valor);
		meta.setTipo(tipo);
		return metaGeralDAO.saveUpdateGetEntity(meta);
	}
}
