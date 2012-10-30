package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Evento;
import br.com.mendes.model.dao.EventoDAO;
import br.com.mendes.service.EventoService;

@Service
public class EventoServiceImpl implements EventoService {

	@Autowired
	private EventoDAO eventoDAO;

	@Override
	@Transactional
	public Evento obterEventoPorCod(Long codEvento) {
		return eventoDAO.getByCod(codEvento);
	}

	@Override
	@Transactional
	public List<Evento> obterTodosEventos() {
		return eventoDAO.getAll();
	}

	@Override
	@Transactional
	public Evento criarEvento(Evento evento) {
		return eventoDAO.saveUpdateGetEntity(evento);
	}
}
