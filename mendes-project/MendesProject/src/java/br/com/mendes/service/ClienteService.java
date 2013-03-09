package br.com.mendes.service;

import java.io.Serializable;
import java.util.List;

import br.com.mendes.dto.ClientesPeriodoDTO;
import br.com.mendes.model.Cliente;

public interface ClienteService extends Serializable {

    Cliente obterClientePorCod(Long codCliente);
    
    List<Cliente> obterTodosCliente();
    
    Cliente criarCliente(Cliente cliente);

	List<ClientesPeriodoDTO> obterQtdeClientesPorPeriodo();
}
