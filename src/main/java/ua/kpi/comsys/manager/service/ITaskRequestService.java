package ua.kpi.comsys.manager.service;

import ua.kpi.comsys.manager.domain.TaskRequest;

/**
 * IExampleService Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskRequestService {
    String create(TaskRequest entity);
    TaskRequest get(String id);
}
