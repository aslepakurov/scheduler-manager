package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.Task;

/**
 * IExampleService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskService {
    String create(Task entity);
    Task get(String id);
}
