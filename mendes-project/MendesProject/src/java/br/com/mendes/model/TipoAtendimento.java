package br.com.mendes.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 * 
 * @author Pedro
 */
@Entity
public class TipoAtendimento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long codTipoAtendimento;

	private String descricao;

	@OneToMany(mappedBy = "tipoAtendimento")
	private List<Feedback> feedbacks;

	public TipoAtendimento() {
	}

	public TipoAtendimento(Long codTipoAtendimento, String descricao) {
		this.codTipoAtendimento = codTipoAtendimento;
		this.descricao = descricao;
	}

	public Long getCodTipoAtendimento() {
		return codTipoAtendimento;
	}

	public void setCodTipoAtendimento(Long codTipoAtendimento) {
		this.codTipoAtendimento = codTipoAtendimento;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Feedback> getFeedbacks() {
		return feedbacks;
	}

	public void setFeedbacks(List<Feedback> feedbacks) {
		this.feedbacks = feedbacks;
	}
}
