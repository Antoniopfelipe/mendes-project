package br.com.mendes.service;

import java.io.Serializable;
import java.util.List;

import br.com.mendes.model.Feedback;

public interface FeedbackService extends Serializable {

	Feedback obterFeedbackPorCod(Long codFeedback);

	List<Feedback> obterTodosFeedback();

	Feedback criarFeedback(Feedback feedback);

	Feedback obterFeedbackPorClienteItem(Long codCliente, Long codItem);
}
