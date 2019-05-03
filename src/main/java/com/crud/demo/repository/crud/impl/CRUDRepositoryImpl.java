package com.crud.demo.repository.crud.impl;

import com.crud.demo.repository.crud.CRUDRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

import java.io.Serializable;
import java.util.List;

public class CRUDRepositoryImpl<E, ID extends Serializable> implements CRUDRepository<E, ID> {
    private static final String SELECT_ALL = "select * from (%s)";
    private static final String SELECT_ALL_WHERE_ID = "select * from %s where id=?";

    private static final String SELECT_ALL_FROM_CALENDAR = "select * from %s";
    private static final String SELECT_ALL_WHERE_ROW_NUM = "select * from (select rownum() as row_num, * from %s ) where row_num >= ? and row_num < ?";
    private static final String SELECT_ALL_WHERE_ROW_PARAM = "select * from (select rownum() as row_num, * from (%s) ) where row_num >= %s and row_num < %s";
    private static final String DELETE_FROM_WHERE_ID = "delete from %s where id = ?";
    private static final String SELECT_COUNT_FROM = "select count(*) from %s ";
    private static final String SELECT_COUNT_FROM_QUERY = "select count(*) from (%s) ";

    private String table;

    private Class<E> className;

    @Autowired
    protected JdbcTemplate jdbcTemplate;

    public CRUDRepositoryImpl() {
    }

    public CRUDRepositoryImpl(String table, Class<E> className) {
        this.table = table;
        this.className = className;
    }

    @Override
    public E getOne(ID id) {
        E e = jdbcTemplate.queryForObject(String.format(SELECT_ALL_WHERE_ID, table.toLowerCase()), new Object[]{id}, new BeanPropertyRowMapper<>(className));
        return e;
    }

    @Override
    public E save(E e) {
        return null;
    }

    @Override
    public void delete(E e) {

    }

    @Override
    public List<E> findAll() {
        return null;
    }

    @Override
    public void delete(ID id) {

    }
}
