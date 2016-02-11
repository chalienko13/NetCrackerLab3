package com.chalienko.hr.dao.impl.jdbc;

import com.chalienko.hr.dao.CustomerDao;
import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.impl.real.CustomerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Chalienko on 10-Dec-15.
 */
@Repository
public class CustomerJdbcDao extends JdbcDaoSupport implements CustomerDao {
    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.setJdbcTemplate(new JdbcTemplate(dataSource));
    }

    @Override
    public Customer getCustomerByID(Long key) {
        return this.getJdbcTemplate().queryForObject(
                "SELECT * FROM C##CHAL.CUSTOMER WHERE ID = ?",
                new CustomerMapper(),
                key);
    }

    @Override
    public void save(Customer customer){
        this.getJdbcTemplate().update("insert into CUSTOMER (ID,NAME) values (?,?)",
                        new Object[] {customer.getId(),customer.getCustomerName()} );
    }



    @Override
    public int update(Customer customer){
        return this.getJdbcTemplate().update("UPDATE C##CHAL.CUSTOMER SET NAME = ? WHERE ID = ?",
                customer.getCustomerName(),customer.getId());
    }

    @Override
    public void delete(Customer customer){
        this.getJdbcTemplate().update("DELETE FROM C##CHAL.CUSTOMER WHERE ID = ?",
                customer.getId());

    }

    @Override
    public List<Customer> getAll(){
        return this.getJdbcTemplate().query("SELECT * FROM C##CHAL.CUSTOMER",new CustomerMapper());
    }

    private static final class CustomerMapper implements RowMapper<Customer> {

        public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
            Customer customer = new CustomerImpl();
            customer.setId(rs.getLong("ID"));
            customer.setCustomerName(rs.getString("NAME"));
            return customer;
        }
    }

}
