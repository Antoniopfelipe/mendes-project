package br.com.mendes.service;

import java.util.List;

import br.com.mendes.model.Feedback;

public interface FeedbackService {

	Feedback obterFeedbackPorCod(Long codFeedback);

	List<Feedback> obterTodosFeedback();

	Feedback criarFeedback(Feedback feedback);
}
