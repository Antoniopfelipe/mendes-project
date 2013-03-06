package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.Servico;
import br.com.mendes.service.ServicoService;

@Scope(value="request")
@Controller("servicoMB")
public class ServicoMB implements Serializable{

	private static final long serialVersionUID = -4165603506554303884L;
	
	private Servico servico;
	
	private String categoria;
	
	private List<Servico> servicos;
	
	@Autowired 
	private ServicoService servicoService;
	
	@PostConstruct
	public void iniciar() {
		servicos = servicoService.obterTodosServicos();
	}
	
    public ServicoMB() {  
    	
    	servico = new Servico();    	
    }
    
        
    public void salvarServico() {
    	
    	servicoService.criarServico(servico);
    	FacesContext.getCurrentInstance().addMessage(null, 
	      		new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso" , "Cadastrado com sucesso."));  
    	
    	servicos = servicoService.obterTodosServicos();
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
		this.servicos= servicos;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}  
  
}
