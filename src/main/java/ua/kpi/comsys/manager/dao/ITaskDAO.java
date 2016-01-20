package ua.kpi.comsys.manager.dao;

import ua.kpi.comsys.manager.domain.Task;
import ua.kpi.comsys.manager.domain.dto.TastRequestDto;

/**
 * IExampleDAO Class
 *
 * @author aslepakurov
 * @version 1/14/2016
 */
public interface ITaskDAO {
    Task create(TastRequestDto task);
    Task get(String id);
}
