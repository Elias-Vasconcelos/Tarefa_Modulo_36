package com.Atividade.DAO.Generic;

import com.Atividade.DAO.persistence;

import java.io.Serializable;

public abstract class GenericDB3DAO <T extends persistence, E extends Serializable>
        extends GenericDAO<T,E> {

    public GenericDB3DAO(Class<T> persistenteClass) {
        super(persistenteClass, "DB3");
    }

}