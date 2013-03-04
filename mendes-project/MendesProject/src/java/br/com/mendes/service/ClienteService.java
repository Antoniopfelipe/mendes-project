package br.com.mendes.service;

import java.util.List;

import br.com.mendes.dto.ClientesPeriodoDTO;
import br.com.mendes.model.Cliente;

public interface ClienteService {

    Cliente obterClientePorCod(Long codCliente);
    
    List<Cliente> obterTodosCliente();
    
    Cliente criarCliente(Cliente cliente);

	List<ClientesPeriodoDTO> obterQtdeClientesPorPeriodo();
}
