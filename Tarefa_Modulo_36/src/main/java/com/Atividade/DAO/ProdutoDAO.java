package com.Atividade.DAO;

import com.Atividade.DAO.Generic.GenericDAO;
import com.Atividade.DAO.Generic.GenericDB1DAO;
import com.Atividade.Domain.Produto;

public class ProdutoDAO extends GenericDB1DAO<Produto, Long> implements IProdutoDAO {

    public ProdutoDAO() {
        super(Produto.class);
    }

}
