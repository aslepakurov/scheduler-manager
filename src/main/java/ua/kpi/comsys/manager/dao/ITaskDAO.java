package ua.kpi.comsys.manager.dao;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.TaskStatus;

/**
 * IExampleDAO Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskDAO {
    Task create(Task task);
    void save(Task task);
    Task get(String id);
    String delete(String id);
    void updateStatus(String id, TaskStatus newStatus);
}
