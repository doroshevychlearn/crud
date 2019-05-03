package com.crud.demo.repository.crud;

import java.io.Serializable;
import java.util.List;

public interface CRUDRepository <E, ID extends Serializable>{
    E getOne(ID id);
    E save(E entity);
    void delete(E e);
    List<E> findAll();
    void delete(ID id);
}
