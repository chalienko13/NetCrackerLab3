package com.chalienko.hr.dao.impl.jdbc;

import com.chalienko.hr.dao.EmployeeDao;
import com.chalienko.hr.model.Employee;
import com.chalienko.hr.model.impl.real.EmployeeImpl;
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
public class EmployeeJdbcDao extends JdbcDaoSupport implements EmployeeDao {

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.setJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Override
    public void save(Employee employee) {
        this.getJdbcTemplate().update("insert into EMPLOYEE (FIRST_NAME,LAST_NAME) values (?,?)",
                new Object[] {employee.getFirstName(),employee.getLastName()} );

    }

    @Override
    public Employee getEmployeeById(Long key){
        return this.getJdbcTemplate().queryForObject(
                "SELECT * FROM C##CHAL.EMPLOYEE WHERE ID = ?",
                new EmployeeMapper(),
                key);
    }

    @Override
    public int update(Employee employee){
        return this.getJdbcTemplate().update("UPDATE C##CHAL.EMPLOYEE SET FIRST_NAME = ?, LAST_NAME = ?  WHERE ID = ?",
                new Object[] {employee.getFirstName(), employee.getLastName()},employee.getId());
    }

    @Override
    public void delete(Employee employee){
        this.getJdbcTemplate().update("DELETE FROM C##CHAL.EMPLOYEE WHERE ID = ?",
                employee.getId());
    }

    @Override
    public List<Employee> getAll(){
        return this.getJdbcTemplate().query("SELECT * FROM C##CHAL.EMPLOYEE",new EmployeeMapper());
    }

    private static final class EmployeeMapper implements RowMapper<Employee> {

        public Employee mapRow(ResultSet rs, int rowNum) throws SQLException {
            Employee employee = new EmployeeImpl();
            employee.setId(rs.getLong("ID"));
            employee.setFirstName("FIRST_NAME");
            employee.setLastName("LAST_NAME");
            return employee;
        }
    }
}
