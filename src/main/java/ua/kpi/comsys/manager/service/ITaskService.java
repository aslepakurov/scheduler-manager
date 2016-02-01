package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.TaskStatus;
import ua.kpi.comsys.manager.domain.dto.TaskRequestDto;

import java.io.IOException;

/**
 * ITaskService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskService {
    Task create(TaskRequestDto taskDto) throws IOException;
    Task get(String id);
    String delete(String id);
    void updateStatus(String id, TaskStatus newStatus);
}
