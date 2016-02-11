package com.chalienko.hr.model.impl.proxy;

import com.chalienko.hr.model.Manager;
import com.chalienko.hr.model.Project;
import com.chalienko.hr.model.impl.real.EmployeeImpl;
import com.chalienko.hr.model.impl.real.ManagerImpl;
import com.chalienko.hr.service.EmployeeService;
import com.chalienko.hr.service.ManagerService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


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
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        ManagerService managerService = (ManagerService) appContext.getBean("managerServiceImpl");
        return (ManagerImpl) managerService.getManager(getId());
    }
}
