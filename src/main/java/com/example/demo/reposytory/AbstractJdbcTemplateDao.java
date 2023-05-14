package com.example.demo.reposytory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import java.util.List;

/**
 * Date: 5/12/2023<br/>
 * Time: 9:42 AM<br/>
 */
public abstract class AbstractJdbcTemplateDao {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public <T> T getData( String sql, RowMapper<T> rowMapper, Object ...params) {

        try {
            return jdbcTemplate.queryForObject(
                    sql,
                    rowMapper,
                    params
            );
        }catch (EmptyResultDataAccessException e){
            return null;
        }
    }

    public <T> List<T> getMulData(String sql, RowMapper<T> rowMapper, Object ...params) {
        return jdbcTemplate.query(
                sql,
                rowMapper,
                params
        );
    }
}
