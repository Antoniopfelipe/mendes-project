package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.TipoAtendimento;
import br.com.mendes.service.TipoAtendimentoService;

@Scope(value = "request")
@Controller("tipoAtendimentoMB")
public class TipoAtendimentoMB implements Serializable {

	private static final long serialVersionUID = -4165603506554303884L;

	private TipoAtendimento tipoAtendimento;

	private List<TipoAtendimento> tiposAtendimento;

	@Autowired
	private TipoAtendimentoService tipoAtendimentoService;

	@PostConstruct
	public void iniciar() {
		tiposAtendimento = tipoAtendimentoService.obterTodosTipoAtendimento();
	}

	public TipoAtendimentoMB() {

		tipoAtendimento = new TipoAtendimento();
	}

	public void salvarTipoAtendimento() {

		tipoAtendimentoService.criarTipoAtendimento(tipoAtendimento);
		FacesContext.getCurrentInstance().addMessage(
				null,
				new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso",
						"Cadastrado com sucesso."));

		tiposAtendimento = tipoAtendimentoService.obterTodosTipoAtendimento();
	}

	public TipoAtendimento getTipoAtendimento() {
		return tipoAtendimento;
	}

	public void setTipoAtendimento(TipoAtendimento tipoAtendimento) {
		this.tipoAtendimento = tipoAtendimento;
	}

	public List<TipoAtendimento> getTiposAtendimento() {
		return tiposAtendimento;
	}

	public void setTipoAtendimentos(List<TipoAtendimento> tiposAtendimento) {
		this.tiposAtendimento = tiposAtendimento;
	}

}
