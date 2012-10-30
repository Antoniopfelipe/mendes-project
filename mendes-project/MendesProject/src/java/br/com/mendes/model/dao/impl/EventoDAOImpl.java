package br.com.mendes.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mendes.model.Evento;
import br.com.mendes.model.dao.EventoDAO;

@Repository
public class EventoDAOImpl extends DAOImpl<Evento,Long> implements EventoDAO {

}
