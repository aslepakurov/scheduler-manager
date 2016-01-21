package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.TaskStatus;
import ua.kpi.comsys.manager.domain.dto.TastRequestDto;

/**
 * IExampleService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskService {
    Task create(TastRequestDto taskDto);
    Task get(String id);
    String delete(String id);
    void updateStatus(String id, TaskStatus newStatus);
}
