package com.Atividade.DAO;

import com.Atividade.DAO.Generic.IGenericDAO;
import com.Atividade.Domain.Cliente;

public interface IClienteDAO<T extends persistence>  extends IGenericDAO<T, Long> {

}