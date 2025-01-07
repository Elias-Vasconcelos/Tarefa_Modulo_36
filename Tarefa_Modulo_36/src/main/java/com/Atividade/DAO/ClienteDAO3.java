package com.Atividade.DAO;


import com.Atividade.DAO.Generic.GenericDB3DAO;
import com.Atividade.Domain.Cliente;
import com.Atividade.Domain.Cliente2;

public class ClienteDAO3 extends GenericDB3DAO<Cliente2, Long> implements IClienteDAO<Cliente2> {

    public ClienteDAO3() {
        super(Cliente2.class);
    }

}