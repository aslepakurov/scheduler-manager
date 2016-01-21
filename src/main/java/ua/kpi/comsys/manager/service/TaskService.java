package ua.kpi.comsys.manager.service;

import org.springframework.transaction.annotation.Transactional;
import ua.kpi.comsys.manager.dao.ITaskDAO;
import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.dao.TaskDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ua.kpi.comsys.manager.domain.TaskStatus;
import ua.kpi.comsys.manager.domain.dto.TastRequestDto;

/**
 * ExampleService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
@Transactional
@Component
public class TaskService implements ITaskService {

    @Autowired
    private ITaskDAO dao;

    public Task create(TastRequestDto taskDto) {
        Task task = TastRequestDto.from(taskDto);
        return dao.create(task);
    }

    public Task get(String id) {
        return dao.get(id);
    }

    @Override
    public String delete(String id) {
        return dao.delete(id);
    }

    @Override
    public void updateStatus(String id, TaskStatus newStatus) {
        dao.updateStatus(id, newStatus);
    }
}
