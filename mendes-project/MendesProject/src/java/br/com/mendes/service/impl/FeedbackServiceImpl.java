package br.com.mendes.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mendes.model.Feedback;
import br.com.mendes.model.dao.FeedbackDAO;
import br.com.mendes.service.FeedbackService;

@Service
public class FeedbackServiceImpl implements FeedbackService {

	@Autowired
	private FeedbackDAO feedbackDAO;

	@Override
	@Transactional
	public Feedback obterFeedbackPorCod(Long codFeedback) {
		return feedbackDAO.getByCod(codFeedback);
	}

	@Override
	@Transactional
	public List<Feedback> obterTodosFeedback() {
		return feedbackDAO.getAll();
	}

	@Override
	@Transactional
	public Feedback criarFeedback(Feedback feedback) {
		return feedbackDAO.saveUpdateGetEntity(feedback);
	}
}
