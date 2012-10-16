package br.com.mendes.service;

import java.util.List;

import br.com.mendes.model.Meta;

public interface MetaService {

    Meta obterMetaPorCod(Long codMeta);
    
    List<Meta> obterTodasMeta();
    
    Meta criarMeta(Meta meta);
}
