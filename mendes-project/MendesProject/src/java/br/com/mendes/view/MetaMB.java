package br.com.mendes.view;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.MetaGeral;
import br.com.mendes.service.MetaService;

@Scope(value="request")
@Controller("metaMB")
public class MetaMB implements Serializable{

	private static final long serialVersionUID = -4165603506554303884L;
	
	private MetaGeral metaCliente;
	private MetaGeral metaProduto;
	private MetaGeral metaFeedBackEmail;
	private MetaGeral metaFeedBackTelefone;
		
	@Autowired 
	private MetaService metaService;
	
	@PostConstruct
	public void iniciar() {
		
		//TODO
		//metaCliente = metaService.obterMetaAtual(TipoMetaGeral.CLIENTE);
    	//metaProduto = metaService.obterMetaAtual(TipoMetaGeral.PRODUTO);
    	//metaFeedBackTelefone = metaService.obterMetaAtual(TipoMetaGeral.FEEDBACK_TELEFONE);
    	//metaFeedBackEmail = metaService.obterMetaAtual(TipoMetaGeral.FEEDBACK_EMAIL);
	}
	
    public MetaMB() {  
    	
    	
    	
    }
    
        
    public void salvarMeta() {
    	
    	metaService.criarMetaGeral(metaCliente);
    	metaService.criarMetaGeral(metaProduto);
    	metaService.criarMetaGeral(metaFeedBackTelefone);
    	metaService.criarMetaGeral(metaFeedBackEmail);
    	
    	FacesContext.getCurrentInstance().addMessage(null, 
	      		new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso" , "Cadastrado com sucesso."));  
    }


  
}
