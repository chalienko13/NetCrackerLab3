package com.chalienko.hr;

import com.chalienko.hr.model.Project;
import com.chalienko.hr.service.ProjectService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by Chalienko on 06-Dec-15.
 */
public class Main {
    public static void main(String[] args) throws SQLException {
        ApplicationContext appContext = new ClassPathXmlApplicationContext("spring-jdbc.xml");
        ProjectService projectService= (ProjectService) appContext.getBean("projectServiceImpl");
        Project project = projectService.getProject(1L);
        System.out.println(project);

    }
}
