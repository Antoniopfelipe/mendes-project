package br.com.mendes.service;

import br.com.mendes.model.Item;
import br.com.mendes.model.Meta;
import br.com.mendes.model.MetaEspecifica;
import br.com.mendes.model.MetaGeral;
import br.com.mendes.model.TipoMetaGeral;

public interface MetaService {

	MetaGeral criarMetaGeral(MetaGeral meta);

	MetaEspecifica criarMetaEspecifica(MetaEspecifica meta);

	Meta criarMetaGeral(Double valor , TipoMetaGeral tipo);

	MetaEspecifica criarMetaEspecifica(Double valor , Item item);

	MetaGeral obterMetaGeralAtual(TipoMetaGeral tipo);

	MetaEspecifica obterMetaEspecificaAtual(Long codItem);
}
