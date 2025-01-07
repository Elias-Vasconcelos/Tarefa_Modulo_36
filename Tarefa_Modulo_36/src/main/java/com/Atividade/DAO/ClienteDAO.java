package com.Atividade.DAO;

import com.Atividade.DAO.Generic.GenericDAO;
import com.Atividade.DAO.Generic.GenericDB1DAO;
import com.Atividade.Domain.Cliente;

public class ClienteDAO extends GenericDB1DAO<Cliente, Long> implements IClienteDAO<Cliente> {

    public ClienteDAO() {
        super(Cliente.class);

 }
}
