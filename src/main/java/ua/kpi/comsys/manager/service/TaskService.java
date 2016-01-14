package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ExampleService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@Component
public class TaskService implements ITaskService {

    @Autowired
    private TaskDAO dao;

    public String create(Task entity) {
        return dao.create(entity);
    }

    public Task get(String id) {
        return dao.get(id);
    }
}
