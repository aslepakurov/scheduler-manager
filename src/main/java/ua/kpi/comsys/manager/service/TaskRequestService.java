package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.TaskRequest;
import ua.kpi.comsys.manager.dao.TaskRequestDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * ExampleService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@Component
public class TaskRequestService implements ITaskRequestService {

    @Autowired
    private TaskRequestDAO dao;

    public String create(TaskRequest entity) {
        return dao.create(entity);
    }

    public TaskRequest get(String id) {
        return dao.get(id);
    }
}
