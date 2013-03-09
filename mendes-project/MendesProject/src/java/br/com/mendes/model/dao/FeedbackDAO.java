package br.com.mendes.model.dao;

import br.com.mendes.model.Feedback;

public interface FeedbackDAO extends DAO<Feedback, Long> {

	Feedback obterFeedbackPorClienteItem(Long codCliente, Long codItem);

}
