package br.com.mendes.service;

import java.util.List;

import br.com.mendes.model.Evento;

public interface EventoService {

    Evento obterEventoPorCod(Long codEvento);
    
    List<Evento> obterTodosEventos();
    
    Evento criarEvento(Evento evento);
}
