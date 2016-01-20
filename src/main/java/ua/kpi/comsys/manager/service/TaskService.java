package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.dto.TastRequestDto;

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

    public Task create(TastRequestDto task) {
        return dao.create(task);
    }

    public Task get(String id) {
        return dao.get(id);
    }
}
