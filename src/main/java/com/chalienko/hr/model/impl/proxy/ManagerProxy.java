package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.dao.ManagerDao;
import com.chalienko.hr.dao.impl.oracle.DaoOracleFactory;
import com.chalienko.hr.model.Manager;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.real.ManagerImpl;

import java.sql.SQLException;


/**
 * Created by Chalienko on 01.02.2016.
 */
public class ManagerProxy implements Manager {
    private Long id;
    private ManagerImpl manager;

    public ManagerProxy(Long id) {
        this.id = id;

    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public Project getProject() {
        if (manager ==null){
            manager = downloadManager();
        }
        return manager.getProject();
    }

    public void setProject(Project project) {
        if (manager ==null){
            manager = downloadManager();
        }
        manager.setProject(project);
    }

    public String getFirstName() {
        if (manager ==null){
            manager = downloadManager();
        }
        return manager.getFirstName();
    }

    public void setFirstName(String firstName) {
        if (manager ==null){
            manager = downloadManager();
        }
        manager.setFirstName(firstName);
    }

    public String getLastName() {
        if (manager ==null){
            manager = downloadManager();
        }
        return manager.getLastName();
    }

    public void setLastName(String lastName) {
        if (manager ==null){
            manager = downloadManager();
        }
        manager.setLastName(lastName);
    }

    private ManagerImpl downloadManager(){
        ManagerImpl manager = null;
        try(DaoOracleFactory daoOracleFactory = new DaoOracleFactory()) {
            ManagerDao managerDao = daoOracleFactory.getManagerDao();
            manager = (ManagerImpl) managerDao.read(getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  manager;
    }
}
