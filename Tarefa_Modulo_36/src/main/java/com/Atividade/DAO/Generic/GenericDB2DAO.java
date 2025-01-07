package com.Atividade.DAO.Generic;

import com.Atividade.DAO.persistence;

import java.io.Serializable;

public abstract class GenericDB2DAO <T extends persistence, E extends Serializable>
        extends GenericDAO<T,E> {

    public GenericDB2DAO(Class<T> persistenteClass) {
        super(persistenteClass, "DB2");
    }

}