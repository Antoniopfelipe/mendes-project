package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.Meta;
import br.com.mendes.service.MetaService;

@Scope(value="request")
@Controller("metaMB")
public class MetaMB implements Serializable{

	private static final long serialVersionUID = -4165603506554303884L;
	
	private Meta meta;
	
	private List<Meta> metas;
	
	@Autowired 
	private MetaService metaService;
	
	@PostConstruct
	public void iniciar() {
		metas = metaService.obterTodasMeta();
	}
	
    public MetaMB() {  
    	
    	meta = new Meta();    	
    }
    
        
    public void salvarMeta() {
    	
    	metaService.criarMeta(meta);
    	FacesContext.getCurrentInstance().addMessage(null, 
	      		new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso" , "Cadastrado com sucesso."));  
    	
    	metas = metaService.obterTodasMeta();
    }

	public Meta getMeta() {
		return meta;
	}

	public void setMeta(Meta meta) {
		this.meta = meta;
	}


	public List<Meta> getMetas() {
		return metas;
	}


	public void setMetas(List<Meta> metas) {
		this.metas = metas;
	}  
  
}
