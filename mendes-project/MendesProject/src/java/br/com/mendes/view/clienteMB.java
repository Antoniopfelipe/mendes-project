package br.com.mendes.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import br.com.mendes.model.Cliente;
import br.com.mendes.service.ClienteService;

@Scope(value="request")
@Controller("clienteMB")
public class ClienteMB implements Serializable{

	private static final long serialVersionUID = -4165603506554303884L;
	
	private Cliente cliente;
	
	private List<Cliente> clientes;
	
	@Autowired 
	private ClienteService clienteService;
	
	@PostConstruct
	public void iniciar() {
		clientes = clienteService.obterTodosCliente();
	}
	
    public ClienteMB() {  
    	
    	cliente = new Cliente();    	
    }
    
        
    public void salvarCliente() {
    	
    	clienteService.criarCliente(cliente);
    	FacesContext.getCurrentInstance().addMessage(null, 
	      		new FacesMessage(FacesMessage.SEVERITY_INFO, "Sucesso" , "Cadastrado com sucesso."));  
    	
    	clientes = clienteService.obterTodosCliente();
    }

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}


	public List<Cliente> getClientes() {
		return clientes;
	}


	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}  
  
}
