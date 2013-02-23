package br.com.mendes.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mendes.model.Feedback;
import br.com.mendes.model.dao.FeedbackDAO;

@Repository
public class FeedbackDAOImpl extends DAOImpl<Feedback, Long> implements
		FeedbackDAO {

}
