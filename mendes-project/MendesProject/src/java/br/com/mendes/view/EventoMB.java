package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.Evento;
import br.com.mendes.service.EventoService;

@Scope(value="request")
@Controller("eventoMB")
public class EventoMB implements Serializable{

	private static final long serialVersionUID = -4165603506554303884L;
	
	private Evento evento;
	
	private List<Evento> eventos;
	
	@Autowired 
	private EventoService eventoService;
	
	@PostConstruct
	public void iniciar() {
		eventos = eventoService.obterTodosEventos();
	}
	
    public EventoMB() {  
    	
    	evento= new Evento();    	
    }
    
        
    public void salvarEvento() {
    	
    	eventoService.criarEvento(evento);
    	FacesContext.getCurrentInstance().addMessage(null, 
	      		new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso" , "Cadastrado com sucesso."));  
    	
    	eventos = eventoService.obterTodosEventos();
    }

	public Evento getEvento() {
		return evento;
	}

	public void setEvento(Evento evento) {
		this.evento = evento;
	}


	public List<Evento> getEventos() {
		return eventos;
	}


	public void setEventos(List<Evento> eventos) {
		this.eventos= eventos;
	}
	
  
}
