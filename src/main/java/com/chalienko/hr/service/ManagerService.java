package com.chalienko.hr.service;

import com.chalienko.hr.model.Customer;
import com.chalienko.hr.model.Manager;

import java.util.List;

/**
 * Created by Chalienko on 11.02.2016.
 */
public interface ManagerService {

    Manager getManager(Long id);

    void saveManager(Manager manager);

    int updateManager(Manager manager);

    void deleteManager(Manager manager);

    List<Manager> getManagers();
}
