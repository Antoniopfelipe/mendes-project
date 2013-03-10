package br.com.mendes.model.dao;

import br.com.mendes.model.MetaGeral;
import br.com.mendes.model.TipoMetaGeral;


public interface MetaGeralDAO extends DAO<MetaGeral, Long>{

	MetaGeral obterMetaAtual(TipoMetaGeral tipo);


}
