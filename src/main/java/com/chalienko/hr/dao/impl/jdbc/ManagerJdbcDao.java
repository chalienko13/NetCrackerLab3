package com.chalienko.hr.dao.impl.jdbc;

import com.chalienko.hr.dao.ManagerDao;
import com.chalienko.hr.model.Manager;
import com.chalienko.hr.model.impl.proxy.ProjectProxy;
import com.chalienko.hr.model.impl.real.ManagerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 29.01.2016.
 */
@Repository
public class ManagerJdbcDao extends JdbcDaoSupport implements ManagerDao {

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.setJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Override
    public void save(Manager manager) {
        this.getJdbcTemplate().update("INSERT INTO MANAGER(ID, FIRST_NAME, LAST_NAME, ID_PROJECT) VALUES(?,?,?,?))",
                new Object[]{manager.getId(), manager.getFirstName(), manager.getLastName(), manager.getProject().getId()});
    }

    @Override
    public Manager getManagerById(Long key) {
        return this.getJdbcTemplate().queryForObject(
                "SELECT * FROM C##CHAL.MANAGER WHERE ID = ?",
                new ManagerMapper(),
                key);
    }

    @Override
    public int update(Manager manager) {
        return this.getJdbcTemplate().update(
                "UPDATE C##CHAL.MANAGER SET FIRST_NAME = ?, LAST_NAME = ?, ID_PROJECT = ?  WHERE ID = ?",
                new Object[] {manager.getFirstName(),manager.getLastName(),manager.getProject().getId()},manager.getId());
    }

    @Override
    public void delete(Manager manager) {
        this.getJdbcTemplate().update("DELETE FROM C##CHAL.MANAGER WHERE ID = ?",
                manager.getId());
    }

    @Override
    public List<Manager> getAll() {
        return this.getJdbcTemplate().query("SELECT * FROM C##CHAL.MANAGER", new ManagerMapper());
    }

    private static final class ManagerMapper implements RowMapper<Manager> {

        public Manager mapRow(ResultSet rs, int rowNum) throws SQLException {
            Manager manager= new ManagerImpl();
            manager.setId(rs.getLong("ID"));
            manager.setFirstName(rs.getString("FIRST_NAME"));
            manager.setLastName(rs.getString("LAST_NAME"));
            manager.setProject(new ProjectProxy(rs.getLong("ID_PROJECT")));
            return manager;
        }
    }
}
