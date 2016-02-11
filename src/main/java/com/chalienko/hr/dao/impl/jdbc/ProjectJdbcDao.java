package com.chalienko.hr.dao.impl.jdbc;

import com.chalienko.hr.dao.ProjectDao;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.proxy.CustomerProxy;
import com.chalienko.hr.model.impl.proxy.ManagerProxy;
import com.chalienko.hr.model.impl.real.ProjectImpl;
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
public class ProjectJdbcDao extends JdbcDaoSupport implements ProjectDao {

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.setJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Override
    public void save(Project project){
        this.getJdbcTemplate().update("INSERT INTO PROJECT(ID, ID_CUSTOMER, ID_MANAGER, PROJECT_NAME ) VALUES(?,?,?,?))",
                new Object[]{project.getId(),project.getCustomer().getId(),
                        project.getManager().getId(),project.getProjectName()});
    }

    @Override
    public Project getProjectByID(Long key){
        return this.getJdbcTemplate().queryForObject("SELECT * FROM C##CHAL.PROJECT WHERE ID = ?",
                new ProjectMapper(), key);
    }

    @Override
    public int update(Project project){
        return this.getJdbcTemplate().update(
                "UPDATE C##CHAL.Project SET PROJECT_NAME = ?, ID_CUSTOMER = ?, ID_MANAGER = ?  WHERE ID = ?",
                new Object[]{project.getProjectName(), project.getCustomer().getId(),project.getManager().getId()},
                project.getId());
    }

    @Override
    public void delete(Project project){
        this.getJdbcTemplate().update("DELETE FROM C##CHAL.Project WHERE ID = ?",project.getId());
    }

    @Override
    public List<Project> getAll(){
        return this.getJdbcTemplate().query("SELECT * FROM C##CHAL.PROJECT", new ProjectMapper());
    }

    private static final class ProjectMapper implements RowMapper<Project> {

        public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
            Project project = new ProjectImpl();
            project.setId(rs.getLong("ID"));
            project.setProjectName(rs.getString("PROJECT_NAME"));
            project.setCustomer(new CustomerProxy(rs.getLong("ID_CUSTOMER")));
            project.setManager(new ManagerProxy(rs.getLong("ID_MANAGER")));
            return project;
        }

    }
}
