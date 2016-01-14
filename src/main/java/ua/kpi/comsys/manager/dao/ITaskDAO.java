package ua.kpi.comsys.manager.dao;

import ua.kpi.comsys.manager.domain.Task;

/**
 * IExampleDAO Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskDAO {
    String create(Task entity);
    Task get(String id);
}
