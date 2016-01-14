package ua.kpi.comsys.manager.dao;

import ua.kpi.comsys.manager.domain.TaskRequest;

/**
 * IExampleDAO Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskRequestDAO {
    String create(TaskRequest entity);
    TaskRequest get(String id);
}
