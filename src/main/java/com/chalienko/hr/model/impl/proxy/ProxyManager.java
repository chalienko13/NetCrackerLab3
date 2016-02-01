package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.dao.ManagerDao;
import com.chalienko.hr.dao.impl.oracle.OracleDaoFactory;
import com.chalienko.hr.model.Manager;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.real.RealManager;

import java.sql.SQLException;


/**
 * Created by Chalienko on 01.02.2016.
 */
public class ProxyManager implements Manager {
    private Long id;
    private RealManager manager;

    public ProxyManager(Long id) {
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

    private RealManager downloadManager(){
        RealManager manager = null;
        try(OracleDaoFactory oracleDaoFactory = new OracleDaoFactory()) {
            ManagerDao managerDao = oracleDaoFactory.getManagerDao();
            manager = (RealManager) managerDao.read(getId());
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  manager;
    }
}
