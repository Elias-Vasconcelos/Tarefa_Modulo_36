package com.Atividade.DAO.Generic;

import com.Atividade.DAO.persistence;

import java.io.Serializable;

public abstract class GenericDB1DAO<T extends persistence, E extends Serializable>
        extends GenericDAO<T,E> {

    public GenericDB1DAO(Class<T> persistenteClass) {
        super(persistenteClass, "DB1");
    }

}
