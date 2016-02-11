package com.chalienko.hr.dao.impl.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;

/**
 * Created by Chalienko on 10.02.2016.
 */
public class JdbcDaoSupport {
    private JdbcTemplate jdbcTemplate;

    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    public JdbcTemplate getJdbcTemplate() {
        return jdbcTemplate;
    }
}
