package com.chalienko.hr.service.impl;

import com.chalienko.hr.dao.ManagerDao;
import com.chalienko.hr.model.Manager;
import com.chalienko.hr.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
public class ManagerServiceImpl implements ManagerService {
    @Autowired
    private ManagerDao managerDao;

    @Override
    public Manager getManager(Long id) {
        return managerDao.getManagerById(id);
    }

    @Override
    public void saveManager(Manager manager) {
        managerDao.save(manager);
    }

    @Override
    public int updateManager(Manager manager) {
        return managerDao.update(manager);
    }

    @Override
    public void deleteManager(Manager manager) {
        managerDao.delete(manager);
    }

    @Override
    public List<Manager> getManagers() {
        return managerDao.getAll();
    }
}
