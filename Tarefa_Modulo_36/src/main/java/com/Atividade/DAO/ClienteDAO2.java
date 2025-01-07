package com.Atividade.DAO;

import com.Atividade.DAO.Generic.GenericDB2DAO;
import com.Atividade.Domain.Cliente;

public class ClienteDAO2 extends GenericDB2DAO<Cliente, Long> implements IClienteDAO<Cliente> {

	public ClienteDAO2() {
        super(Cliente.class);
    }

}