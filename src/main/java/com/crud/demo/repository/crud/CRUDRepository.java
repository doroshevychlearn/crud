package com.crud.demo.repository.crud;

import java.io.Serializable;
import java.util.List;

public interface CRUDRepository <E, ID extends Serializable>{
    E getOne(ID id);
    void save(String sql, Object... values);
    List<E> findAll();
    void delete(ID id);
}
