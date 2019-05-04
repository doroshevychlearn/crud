package com.crud.demo.repository.crud.impl;

import org.springframework.jdbc.core.JdbcTemplate;
import com.crud.demo.repository.crud.CRUDRepository;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.io.Serializable;
import java.util.logging.Logger;

import static java.util.Objects.isNull;

public abstract class CRUDRepositoryImpl<E, ID extends Serializable> implements CRUDRepository<E, ID> {

    private String table;

    private Class<E> className;

    private final String NULL_ID_ERROR = "The id must be not null!";

    private static final Logger LOG = Logger.getLogger(CRUDRepositoryImpl.class.getName());

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
        if (isNull(id)) {
            LOG.info(NULL_ID_ERROR);
            throw new IllegalArgumentException(NULL_ID_ERROR);
        }
        E entity = null;
        try {
            String selectAllWhereId = "select * from %s where id=?";
            String sql = String.format(selectAllWhereId, table.toLowerCase());
            LOG.info(sql);
            entity = this.jdbcTemplate.queryForObject(sql, new Object[]{id}, new BeanPropertyRowMapper<>(className));
        } catch (Exception e) {
            LOG.info(String.format("The person with id = %s does not exist!", id));
        }
        return entity;
    }

    @Override
    public void save(String sql, Object... values) {
        LOG.info(String.format(sql, values));
        this.jdbcTemplate.update(sql, values);
    }

    @Override
    public List<E> findAll() {
        String selectAllFrom = "select * from %s";
        String sql = String.format(selectAllFrom, table.toLowerCase());
        LOG.info(sql);
        return this.jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(className));
    }

    @Override
    public void delete(ID id) {
        if (isNull(id)) {
            LOG.info(NULL_ID_ERROR);
            throw new IllegalArgumentException(NULL_ID_ERROR);
        }
        String deleteFromWhereId = "delete from %s where id = ?";
        String sql = String.format(deleteFromWhereId, table);
        LOG.info(sql);
        jdbcTemplate.update(sql, id);
    }
}
