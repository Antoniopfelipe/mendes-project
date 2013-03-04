package br.com.mendes.model.dao;

import java.util.List;

import br.com.mendes.dto.ClientesPeriodoDTO;
import br.com.mendes.model.Cliente;


public interface ClienteDAO extends DAO<Cliente, Long>{

	List<ClientesPeriodoDTO> obterQtdeClientesPorPeriodo();

}
