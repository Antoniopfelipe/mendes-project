package br.com.mendes.model.dao.impl;

import org.springframework.stereotype.Repository;

import br.com.mendes.model.Cliente;
import br.com.mendes.model.dao.ClienteDAO;

@Repository
public class ClienteDAOImpl extends DAOImpl<Cliente,Long> implements ClienteDAO {

}
