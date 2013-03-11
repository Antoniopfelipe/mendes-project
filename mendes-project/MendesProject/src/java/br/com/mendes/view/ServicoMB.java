package br.com.mendes.view;

import java.io.Serializable;
import java.util.Arrays;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.Meta;
import br.com.mendes.model.Servico;
import br.com.mendes.model.TipoServico;
import br.com.mendes.service.MetaService;
import br.com.mendes.service.ServicoService;
import br.com.mendes.utils.MBUtil;

@Scope(value = "request")
@Controller("servicoMB")
public class ServicoMB implements Serializable {

	private static final long serialVersionUID = -8900938210077927756L;

	private Servico servico;

	private List<Servico> servicos;

	private List<TipoServico> tiposServico;

	private Double valorMeta;

	@Autowired
	private ServicoService servicoService;

	@Autowired
	private MetaService metaService;

	@PostConstruct
	public void iniciar() {
		servicos = servicoService.obterTodosServicos();

		tiposServico = Arrays.asList(TipoServico.values());

		resetDados();
	}

	public void resetDados() {
		servico = new Servico();
		valorMeta = null;
	}

	public String iniciarEdicao(Long codServico) {

		servico = servicoService.obterServicoPorCod(codServico);

		Meta meta = metaService.obterMetaEspecificaAtual(codServico);

		if (meta != null) {
			valorMeta = meta.getValor();
		}

		return "/paginas/cadastroServico.xhtml";
	}

	public void salvarServico() {

		Servico servicoSalvo = servicoService.criarServico(servico);

		if (valorMeta == null) {
			valorMeta = 0.0;
		}

		metaService.criarMetaEspecifica(valorMeta, servicoSalvo);

		MBUtil.addInfo("Cadastrado com sucesso.");

		resetDados();
	}

	public Servico getServico() {
		return servico;
	}

	public void setServico(Servico servico) {
		this.servico = servico;
	}

	public List<Servico> getServicos() {
		return servicos;
	}

	public void setServicos(List<Servico> servicos) {
		this.servicos = servicos;
	}

	public List<TipoServico> getTiposServico() {
		return tiposServico;
	}

	public void setTiposServico(List<TipoServico> tiposServico) {
		this.tiposServico = tiposServico;
	}

	public Double getValorMeta() {
		return valorMeta;
	}

	public void setValorMeta(Double valorMeta) {
		this.valorMeta = valorMeta;
	}
}
